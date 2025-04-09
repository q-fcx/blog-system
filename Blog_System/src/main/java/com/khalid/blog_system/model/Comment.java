package com.khalid.blog_system.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "empty content")
    @Size(max = 500, message = "content must less than 500 characters")
    @Column(columnDefinition = "varchar(20) not null")
    private String content;

    @NotEmpty
    @Column(columnDefinition = "varchar(20) not null")
    private String commentDate;

    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer userId;

    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer postId;
}
