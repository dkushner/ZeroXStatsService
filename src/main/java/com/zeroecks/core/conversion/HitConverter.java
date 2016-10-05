package com.zeroecks.core.conversion;

import com.zeroecks.core.domain.Hit;
import com.zeroecks.core.resource.HitResource;
import com.zeroecks.core.resource.PlayerResource;
import com.zeroecks.core.resource.Vector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class HitConverter implements Converter<Hit, HitResource> {
    @Autowired
    private PlayerConverter playerConverter;

    @Override
    public HitResource convert(Hit hit) {
        final HitResource resource = new HitResource();
        resource.setId(hit.getId());
        resource.setTarget(playerConverter.convert(hit.getTarget()));
        resource.setTargetTag(hit.getTargetTag());
        resource.setTargetStance(hit.getTargetStance());
        resource.setTargetSide(hit.getTargetSide());

        resource.setTargetPosition(new Vector() {{
            setX(hit.getTargetPosition().getCoordinate().x);
            setY(hit.getTargetPosition().getCoordinate().y);
            setZ(hit.getTargetPosition().getCoordinate().z);
        }});

        resource.setTargetAim(new Vector() {{
            setX(hit.getTargetAim().getCoordinate().x);
            setY(hit.getTargetAim().getCoordinate().y);
            setZ(hit.getTargetAim().getCoordinate().z);
        }});

        resource.setShooter(playerConverter.convert(hit.getShooter()));
        resource.setShooterTag(hit.getShooterTag());
        resource.setShooterStance(hit.getShooterStance());
        resource.setShooterSide(hit.getShooterSide());

        resource.setShooterPosition(new Vector() {{
            setX(hit.getShooterPosition().getCoordinate().x);
            setY(hit.getShooterPosition().getCoordinate().y);
            setZ(hit.getShooterPosition().getCoordinate().z);
        }});

        resource.setShooterAim(new Vector() {{
            setX(hit.getShooterAim().getCoordinate().x);
            setY(hit.getShooterAim().getCoordinate().y);
            setZ(hit.getShooterAim().getCoordinate().z);
        }});

        resource.setImpact(new Vector() {{
            setX(hit.getImpact().getCoordinate().x);
            setY(hit.getImpact().getCoordinate().y);
            setZ(hit.getImpact().getCoordinate().z);
        }});

        resource.setVelocity(new Vector() {{
            setX(hit.getVelocity().getCoordinate().x);
            setY(hit.getVelocity().getCoordinate().y);
            setZ(hit.getVelocity().getCoordinate().z);
        }});

        resource.setNormal(new Vector() {{
            setX(hit.getNormal().getCoordinate().x);
            setY(hit.getNormal().getCoordinate().y);
            setZ(hit.getNormal().getCoordinate().z);
        }});

        resource.setRadius(hit.getRadius());
        resource.setType(hit.getType());
        resource.setDirect(hit.isDirect());
        resource.setLimb(hit.getLimb());

        return resource;
    }
}
