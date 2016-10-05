package com.zeroecks.core.conversion;

import com.zeroecks.core.domain.Operation;
import com.zeroecks.core.resource.OperationResource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OperationResourceConverter implements Converter<OperationResource, Operation> {
    @Override
    public Operation convert(OperationResource resource) {
        final Operation operation = new Operation();
        operation.setId(resource.getId());
        operation.setMap(resource.getMap());
        operation.setStarted(resource.getStarted());
        return operation;
    }
}
