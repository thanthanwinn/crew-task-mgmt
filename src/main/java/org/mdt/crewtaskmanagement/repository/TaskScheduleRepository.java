package org.mdt.crewtaskmanagement.repository;

import org.mdt.crewtaskmanagement.model.TaskSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskScheduleRepository extends JpaRepository<TaskSchedule, Long> {
}
