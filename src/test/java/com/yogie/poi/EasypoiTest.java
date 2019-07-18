package com.yogie.poi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: aimoll
 * @Date: 2019/7/14 11:32
 * @Author: Chenyogie
 * @Description:
 */
public class EasypoiTest {

    @Test
    public void testExport() throws IOException {
        List<POIEmployee> list = new ArrayList<>();

        POIEmployee emp1 = new POIEmployee();
        emp1.setId(1L);
        emp1.setName("小胖砸");
        emp1.setEmail("pang@gmail.com");
        emp1.setSex(true);
        emp1.setHeadImg("recycle_full.png");

        POIEmployee emp2 = new POIEmployee();
        emp2.setId(2L);
        emp2.setName("大胖砸");
        emp2.setEmail("dapang@gmail.com");
        emp2.setSex(false);
        emp2.setHeadImg("recycle_null.png");

        list.add(emp1);
        list.add(emp2);

        /**
         *
         */
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("员工一览表","员工一览表"),
                POIEmployee .class, list);

        FileOutputStream out = new FileOutputStream(new File("emp.xls"));
        workbook.write(out);
        out.close();
        workbook.close();
    }
}
