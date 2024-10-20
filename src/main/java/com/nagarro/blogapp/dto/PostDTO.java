package com.nagarro.blogapp.dto;

import com.nagarro.blogapp.entity.Stats;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private Long id;

    private String title;

    private String userId;

    private String content;

    private Stats stats;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
