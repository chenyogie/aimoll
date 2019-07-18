package com.yogie.web.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.yogie.common.EmployeeExcelVerifyHandler;
import com.yogie.domain.Employee;
import com.yogie.service.IDepartmentService;
import com.yogie.service.IEmployeeService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @program: aimoll
 * @Date: 2019/7/15 21:14
 * @Author: Chenyogie
 * @Description:
 */
@Controller
@RequestMapping("/import")
public class ImportController {

    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IDepartmentService departmentService;
    @Autowired
    //自定义文件上传规则验证
    private EmployeeExcelVerifyHandler excelVerifyHandler;

    @RequestMapping("/index")
    public String index(){
        return "import";
    }

    @RequestMapping("/empxlsx")
    public String empxlsx(MultipartFile empFile, HttpServletResponse resp){
        System.out.println(empFile);
        System.out.println("==========================");
        //try-catch-resource结构
        try (InputStream inputStream = empFile.getInputStream();
             OutputStream ouputStream = resp.getOutputStream()){
            //设置基本参数配置
            ImportParams params = new ImportParams();
            //要求导入的时候做验证
            params.setNeedVerfiy(true);
            //设置自定义的验证处理器
            params.setVerifyHandler(excelVerifyHandler);
            //导入excel
            ExcelImportResult<Employee> result = ExcelImportUtil.importExcelMore(
                    inputStream,
                    Employee.class, params);
            //获取到引入成功的数据
            List<Employee> list = result.getList();
            list.forEach(e->{
                //System.out.println(e);
                //成功的保存到数据库中
                e.setPassword("123456");
                //设置状态为可用状态
                e.setStatus(true);
                employeeService.save(e);
            });
            //获到到失败的数据 -> 导出到前台，并在导出的文件注明导出失败的原因
            if(result.isVerfiyFail()) {
                //错误的文件
                Workbook wb = result.getFailWorkbook();
                resp.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"); //mime类型
                resp.setHeader("Content-disposition", "attachment;filename=error.xls");
                resp.setHeader("Pragma", "No-cache");//设置不要缓存
                wb.write(ouputStream);
                ouputStream.flush();
                ouputStream.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "import";
    }

}
