package com.zeroecks.core.persistence;

import com.zeroecks.core.models.Death;
import org.springframework.data.repository.CrudRepository;

public interface DeathRepository extends CrudRepository<Death, Long> { }
