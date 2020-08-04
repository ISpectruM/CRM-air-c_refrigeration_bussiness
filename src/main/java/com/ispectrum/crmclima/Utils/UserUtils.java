package com.ispectrum.crmclima.Utils;

import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtils {

    public static String getCurrentUserName(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
