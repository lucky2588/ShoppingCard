package com.example.demo.mapper;

import com.example.demo.database.CartDB;
import com.example.demo.database.CourseDB;
import com.example.demo.dto.CartItemDto;
import com.example.demo.model.CartItem;
import com.example.demo.model.Course;

import java.util.Random;

public class CartMapper{
    public static CartItemDto Mapper(CartItem item){
        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setId(item.getId());
        cartItemDto.setCount(item.getCount());
        Course course = CourseDB.listCourse.stream().filter(user -> user.getId() == item.getId()).findFirst().get();
        cartItemDto.setCourse(course);
        return cartItemDto;
    }

}
