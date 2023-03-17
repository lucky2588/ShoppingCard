package com.example.demo.database;

import com.example.demo.model.CartItem;

import java.util.ArrayList;
import java.util.List;

public class CartDB {
    public static List<CartItem> listCart = new ArrayList<>(
           List.of(
                   new CartItem(1,1,1),
                   new CartItem(2,2,2),
                   new CartItem(3,3,3)
           )
    );
}