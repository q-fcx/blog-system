package com.khalid.blog_system.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "empty username")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String username;

    @NotEmpty(message = "empty password")
    @Column(columnDefinition = "varchar(20) not null")
    private String password;

    @NotEmpty(message = "empty email")
    @Email
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(columnDefinition = "date not null")
    private LocalDate registrationDate;
}
