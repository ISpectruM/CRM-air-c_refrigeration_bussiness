package com.ispectrum.crmclima.interceptors;

import com.ispectrum.crmclima.areas.orders.models.dtos.MontageOrderDto;
import com.ispectrum.crmclima.areas.orders.service.MontageOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

@Component
public class OrderInfoInterceptor extends HandlerInterceptorAdapter {
    private final MontageOrderService montageOrderService;

    @Autowired
    public OrderInfoInterceptor(MontageOrderService montageOrderService) {
        this.montageOrderService = montageOrderService;
    }

    private Integer getOrdersCount(){
        Set<MontageOrderDto> unfinishedMontages = this.montageOrderService.getAllUnfinishedOrders();
        return unfinishedMontages.size();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest req,
                              HttpServletResponse resp,
                              Object handler,
                              ModelAndView mav) throws Exception {
        if(mav != null){
            mav.addObject("ordersInfo",this.getResult(this.getOrdersCount()));
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    private String getResult(Integer montageCount){
        StringBuilder sb = new StringBuilder();

        sb.append("Незавършени монтажи:")
                .append(montageCount).append(System.lineSeparator());
        return sb.toString();
    }

}
