package org.mdt.crewtaskmanagement.repository.entity;

import org.mdt.crewtaskmanagement.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
//    @Query("select ta , c.email from Task  t join  Crew  c on t.")
//    void deleteTaskById(Long id);
}
