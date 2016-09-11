package com.zeroecks.core.resources;

import com.zeroecks.core.models.Death;
import com.zeroecks.core.persistence.DeathRepository;
import io.katharsis.queryParams.QueryParams;
import io.katharsis.repository.ResourceRepository;
import io.katharsis.repository.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@JsonApiResourceRepository(Death.class)
@Component
public class DeathResourceRepository implements ResourceRepository<Death, Long> {
    @Autowired
    private DeathRepository deathRepository;

    @Override
    @JsonApiFindOne
    public Death findOne(Long id, QueryParams params) {
        return deathRepository.findOne(id);
    }

    @Override
    @JsonApiFindAll
    public Iterable<Death> findAll(QueryParams params) {
        return deathRepository.findAll();
    }

    @Override
    @JsonApiFindAllWithIds
    public Iterable<Death> findAll(Iterable<Long> ids, QueryParams params) {
        return deathRepository.findAll(ids);
    }

    @Override
    @JsonApiSave
    public <S extends Death> S save(S entity) {
        return deathRepository.save(entity);
    }

    @Override
    @JsonApiDelete
    public void delete(Long id) {
        deathRepository.delete(id);
    }
}
