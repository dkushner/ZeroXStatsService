package com.zeroecks.core.repository;

import com.zeroecks.core.domain.Player;
import com.zeroecks.core.persistence.PlayerRepository;
import com.zeroecks.core.resource.PlayerResource;
import io.katharsis.queryParams.QueryParams;
import io.katharsis.repository.ResourceRepository;
import io.katharsis.repository.annotations.*;
import io.katharsis.resource.annotations.JsonApiResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@JsonApiResourceRepository(PlayerResource.class)
public class PlayerResourceRepository implements ResourceRepository<PlayerResource, Long> {
    @Autowired
    private PlayerRepository repository;

    @Autowired
    private ConversionService conversionService;

    @Override
    @JsonApiFindOne
    public PlayerResource findOne(Long id, QueryParams queryParams) {
        final Player result = repository.findOne(id);
        return conversionService.convert(result, PlayerResource.class);
    }

    @Override
    @JsonApiFindAll
    public Iterable<PlayerResource> findAll(QueryParams queryParams) {
        final Iterable<Player> results = repository.findAll();

        return StreamSupport.stream(results.spliterator(), false)
                .map(player -> conversionService.convert(player, PlayerResource.class))
                .collect(Collectors.toList());
    }

    @Override
    @JsonApiFindAllWithIds
    public Iterable<PlayerResource> findAll(Iterable<Long> ids, QueryParams queryParams) {
        final Iterable<Player> results = repository.findAll();

        return StreamSupport.stream(results.spliterator(), false)
                .map(player -> conversionService.convert(player, PlayerResource.class))
                .collect(Collectors.toList());
    }

    @Override
    @JsonApiSave
    public PlayerResource save(PlayerResource resource) {
        final Player player = conversionService.convert(resource, Player.class);
        return conversionService.convert(repository.save(player), PlayerResource.class);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
