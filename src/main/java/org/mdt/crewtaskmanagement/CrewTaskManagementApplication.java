package org.mdt.crewtaskmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class CrewTaskManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrewTaskManagementApplication.class, args);
    }

}
