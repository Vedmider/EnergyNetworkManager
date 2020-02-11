package com.web.data;

import com.persitence.entity.User;

public class Mapper {

    public static User mapUserFromDTO(UserDTO userDTO){
        User user =  new User();
        user.setLogin(userDTO.getLogin());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setFirstName(userDTO.getFirst_name());
        user.setLastName(userDTO.getLast_name());
        return user;
    }
}
