package com.yogie.common;

import cn.afterturn.easypoi.excel.entity.result.ExcelVerifyHandlerResult;
import cn.afterturn.easypoi.handler.inter.IExcelVerifyHandler;
import com.yogie.domain.Employee;
import com.yogie.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: aimoll
 * @Date: 2019/7/15 23:15
 * @Author: Chenyogie
 * @Description: 上传文件自定义验证规则
 */
@Component
public class EmployeeExcelVerifyHandler implements IExcelVerifyHandler<Employee> {

    @Autowired
    private IEmployeeService employeeService;


    @Override
    public ExcelVerifyHandlerResult verifyHandler(Employee employee) {
        //获取要返回的对象
        ExcelVerifyHandlerResult result = new ExcelVerifyHandlerResult();
        String username = employee.getUsername();
        if(!employeeService.checkName(username)){
            result.setSuccess(false);
            result.setMsg("该用户名已经存在。");
        }
        return result;
    }
}
