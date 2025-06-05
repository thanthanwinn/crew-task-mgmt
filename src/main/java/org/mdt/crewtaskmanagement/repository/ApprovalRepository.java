package org.mdt.crewtaskmanagement.repository;

import org.mdt.crewtaskmanagement.model.Approval;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprovalRepository extends JpaRepository<Approval, Long> {
}
