package org.mdt.crewtaskmanagement.repository;

import org.mdt.crewtaskmanagement.model.MaintenanceLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceLogRepository extends JpaRepository<MaintenanceLog, Long> {
}
