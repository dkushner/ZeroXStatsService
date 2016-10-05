package com.zeroecks.core.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Connected implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Player player;
}
