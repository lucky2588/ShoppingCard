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
import java.util.Optional;

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
        CartItem cartItem = CartDB.listCart.stream().filter(user->user.getId() == id).findFirst()
                .orElseThrow(() -> {
            throw new NotFoundException("Not found  with id = " + id);
        });
      CartDB.listCart.remove(cartItem);
    }
    // Tăng SP
    public void pushCount(int id) {
        CartItem cartItem = CartDB.listCart.stream().filter(item->item.getId() == id).findFirst().get();
        if(!CartDB.listCart.stream().filter(item->item.getId() == id).findFirst().isPresent()){
            throw new NotFoundException("Không tìm thấy Sản Phẩm Này ");
        }
        cartItem.setCount(cartItem.getCount()+1);
    }


    public void downCount(int id) {
        Optional optional = CartDB.listCart.stream().filter(item->item.getId() == id).findFirst();
//        CartItem cartItem = CartDB.listCart.stream().filter(item->item.getId() == id).findFirst().get();
        if(optional.isPresent()){
            CartItem cartItem = CartDB.listCart.stream().filter(item->item.getId() == id).findFirst().get();
            if(cartItem.getCount() == 0 ) {
                throw new BadResquestException("K thể giảm Số Lượng SP này ");
            }
            cartItem.setCount(cartItem.getCount()-1);
        }else{
            throw new NotFoundException("Không tìm thấy Sản Phẩm Này ");
        }
    }





    }



