package com.zeroecks.core.persistence;

import com.zeroecks.core.domain.Death;
import org.springframework.data.repository.CrudRepository;

public interface DeathRepository extends CrudRepository<Death, Long> { }
