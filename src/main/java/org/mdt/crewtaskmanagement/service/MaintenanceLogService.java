package org.mdt.crewtaskmanagement.service;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.RequiredArgsConstructor;
import org.mdt.crewtaskmanagement.model.Maintenance;
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
        Maintenance log = new Maintenance();
        log.setMaterial(materialRepo.findById(materialId).orElseThrow());
        log.setMaintainedBy(performedBy);
        log.setRemark(remarks);
        log.setMaintainedDate(LocalDate.now());
        log.getMaterial().setLifeTime(interval);  // e.g., "3 months"
        maintenanceLogRepository.save(log);  // `@PrePersist` sets `nextDueDate`
    }

    @PrePersist
    @PreUpdate
    public LocalDate calculateNextDueDate(LocalDate maintainedDate,String lifeTime) {
        LocalDate nextDueDate = LocalDate.now();
        if (maintainedDate != null) {
            nextDueDate = switch (lifeTime.toLowerCase()) {
                case "3 months" -> maintainedDate.plusMonths(3);
                case "6 months" -> maintainedDate.plusMonths(6);
                case "1 year" -> maintainedDate.plusYears(1);
                case "1 month" -> maintainedDate.plusMonths(1);
                default -> null; // or throw exception/log
            };
        }
        return nextDueDate;0
    }



}
