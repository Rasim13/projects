package ru.itis.education.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employee")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public enum Role {
        STUDENT, TEACHER
    }

    @Enumerated(value = EnumType.STRING)
    private Role role;

    private String email;
    private String fullName;

    public boolean isTeacher() {
        return this.role.equals(Role.TEACHER);
    }
}
