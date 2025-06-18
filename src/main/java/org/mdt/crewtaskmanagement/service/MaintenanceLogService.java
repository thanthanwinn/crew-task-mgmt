package org.mdt.crewtaskmanagement.service;

import lombok.RequiredArgsConstructor;
import org.mdt.crewtaskmanagement.model.MaintenanceLog;
import org.mdt.crewtaskmanagement.repository.entity.MaintenanceLogRepository;
import org.mdt.crewtaskmanagement.repository.entity.MaterialRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class MaintenanceLogService {
    private final MaintenanceLogRepository maintenanceLogRepository;
    private final MaterialRepository materialRepo;

    public void logMaintenance(Long materialId, String remarks, String interval, String performedBy) {
        MaintenanceLog log = new MaintenanceLog();
        log.setMaterial(materialRepo.findById(materialId).orElseThrow());
        log.setMaintainedBy(performedBy);
        log.setRemark(remarks);
        log.setMaintainedDate(LocalDate.now());
        log.getMaterial().setLifeTime(interval);  // e.g., "3 months"
        maintenanceLogRepository.save(log);  // `@PrePersist` sets `nextDueDate`
    }



}
