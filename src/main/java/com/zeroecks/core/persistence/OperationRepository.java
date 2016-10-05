package com.zeroecks.core.persistence;

import com.zeroecks.core.domain.Operation;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface OperationRepository extends CrudRepository<Operation, Long>,
        QueryDslPredicateExecutor<Operation> { }
