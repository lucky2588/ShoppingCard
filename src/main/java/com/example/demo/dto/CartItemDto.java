package com.example.demo.dto;
import com.example.demo.model.Course;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CartItemDto {
    private Integer id;
    private Course course;
    private Integer count;
}
