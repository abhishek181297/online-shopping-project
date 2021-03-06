package com.abhishek.onlineshoppingfront.controller;

import com.abhishek.onlineshoppingfront.dto.Category;
import com.abhishek.onlineshoppingfront.helpers.CategoryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    @Autowired
    private CategoryHelper categoryHelper;

    @RequestMapping(value = {"/", "/home", "/index"})
    public ModelAndView index() {

        ModelAndView mv = new ModelAndView("page");
        mv.addObject("greeting", "Welcome to OnlineShopping !!!");
        mv.addObject("title", "Home");
        mv.addObject("userClickHome", true);
        mv.addObject("categories", categoryHelper.getActiveCategoryList());
        return mv;
    }
    @RequestMapping(value = "/about")
    public ModelAndView about() {

        ModelAndView mv = new ModelAndView("page");
        mv.addObject("greeting", "Welcome to OnlineShopping !!!");
        mv.addObject("title", "About");
        mv.addObject("userClickAbout", true);
        return mv;
    }
    @RequestMapping(value = "/contact")
    public ModelAndView contact() {

        ModelAndView mv = new ModelAndView("page");
        mv.addObject("greeting", "Welcome to OnlineShopping !!!");
        mv.addObject("title", "Contact");
        mv.addObject("userClickContact", true);
        return mv;
    }

    @RequestMapping(value = "/test")
    public ModelAndView test(
            @RequestParam(value = "greeting",
                    required = false,
                    defaultValue = "Welcome to Test OnlineShopping") String greeting) {

        ModelAndView mv = new ModelAndView("page");
        mv.addObject("greeting", greeting);
        return mv;
    }

    @RequestMapping(value = "/show/all/products")
    public ModelAndView showAllProducts() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("greeting", "Welcome to OnlineShopping !!!");
        mv.addObject("title", "All Products");
        mv.addObject("userClickAllProducts", true);
        mv.addObject("categories", categoryHelper.getActiveCategoryList());
        return mv;
    }

    @RequestMapping(value = "/show/category/{id}/products")
    public ModelAndView showCategoryProducts(@PathVariable(value = "id") Long categoryId) {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("greeting", "Welcome to OnlineShopping !!!");
        Category category = categoryHelper.getCategoryById(categoryId);
        String categoryName = "Category";
        if (category != null) {
            categoryName = category.getName();
        }
        mv.addObject("title", categoryName);
        mv.addObject("userClickCategoryProducts", true);
        mv.addObject("categories", categoryHelper.getActiveCategoryList());
        mv.addObject("category", category);
        return mv;
    }

}
