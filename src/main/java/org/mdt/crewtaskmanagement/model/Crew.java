package org.mdt.crewtaskmanagement.model;

import jakarta.persistence.*;
import lombok.*;
import org.mdt.crewtaskmanagement.model.type.CrewRank;
import org.mdt.crewtaskmanagement.model.type.Gender;
import org.mdt.crewtaskmanagement.model.type.Section;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "crew")
public class Crew  extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String phone;
    private LocalDate birthDate;
    private LocalDate joinedDate;
    private boolean active;
    @Enumerated(EnumType.STRING)
    private Section section;
    @Enumerated(EnumType.STRING)
    private CrewRank crewRank;
    private String nationality;
    private String emergencyPhone;
    private String emergencyEmail;
    private String photoUrl;
    private String certificates;
    private LocalDate certificatesExpiry;
    private String licenseNo;
    private String licenseExpiry;
    @OneToMany(mappedBy = "crew")
    private List<ReportRequest> reportRequests;
    @OneToMany(mappedBy = "crew")
    private List<TaskSchedule> taskSchedules = new ArrayList<>();



}
