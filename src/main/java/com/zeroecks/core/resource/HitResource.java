package com.zeroecks.core.resource;

import com.zeroecks.core.domain.Stance;
import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiIncludeByDefault;
import io.katharsis.resource.annotations.JsonApiResource;
import io.katharsis.resource.annotations.JsonApiToOne;

@JsonApiResource(type = "hits")
public class HitResource {
    @JsonApiId
    private Long id;

    @JsonApiToOne
    @JsonApiIncludeByDefault
    private PlayerResource target;

    private String targetTag;
    private Stance targetStance;
    private String targetSide;
    private Vector targetPosition;
    private Vector targetAim;

    @JsonApiToOne
    @JsonApiIncludeByDefault
    private PlayerResource shooter;

    private String shooterTag;
    private Stance shooterStance;
    private String shooterSide;
    private Vector shooterPosition;
    private Vector shooterAim;

    private String cause;
    private Vector impact;
    private Vector velocity;
    private Vector normal;
    private float radius;
    private String type;
    private boolean direct;
    private String limb;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlayerResource getTarget() {
        return target;
    }

    public void setTarget(PlayerResource target) {
        this.target = target;
    }

    public String getTargetTag() {
        return targetTag;
    }

    public void setTargetTag(String targetTag) {
        this.targetTag = targetTag;
    }

    public Stance getTargetStance() {
        return targetStance;
    }

    public void setTargetStance(Stance targetStance) {
        this.targetStance = targetStance;
    }

    public String getTargetSide() {
        return targetSide;
    }

    public void setTargetSide(String targetSide) {
        this.targetSide = targetSide;
    }

    public Vector getTargetPosition() {
        return targetPosition;
    }

    public void setTargetPosition(Vector targetPosition) {
        this.targetPosition = targetPosition;
    }

    public Vector getTargetAim() {
        return targetAim;
    }

    public void setTargetAim(Vector targetAim) {
        this.targetAim = targetAim;
    }

    public PlayerResource getShooter() {
        return shooter;
    }

    public void setShooter(PlayerResource shooter) {
        this.shooter = shooter;
    }

    public String getShooterTag() {
        return shooterTag;
    }

    public void setShooterTag(String shooterTag) {
        this.shooterTag = shooterTag;
    }

    public Stance getShooterStance() {
        return shooterStance;
    }

    public void setShooterStance(Stance shooterStance) {
        this.shooterStance = shooterStance;
    }

    public String getShooterSide() {
        return shooterSide;
    }

    public void setShooterSide(String shooterSide) {
        this.shooterSide = shooterSide;
    }

    public Vector getShooterPosition() {
        return shooterPosition;
    }

    public void setShooterPosition(Vector shooterPosition) {
        this.shooterPosition = shooterPosition;
    }

    public Vector getShooterAim() {
        return shooterAim;
    }

    public void setShooterAim(Vector shooterAim) {
        this.shooterAim = shooterAim;
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

    public Vector getNormal() {
        return normal;
    }

    public void setNormal(Vector normal) {
        this.normal = normal;
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

    public String getLimb() {
        return limb;
    }

    public void setLimb(String limb) {
        this.limb = limb;
    }
}
