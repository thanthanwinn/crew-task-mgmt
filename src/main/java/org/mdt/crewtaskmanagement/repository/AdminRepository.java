package org.mdt.crewtaskmanagement.repository;

import org.mdt.crewtaskmanagement.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository  extends JpaRepository<Admin, Long> {
}
