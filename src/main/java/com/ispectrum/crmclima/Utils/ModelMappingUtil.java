package com.ispectrum.crmclima.Utils;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.lang.reflect.Type;
import java.util.Set;

public final class ModelMappingUtil {
        private ModelMappingUtil() {
        }

        public static <S, D> D convertClass(S source, Class<D> destinationClass) {
            ModelMapper mapper = new ModelMapper();
            return mapper.map(source, destinationClass);
        }

        public static <S, D> Set<D> convertSet(Iterable<S> sourceIter, Class<D> destinationClass) {
            ModelMapper mapper = new ModelMapper();
            Type setType = new TypeToken<Set<D>>(){}.getType();
            return mapper.map(sourceIter, setType);
        }
}
