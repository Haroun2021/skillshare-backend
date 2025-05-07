package com.skillshare.entities;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;


    @Lob
    private String profileImage; // base64 or image filename

    // One user can create many skills
    @OneToMany(mappedBy = "creator")
    @JsonIgnore
    private Set<Skill> createdSkills = new HashSet<>();

    // One user can learn many skills
    @ManyToMany(mappedBy = "learners")
    @JsonIgnore
    private Set<Skill> enrolledSkills = new HashSet<>();
}
