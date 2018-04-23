package com.ispectrum.crmclima.Utils;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class ModelMappingUtil {

    private final ModelMapper modelMapper;
    private ModelMappingUtil() {
        this.modelMapper = new ModelMapper();
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

    public static <S, D> Page<D> convertPage(Page<S> source, Class<D> destinationClass) {
        Page<D> resultList = source.map(s -> {
            ModelMapper mapper = new ModelMapper();
            D d = mapper.map(s, destinationClass);
            return d;
        });

        return resultList;
    }

}
