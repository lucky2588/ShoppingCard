package com.example.demo.repository;

import com.example.demo.database.CartDB;
import com.example.demo.dto.CartItemDto;
import com.example.demo.exception.BadResquestException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.CartMapper;
import com.example.demo.model.CartItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Repository
@Getter
@Setter
@AllArgsConstructor

public class CardItemRepository {

    // lấy ra danh sách khóa học
    public List<CartItemDto> getAll(){
        if(CartDB.listCart.isEmpty()){
            throw new NotFoundException("Không Có Khóa học Nào ");
        }
        return CartDB.listCart.stream().map(item-> CartMapper.Mapper(item)).toList();
    }


    public void deteleCartItem(int id){
      if(CartDB.listCart.stream().filter(item->item.getId() == id).findFirst().isPresent()){
          CartDB.listCart.remove(CartDB.listCart.stream().filter(item->item.getId() == id).findFirst().get());
      }
      throw new NotFoundException("Không tìm thấy Sản Phẩm Này ");
    }
    // Tăng SP
    public void pushCount(int id) {
        CartItem cartItem = CartDB.listCart.stream().filter(item->item.getId() == id).findFirst().get();
        if(CartDB.listCart.stream().filter(item->item.getId() == id).findFirst().isEmpty()){
            throw new NotFoundException("Không tìm thấy Sản Phẩm Này ");
        }
        cartItem.setCount(cartItem.getCount()+1);
    }


    public void downCount(int id) {
        CartItem cartItem = CartDB.listCart.stream().filter(item->item.getId() == id).findFirst().get();
        if(CartDB.listCart.stream().filter(item->item.getId() == id).findFirst().isEmpty()){
            throw new NotFoundException("Không tìm thấy Sản Phẩm Này ");
        }
        if(cartItem.getCount() == 0 ) {
            throw new BadResquestException("K thể giảm Số Lượng SP này ");
        }
        cartItem.setCount(cartItem.getCount()-1);
    }





    }



