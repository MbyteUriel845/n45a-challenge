package com.project.nasa.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "project_category",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    @ManyToMany(mappedBy = "projects")
    private List<Skill> skills;

    @ManyToMany
    @JoinTable(
            name = "project_user",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;

    @Column(length = 10485760)
    private String title;

    @Column(length = 10485760)
    private String description;

    @Column(length = 10485760)
    private String img;

    @Column(length = 10485760)
    private String project_goals;

    @Column(length = 10485760)
    private String email;

    @Column(length = 10485760)
    private String status;

    @Column(length = 10485760)
    private String start_date;

    @Column(length = 10485760)
    private String scistarter;

    @Column(length = 10485760)
    private String url;

    @Column(length = 10485760)
    private String geographic_scope;
}
