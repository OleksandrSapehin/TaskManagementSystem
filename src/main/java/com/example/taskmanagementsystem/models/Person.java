package com.example.taskmanagementsystem.models;
import com.example.taskmanagementsystem.enums.PersonRoles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private PersonRoles role;
    @ManyToMany(mappedBy = "assignees")
    private List<Task> assignedTasks;

    @OneToMany(mappedBy = "taskAuthor")
    private List<Task> authoredTasks;
}
