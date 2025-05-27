package org.mdt.crewtaskmanagement.repository;

import org.mdt.crewtaskmanagement.model.MaterialUsageLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialUsageLogRepository extends JpaRepository<MaterialUsageLog,Long> {
}
