package com.ispectrum.crmclima.areas.search.controller;

import com.ispectrum.crmclima.areas.BaseController;
import com.ispectrum.crmclima.areas.clients.models.dtos.ClientDto;
import com.ispectrum.crmclima.areas.search.SearchService;
import com.ispectrum.crmclima.areas.search.models.SearchBindingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
public class SearchController extends BaseController{

    private final SearchService searchService;


    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search")
    public ModelAndView showSearchResults(){
        return this.getMav();
    }

    @PostMapping("/search")
    public ModelAndView search(SearchBindingModel searchBindingModel){
        Set<ClientDto> results = this.searchService.getSearchResults(searchBindingModel);
        this.addViewAndObject("results",results,"clients/results");
        return this.redirect("/search");
    }
}
