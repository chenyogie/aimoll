package com.yogie.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;

/**
 * @program: aimoll
 * @Date: 2019/7/9 21:42
 * @Author: Chenyogie
 * @Description:
 */
public class VelocityTest {
    @Test
    public void test() throws Exception {
        //创建模本应用上下文
        VelocityContext context = new VelocityContext();
        //填充数据
        context.put("msg","Hello World！");
        //加载模板
        Template template = Velocity.getTemplate("template/new.html","UTF-8");
        //封装文本（目标文件）的位置
        FileWriter writer = new FileWriter(new File("template/new_1.html"));
        //将数据写到模板中
        template.merge(context,writer);
        writer.close();
    }
}
