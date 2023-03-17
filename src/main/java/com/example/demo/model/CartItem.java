package com.example.demo.model;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CartItem {
    private Integer id;
    private Integer courseId;
    private Integer count;
}
