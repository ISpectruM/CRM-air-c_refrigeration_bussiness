package com.ispectrum.crmclima.areas;


import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

public abstract class BaseController {
    private ModelAndView modelAndView;

    protected ModelAndView setView(String htmlPage){
        this.modelAndView = new ModelAndView("index");
        this.modelAndView.addObject("view",htmlPage);
        return this.modelAndView;
    }

    protected  ModelAndView addViewAndObjectsMap(String htmlPage,Map<String, Object> model){
        ModelAndView modelAndView = this.setView(htmlPage);
        modelAndView.addAllObjects(model);
        return modelAndView;
    }

    protected ModelAndView addObjectToView(String name, Object object){
        return this.modelAndView.addObject(name,object);
    }

    protected ModelAndView addViewAndObject(
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

    public ModelAndView getModelAndView() {
        return this.modelAndView;
    }
}
