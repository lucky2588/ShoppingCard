package com.example.demo.service;

import com.example.demo.dto.CartItemDto;
import com.example.demo.repository.CardItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CartService {
    @Autowired
    private final CardItemRepository cardItemRepository;

    // Lấy ra danh sách
    public List<CartItemDto> getAll(){
        return cardItemRepository.getAll();
    }


    public void deleteItem(int id){
         cardItemRepository.deteleCartItem(id);
    }

    public void pushCount(int id) {
        cardItemRepository.pushCount(id);
    }
    public void downCount(int id){
        cardItemRepository.downCount(id);
    }
}


