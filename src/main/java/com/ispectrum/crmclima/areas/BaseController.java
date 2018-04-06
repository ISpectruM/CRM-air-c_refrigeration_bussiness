package com.ispectrum.crmclima.areas;


import org.springframework.web.servlet.ModelAndView;

public abstract class BaseController {
    private ModelAndView modelAndView;

    protected ModelAndView view(Object htmlPage){
        this.modelAndView = new ModelAndView("index");
        this.modelAndView.addObject("view",htmlPage);
        return this.modelAndView;
    }

    protected ModelAndView addViewObject(
            String name,
            Object object,
            String view){
        if (this.modelAndView == null ||
                !this.modelAndView.getViewName().equals(view)){
            this.modelAndView = new ModelAndView("index");
            this.modelAndView.addObject("view",view);
        }
        this.modelAndView.addObject(name,object);
        return this.modelAndView;
    }

    protected ModelAndView redirect(String url){
        return new ModelAndView("redirect:" + url);
    }
}
