package com.eomaxl.traderappbackend.service.impl;

import com.eomaxl.traderappbackend.repository.FixSessionRepository;
import com.eomaxl.traderappbackend.service.FixService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FixServiceImpl implements FixService {
    private final FixSessionRepository repo;
    public List<FixSessionDto> getAllSessions() {
        return repo.findAll().stream().map(FixSessionDto::from).toList();
    }
}
