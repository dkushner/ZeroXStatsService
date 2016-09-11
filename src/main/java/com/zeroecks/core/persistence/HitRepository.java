package com.zeroecks.core.persistence;

import com.zeroecks.core.models.Hit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

public interface HitRepository extends CrudRepository<Hit, Long> { }
