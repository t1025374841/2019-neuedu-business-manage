package com.neuedu.controller;

import com.neuedu.pojo.Category;
import com.neuedu.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by tao on 2019/8/6.
 */

@Controller
@RequestMapping("/user/category/")
public class CategoryController {

    @Autowired
    ICategoryService categoryService;

    @RequestMapping("find")
    public String findAll(HttpSession session){
        List<Category> categoryList = categoryService.findAll();

        session.setAttribute("categorylist",categoryList);

        return "categorylist";

    }

    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    public String update(@PathVariable("id") Integer categoryId, HttpServletRequest request){

        Category category = categoryService.findCategoryById(categoryId);
        List<Category> categoryList=categoryService.findAll();

        request.setAttribute("category",category);
        request.setAttribute("allcategory",categoryList);

        return "categoryupdate";
    }

    @RequestMapping(value = "update/{id}",method = RequestMethod.POST)
    public String update(Category category, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {


        int count = categoryService.updateCategory(category);

        if(count>0){
            //修改成功
            return "redirect:/user/category/find";
        }

        return "redirect:/user/category/find";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer categoryId){

        int i=categoryService.deleteCategory(categoryId);
        if(i==1){
            return "redirect:/user/category/find";
        }

        return "redirect:/user/category/find";
    }

    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String add(HttpServletRequest request){
        List<Category> categoryList=categoryService.findAll();
        System.out.println(categoryList);
        request.setAttribute("allcategory",categoryList);

        return "categoryadd";
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String add(Category category, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {


        int count = categoryService.addCategory(category);

        if(count>0){
            //修改成功
            return "redirect:/user/category/find";
        }

        return "redirect:/user/category/find";
    }


}
