package com.ispectrum.crmclima.validation;

import org.apache.commons.beanutils.PropertyUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;

public class AtLeastOneFieldNotNulValidator implements ConstraintValidator<AtLeastOneFieldNotNull,Object> {

    private String[] fieldNames;

    @Override
    public void initialize(AtLeastOneFieldNotNull constraintAnnotation) {
        this.fieldNames = constraintAnnotation.fieldNames();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {

        if (object == null){
            return true;
        }
        try {
            for (String fieldName : fieldNames) {
                Object field = PropertyUtils.getProperty(object,fieldName);
                if (!field.equals("") || field.getClass().isArray()){
                    return true;
                }
            }
            return false;

        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
