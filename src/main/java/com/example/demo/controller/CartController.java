package com.example.demo.controller;
import com.example.demo.dto.CartItemDto;
import com.example.demo.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
public class CartController {
    @Autowired
    private final CartService cartService;
    @GetMapping("cartItems")
    public List<CartItemDto> getAll(){
        return cartService.getAll();
    }

    // hàm remove
    @DeleteMapping("cartItems/{id}")
    public void deteleItem(@PathVariable int id){
        cartService.deleteItem(id);
    }
    // hàm tăng
    @PutMapping("cartItems/increment/{id}")
    public void pushCountItem(@PathVariable int id){
          cartService.pushCount(id);
    }

    @PutMapping("cartItems/decrement/{id}")
    public void downCountItem(@PathVariable int id){
        cartService.downCount(id);
    }




}
