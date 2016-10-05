package com.zeroecks.core.repository;

import com.zeroecks.core.domain.Hit;
import com.zeroecks.core.domain.Player;
import com.zeroecks.core.persistence.HitRepository;
import com.zeroecks.core.persistence.PlayerRepository;
import com.zeroecks.core.resource.HitResource;
import com.zeroecks.core.resource.PlayerResource;
import io.katharsis.queryParams.QueryParams;
import io.katharsis.repository.RelationshipRepository;
import io.katharsis.repository.annotations.JsonApiAddRelations;
import io.katharsis.repository.annotations.JsonApiFindOneTarget;
import io.katharsis.repository.annotations.JsonApiRelationshipRepository;
import io.katharsis.repository.annotations.JsonApiSetRelation;
import io.katharsis.utils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@Component
@JsonApiRelationshipRepository(source = HitResource.class, target = PlayerResource.class)
public class HitToPlayerRelationshipRepository {
    @Autowired
    private ConversionService conversionService;

    @Autowired
    private PlayerResourceRepository playerRepository;

    @Autowired
    private HitResourceRepository hitRepository;

    @JsonApiSetRelation
    public void setRelation(HitResource hitResource, Long playerId, String field) {
        final PlayerResource player = playerRepository.findOne(playerId, null);
        try {
            PropertyUtils.setProperty(hitResource, field, player);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        hitRepository.save(hitResource);
    }

    @JsonApiFindOneTarget
    public PlayerResource findOneTarget(Long hitId, String fieldName, QueryParams queryParams) {
        final HitResource hit = hitRepository.findOne(hitId, queryParams);
        try {
            return (PlayerResource) PropertyUtils.getProperty(hit, fieldName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
