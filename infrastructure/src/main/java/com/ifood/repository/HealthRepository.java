package com.ifood.repository;

import com.ifood.entity.ConnectionHealthSignalEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface HealthRepository {

    void insertSignalRegistry(ConnectionHealthSignalEntity connectionHealthSignalEntity);

    List<ConnectionHealthSignalEntity> findHealthHistory(String restaurantCode, LocalDateTime startDate, LocalDateTime endDate);

    List<ConnectionHealthSignalEntity> findHealthHistory(List<String> restaurantCode, LocalDateTime startDate, LocalDateTime endDate);
}
