package com.zeroecks.core.domain;

import com.vividsolutions.jts.geom.Point;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Hit implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    private Player target;

    @Column(nullable = false)
    private String targetTag;

    @Enumerated(EnumType.STRING)
    private Stance targetStance;

    @Column(nullable = false)
    private String targetSide;

    @Column(nullable = false)
    private Point targetPosition;

    @Column(nullable = false)
    private Point targetAim;

    @OneToOne(cascade = CascadeType.MERGE)
    private Player shooter;

    @Column(nullable = false)
    private String shooterTag;

    @Enumerated(EnumType.STRING)
    private Stance shooterStance;

    @Column(nullable = false)
    private String shooterSide;

    @Column(nullable = false)
    private Point shooterPosition;

    @Column(nullable = false)
    private Point shooterAim;

    @Column(nullable = false)
    private String cause;

    @Column(nullable = false)
    private Point impact;

    @Column(nullable = false)
    private Point velocity;

    @Column(nullable = false)
    private Point normal;

    @Column(nullable = false)
    private float radius;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private boolean direct;

    @Column(nullable = false)
    private String limb;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getTarget() {
        return target;
    }

    public void setTarget(Player target) {
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

    public Point getTargetPosition() {
        return targetPosition;
    }

    public void setTargetPosition(Point targetPosition) {
        this.targetPosition = targetPosition;
    }

    public Point getTargetAim() {
        return targetAim;
    }

    public void setTargetAim(Point targetAim) {
        this.targetAim = targetAim;
    }

    public Player getShooter() {
        return shooter;
    }

    public void setShooter(Player shooter) {
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

    public Point getShooterPosition() {
        return shooterPosition;
    }

    public void setShooterPosition(Point shooterPosition) {
        this.shooterPosition = shooterPosition;
    }

    public Point getShooterAim() {
        return shooterAim;
    }

    public void setShooterAim(Point shooterAim) {
        this.shooterAim = shooterAim;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Point getImpact() {
        return impact;
    }

    public void setImpact(Point impact) {
        this.impact = impact;
    }

    public Point getVelocity() {
        return velocity;
    }

    public void setVelocity(Point velocity) {
        this.velocity = velocity;
    }

    public Point getNormal() {
        return normal;
    }

    public void setNormal(Point normal) {
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
