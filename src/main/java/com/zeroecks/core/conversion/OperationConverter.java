package com.zeroecks.core.conversion;

import com.zeroecks.core.domain.Operation;
import com.zeroecks.core.resource.OperationResource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OperationConverter implements Converter<Operation, OperationResource> {
    @Override
    public OperationResource convert(Operation operation) {
        final OperationResource resource = new OperationResource();
        resource.setId(operation.getId());
        resource.setMap(operation.getMap());
        resource.setStarted(operation.getStarted());
        return resource;
    }
}
