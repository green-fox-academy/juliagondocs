package com.greenfox.p2p.services;

import com.greenfox.p2p.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LogServiceImpl implements LogService{
    private LogRepository repo;

    @Autowired
    public LogServiceImpl(LogRepository repo) {
        this.repo = repo;
    }
}
