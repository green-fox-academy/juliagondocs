package com.greenfox.p2p.repositories;

import com.greenfox.p2p.models.LogTracker;
import org.springframework.data.repository.CrudRepository;

public interface LogRepository extends CrudRepository<LogTracker,Long> {

}
