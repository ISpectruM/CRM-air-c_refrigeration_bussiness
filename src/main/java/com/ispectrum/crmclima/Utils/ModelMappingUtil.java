package com.ispectrum.crmclima.Utils;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hibernate.query.criteria.internal.ValueHandlerFactory.convert;

public final class ModelMappingUtil {
    private ModelMappingUtil() {
    }

    public static <S, D> D convertClass(S source, Class<D> destinationClass) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(source, destinationClass);
    }

    public static <S, D> Set<D> convertSet(Iterable<S> sourceIter, Class<D> destinationClass) {
        Set<D> resultSet = new HashSet<>();
        for (S s : sourceIter) {
            D d = convertClass(s, destinationClass);
            resultSet.add(d);
        }

        return resultSet;
    }

    public static <S, D> List<D> convertList(Iterable<S> source, Class<D> destinationClass) {
        List<D> resultList = new ArrayList<>();
        for (S s : source) {
            D d = convertClass(s, destinationClass);
            resultList.add(d);
        }
        return resultList;
    }

}
