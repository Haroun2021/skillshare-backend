package com.skillshare.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private int durationInMinutes;

    // ✅ Base64 thumbnail image
    @Lob
    private String thumbnailImage;

    // Many skills belong to one category
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // Many skills can be created by one user
    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    // Many learners can enroll in many skills
    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "skill_enrollments",
            joinColumns = @JoinColumn(name = "skill_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> learners = new HashSet<>();
}
