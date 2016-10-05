package com.zeroecks.core.persistence;

import com.zeroecks.core.domain.Hit;
import org.springframework.data.repository.CrudRepository;

public interface HitRepository extends CrudRepository<Hit, Long> { }
