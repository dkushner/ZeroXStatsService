package com.zeroecks.core.conversion;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.zeroecks.core.domain.Hit;
import com.zeroecks.core.domain.Player;
import com.zeroecks.core.resource.HitResource;
import com.zeroecks.core.resource.Vector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class HitResourceConverter implements Converter<HitResource, Hit> {
    @Autowired
    private PlayerResourceConverter playerResourceConverter;

    @Override
    public Hit convert(HitResource resource) {
        final GeometryFactory geometryFactory = new GeometryFactory();

        final Hit hit = new Hit();
        hit.setId(resource.getId());
        hit.setTarget(playerResourceConverter.convert(resource.getTarget()));
        hit.setTargetTag(resource.getTargetTag());
        hit.setTargetStance(resource.getTargetStance());
        hit.setTargetSide(resource.getTargetSide());

        final Vector targetPositionVector = resource.getTargetPosition();
        final Point targetPosition = geometryFactory.createPoint(new Coordinate(targetPositionVector.getX(),
                targetPositionVector.getY(), targetPositionVector.getZ()));
        hit.setTargetPosition(targetPosition);

        final Vector targetAimVector = resource.getTargetAim();
        final Point targetAim = geometryFactory.createPoint(new Coordinate(targetAimVector.getX(),
                targetAimVector.getY(), targetAimVector.getZ()));
        hit.setTargetAim(targetAim);

        hit.setShooter(playerResourceConverter.convert(resource.getShooter()));
        hit.setShooterTag(resource.getShooterTag());
        hit.setShooterStance(resource.getTargetStance());
        hit.setShooterSide(resource.getTargetSide());

        final Vector shooterPositionVector = resource.getShooterPosition();
        final Point shooterPosition = geometryFactory.createPoint(new Coordinate(shooterPositionVector.getX(),
                shooterPositionVector.getY(), shooterPositionVector.getZ()));
        hit.setShooterPosition(shooterPosition);

        final Vector shooterAimVector = resource.getShooterAim();
        final Point shooterAim = geometryFactory.createPoint(new Coordinate(shooterAimVector.getX(),
                shooterAimVector.getY(), shooterAimVector.getZ()));
        hit.setShooterAim(shooterAim);

        hit.setCause(resource.getCause());

        final Point impact = geometryFactory.createPoint(new Coordinate(resource.getImpact().getX(),
                resource.getImpact().getY(), resource.getImpact().getZ()));
        hit.setImpact(impact);

        final Point velocity = geometryFactory.createPoint(new Coordinate(resource.getVelocity().getX(),
            resource.getVelocity().getY(), resource.getVelocity().getZ()));
        hit.setVelocity(velocity);

        final Point normal = geometryFactory.createPoint(new Coordinate(resource.getNormal().getX(),
                resource.getNormal().getY(), resource.getNormal().getZ()));
        hit.setNormal(normal);

        hit.setRadius(resource.getRadius());
        hit.setType(resource.getType());
        hit.setDirect(resource.isDirect());
        hit.setLimb(resource.getLimb());

        return hit;
    }
}
