package com.khalid.blog_system.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "empty title")
    @Size(min = 4, message = "title must be more than 4 characters")
    @Column(columnDefinition = "varchar(20) not null")
    private String title;

    @NotEmpty(message = "empty content")
    @Size(min = 10, max = 1500, message = "content must be more than 10 and less than 1500 characters")
    @Column(columnDefinition = "varchar(20) not null")
    private String content;

    @Column(columnDefinition = "varchar(20) not null")
    private LocalDate publishDate;

    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer categoryId;

    @NotNull
    @Column(columnDefinition = "varchar(20) not null")
    private Integer userId;
}
