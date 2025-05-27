package org.mdt.crewtaskmanagement.repository;

import org.mdt.crewtaskmanagement.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
