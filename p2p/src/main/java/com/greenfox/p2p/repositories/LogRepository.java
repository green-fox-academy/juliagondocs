package com.greenfox.p2p.repositories;

import com.greenfox.p2p.models.LogTracker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends CrudRepository<LogTracker,Long> {

}
