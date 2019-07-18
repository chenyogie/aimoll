package com.yogie.web.controller;


import com.yogie.common.JsonResult;
import com.yogie.common.UIPage;
import com.yogie.common.UUIDUtil;
import com.yogie.domain.Product;
import com.yogie.query.ProductQuery;
import com.yogie.service.IProductService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.TrustAnchor;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * (Product)实体类
 *
 * @author Chenyogie
 * @since 2019-07-16 10:36:55
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/index")
    public String index() {
        return "product/product";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Product> findAll() {
        return productService.findAll();
    }

    @RequestMapping("/findPage")
    @ResponseBody
    public UIPage<Product> findPage(ProductQuery baseQuery) {
        Page page = productService.findPageByQuery(baseQuery);
        return new UIPage(page);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(Long id, HttpServletRequest request) {
        try {
            Product product = productService.findOne(id);
            //删除时，同时删除图片
            String webapp = request.getServletContext().getRealPath("/");
            File file = null;
            file = new File(webapp + product.getPic());
            file.delete();
            file = new File(webapp + product.getSmallpic());
            file.delete();
            productService.delete(id);
            return new JsonResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, e.getMessage());
        }

    }

    /**
     * 设计这个方法是为了解决在修改员工的时候会产生数据丢失的问题。
     * springmvc的@ModelAttribute注解会在每个controller的每个方法前面执行
     *
     * @param id
     * @param cmd
     * @return
     */
    @ModelAttribute("editProduct")
    public Product beforeEdit(Long id, String cmd) {
        if (id != null && "_update".equals(cmd)) {
            Product product = productService.findOne(id);
            /**
             * 这个方法的设计是为了解决当前台修改部门的时候，调教修改的时候会报错：n to n
             * 这个错误的原因是：当修改部门的时候，实际上是修改的product对应的持久化对象的department持久化对象的oid
             * 解决办法就是：直接将员工关联的department对象设置为null
             * 然后springmvc会根据前台的department.id自动创建一个非持久的department对象
             */
            //product.setDepartment(null);
            return product;
        }
        return null;
    }

    /**
     * 当在进行修改的时候，修改员工的时候会产生数据丢失现象
     * 然后将注解部分连同参数一起作为修饰参数的save方法
     *
     * @param product
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(@ModelAttribute("editProduct") Product product) {
        try {
            productService.save(product);
            return new JsonResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, e.getMessage());
        }
    }


    @RequestMapping("/save")
    @ResponseBody
    public JsonResult save(@RequestParam(value = "lgPic", required = false) MultipartFile lgPic,
                           @RequestParam(value = "smPic", required = false) MultipartFile smPic,
                           Product product,
                           HttpServletRequest request){
        try {
            String lg = uploadFile(lgPic, product, request);
            String sm = uploadFile(smPic, product, request);
            //设置保存路径
            product.setPic(lg);
            product.setSmallpic(sm);
            //保存数据
            productService.save(product);
        } catch (IOException e) {
            e.printStackTrace();
            return new JsonResult(false,e.getMessage());
        }
        return new JsonResult(true, "添加成功！");
    }

    public String uploadFile(MultipartFile pic,Product product, HttpServletRequest request) throws IOException {
        //获取到上下文路径，拼接一个上传目录
        String webapp = request.getServletContext().getRealPath("/");
        String result = null;
        try {

            String upload = webapp + "/upload";
            File file = new File(upload);
            //如果upload路径不存在，就创建
            if (!file.exists()) {
                file.mkdirs();
            }
            if (pic != null) {
                //大图名称
                String picName = UUIDUtil.getFileNameByUUID() + ".jpg";
                //获取两张图的输入流
                InputStream lgPicInputStream = pic.getInputStream();
                //输出路径
                File savePath = new File(file, picName);
                //写入文件
                IOUtils.copy(lgPicInputStream, new FileOutputStream(savePath));
                //将文件的路径保存到数据库
                /*product.setPic();*/
                result = savePath.getAbsolutePath().substring(webapp.length() - 1).replace('\\', '/');
            }
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
        return result;
    }
}
