package com.zeroecks.core.models;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@JsonApiResource(type = "hits")
public class Hit implements Serializable {
    @Id
    @JsonApiId
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String target;

    @Column(nullable = false)
    private String tag;

    @Column(nullable = false)
    private String shooter;

    @Column(nullable = false)
    private String cause;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "x", column = @Column(name = "impactX")),
            @AttributeOverride(name = "y", column = @Column(name = "impactY")),
            @AttributeOverride(name = "z", column = @Column(name = "impactZ"))
    })
    private Vector impact;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "x", column = @Column(name = "velocityX")),
            @AttributeOverride(name = "y", column = @Column(name = "velocityY")),
            @AttributeOverride(name = "z", column = @Column(name = "velocityZ"))
    })
    private Vector velocity;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "x", column = @Column(name = "surfaceX")),
            @AttributeOverride(name = "y", column = @Column(name = "surfaceY")),
            @AttributeOverride(name = "z", column = @Column(name = "surfaceZ"))
    })
    private Vector surface;

    @Column(nullable = false)
    private float radius;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private boolean direct;

    @Column(nullable = false)
    private String[] limbs;

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getShooter() {
        return shooter;
    }

    public void setShooter(String shooter) {
        this.shooter = shooter;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Vector getImpact() {
        return impact;
    }

    public void setImpact(Vector impact) {
        this.impact = impact;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }

    public Vector getSurface() {
        return surface;
    }

    public void setSurface(Vector surface) {
        this.surface = surface;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isDirect() {
        return direct;
    }

    public void setDirect(boolean direct) {
        this.direct = direct;
    }

    public String[] getLimbs() {
        return limbs;
    }

    public void setLimbs(String[] limbs) {
        this.limbs = limbs;
    }
}
