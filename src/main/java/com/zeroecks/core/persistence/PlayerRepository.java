package com.zeroecks.core.persistence;

import com.zeroecks.core.domain.Player;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long>,
        QueryDslPredicateExecutor<Player> { }
