package com.example.demo.database;

import com.example.demo.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
    public static List<User> listUser = new ArrayList<>(
            List.of(
                    new User(1,"Đức Thắng","duwcsthang2001@gmail.com","0332652238",null),
                    new User(2,"San Bùi","vanvan@gmail.com","012345678",null),
                    new User(3,"Hiếu Nguyễn","hieunguyen@gmail.com","333333",null)
            )
    );
}
