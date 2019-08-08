package com.neuedu.controller;

import com.neuedu.pojo.Category;
import com.neuedu.pojo.Product;
import com.neuedu.service.ICategoryService;
import com.neuedu.service.IProductService;
import com.neuedu.util.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by tao on 2019/8/7.
 */

@Controller
@RequestMapping("/user/product/")
public class ProductController {

    @Autowired
    IProductService productService;

    @Autowired
    ICategoryService categoryService;

    @RequestMapping("find")
    public String findAll(HttpSession session){
        List<Product> productList=productService.findAll();

        session.setAttribute("productlist",productList);

        return "productlist";

    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer productId){

        int i=productService.deleteProduct(productId);
        if(i==1){
            return "redirect:/user/product/find";
        }

        return "redirect:/user/product/find";
    }

    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    public String update(@PathVariable("id") Integer productId, HttpServletRequest request){

        Product product=productService.findProductById(productId);
        List<Category> categoryList=categoryService.findAll();

        request.setAttribute("allcategory",categoryList);
        request.setAttribute("product",product);

        return "productupdate";
    }

    @RequestMapping(value = "update/{id}",method = RequestMethod.POST)
    public String update(Product product,
                         @RequestParam("mainImage_file")MultipartFile mainImage,
                         @RequestParam("subImages_files") MultipartFile[] subImages,
                         HttpServletRequest request,
                         HttpServletResponse response)  {

        if(mainImage!=null&&subImages!=null&&subImages.length>0){

            product.setMainImage(UploadFile.upload(mainImage));

            StringBuffer stringBuffer=new StringBuffer();

            List<String> list=UploadFile.upload(subImages);

            stringBuffer.append("{\"subImages\":[");

            for(String name:list){
                stringBuffer.append("{\"url\":\""+name+"\"},");
            }

            stringBuffer.append("]}");
            product.setSubImages(stringBuffer.toString());

        }

        int count=productService.updateProduct(product);

        if(count>0){
            //修改成功
            return "redirect:/user/product/find";
        }

        return "redirect:/user/product/find";
    }

    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String add(HttpServletRequest request){
        List<Category> categoryList=categoryService.findAll();

        request.setAttribute("allcategory",categoryList);
        return "productadd";
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String add(Product product,
                      @RequestParam("mainImage_file")MultipartFile mainImage,
                      @RequestParam("subImages_files") MultipartFile[] subImages){



        if(mainImage!=null&&subImages!=null&&subImages.length>0){

            product.setMainImage(UploadFile.upload(mainImage));

            StringBuffer stringBuffer=new StringBuffer();

            List<String> list=UploadFile.upload(subImages);

            stringBuffer.append("{\"subImages\":[");

            for(String name:list){
                stringBuffer.append("{\"url\":\""+name+"\"},");
            }

            stringBuffer.append("]}");
            product.setSubImages(stringBuffer.toString());

        }


        if(productService.add(product)!=0){
            return "redirect:/user/product/find";
        }

        return "productadd";
    }

}
