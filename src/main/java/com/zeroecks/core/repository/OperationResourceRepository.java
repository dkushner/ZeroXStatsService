package com.zeroecks.core.repository;

import com.zeroecks.core.domain.Operation;
import com.zeroecks.core.persistence.OperationRepository;
import com.zeroecks.core.resource.OperationResource;
import io.katharsis.queryParams.QueryParams;
import io.katharsis.repository.ResourceRepository;
import io.katharsis.repository.annotations.JsonApiFindOne;
import io.katharsis.repository.annotations.JsonApiResourceRepository;
import io.katharsis.repository.annotations.JsonApiSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Component
@JsonApiResourceRepository(OperationResource.class)
public class OperationResourceRepository implements ResourceRepository<OperationResource, Long> {
    @Autowired
    private OperationRepository repository;

    @Autowired
    private ConversionService conversionService;

    @Override
    public OperationResource findOne(Long id, QueryParams queryParams) {
        final Operation result = repository.findOne(id);
        return conversionService.convert(result, OperationResource.class);
    }

    @Override
    public Iterable<OperationResource> findAll(QueryParams queryParams) {
        final Iterable<Operation> results = repository.findAll();
        return StreamSupport.stream(results.spliterator(), false)
                .map(operation -> conversionService.convert(operation, OperationResource.class))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<OperationResource> findAll(Iterable<Long> ids, QueryParams queryParams) {
        final Iterable<Operation> results = repository.findAll(ids);
        return StreamSupport.stream(results.spliterator(), false)
                .map(operation -> conversionService.convert(operation, OperationResource.class))
                .collect(Collectors.toList());
    }

    @Override
    @JsonApiSave
    public OperationResource save(OperationResource resource) {
        final Operation operation = conversionService.convert(resource, Operation.class);
        return conversionService.convert(repository.save(operation), OperationResource.class);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
