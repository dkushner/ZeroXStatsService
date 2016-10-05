package com.zeroecks.core.repository;

import com.zeroecks.core.domain.Hit;
import com.zeroecks.core.persistence.HitRepository;
import com.zeroecks.core.resource.HitResource;
import io.katharsis.queryParams.QueryParams;
import io.katharsis.repository.ResourceRepository;
import io.katharsis.repository.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@JsonApiResourceRepository(HitResource.class)
public class HitResourceRepository implements ResourceRepository<HitResource, Long> {

    @Autowired
    private HitRepository repository;

    @Autowired
    private ConversionService conversionService;

    @Override
    public HitResource findOne(Long id, QueryParams queryParams) {
        final Hit result = repository.findOne(id);
        return conversionService.convert(result, HitResource.class);
    }

    @Override
    public Iterable<HitResource> findAll(QueryParams queryParams) {
        final Iterable<Hit> results = repository.findAll();
        return StreamSupport.stream(results.spliterator(), false)
                .map(hit -> conversionService.convert(hit, HitResource.class))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<HitResource> findAll(Iterable<Long> ids, QueryParams queryParams) {
        final Iterable<Hit> results = repository.findAll(ids);
        return StreamSupport.stream(results.spliterator(), false)
                .map(hit -> conversionService.convert(hit, HitResource.class))
                .collect(Collectors.toList());
    }

    @Override
    @JsonApiSave
    public HitResource save(HitResource resource) {
        final Hit hit = conversionService.convert(resource, Hit.class);
        return conversionService.convert(repository.save(hit), HitResource.class);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}

