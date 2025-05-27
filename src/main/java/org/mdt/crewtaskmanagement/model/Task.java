package org.mdt.crewtaskmanagement.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mdt.crewtaskmanagement.model.type.Category;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String position;
    private String description;
    @Enumerated(EnumType.ORDINAL)
    private Category category;
    @OneToMany(mappedBy = "task")
    private List<TaskSchedule> taskSchedules = new ArrayList<>();



}
