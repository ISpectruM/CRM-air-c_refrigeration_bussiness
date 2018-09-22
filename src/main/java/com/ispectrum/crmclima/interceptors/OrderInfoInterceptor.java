package com.ispectrum.crmclima.interceptors;

import com.ispectrum.crmclima.areas.orders.service.MontageOrderService;
import com.ispectrum.crmclima.areas.orders.service.ProphylacticOrderService;
import com.ispectrum.crmclima.areas.orders.service.RepairOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class OrderInfoInterceptor extends HandlerInterceptorAdapter {
    private final MontageOrderService montageOrderService;
    private final RepairOrderService repairOrderService;
    private final ProphylacticOrderService prophylacticOrderService;

    @Autowired
    public OrderInfoInterceptor(
            MontageOrderService montageOrderService,
            RepairOrderService repairOrderService,
            ProphylacticOrderService prophylacticOrderService) {
        this.montageOrderService = montageOrderService;
        this.repairOrderService = repairOrderService;
        this.prophylacticOrderService = prophylacticOrderService;
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
        Integer montages = this.getOrdersCount();
        Integer repairsCount = this.getRepairsCount();
        Integer prophylacticsCount = getProphylacticsCount();

        if(mav != null){
            mav.addObject("ordersInfo",this.getResult(montages,repairsCount, prophylacticsCount));
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    private String getResult(Integer montageCount,Integer repairsCount, Integer prophylCount){
        StringBuilder sb = new StringBuilder();

        sb
            .append("Монтажи: ")
            .append(montageCount)
                .append(" | ")
            .append(" Ремонти: ").append(repairsCount)
                .append(" | ")
            .append(" Профилактики: ").append(prophylCount);
        return sb.toString();
    }

    private Integer getOrdersCount(){
        return  this.montageOrderService.getAllUnfinishedMontagesCount();
    }

    private Integer getRepairsCount(){
        return this.repairOrderService.getAllUnfinishedRepairsCount();
    }

    private Integer getProphylacticsCount() {
        return this.prophylacticOrderService.getAllActiveOrdersCount();
    }


}
