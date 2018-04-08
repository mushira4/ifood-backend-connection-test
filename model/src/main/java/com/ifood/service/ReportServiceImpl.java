package com.ifood.service;

import com.ifood.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private HealthService healthService;

    @Autowired
    private UnavailabilityScheduleService unavailabilityScheduleService;

    @Override
    public ConnectionReport fetchReport(String restaurantCode, LocalDateTime startDate, LocalDateTime endDate) {
        List<ConnectionHealthSignal> healthHistory = healthService.findHealthHistory(restaurantCode, startDate, endDate);
        RestaurantConnection restaurantConnection = new RestaurantConnection(healthHistory);

        List<UnavailabilitySchedule> unavailabilitySchedule = unavailabilityScheduleService.fetchUnavailabilitySchedule(restaurantCode, startDate, endDate);
        RestaurantAvailability restaurantAvailability = new RestaurantAvailability(unavailabilitySchedule);

        return new ConnectionReport(restaurantAvailability, restaurantConnection);
    }

}