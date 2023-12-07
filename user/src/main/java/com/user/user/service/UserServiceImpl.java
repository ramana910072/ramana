package com.user.user.service;


import com.user.user.configs.Configurations;
import com.user.user.dao.UserDAO;
import com.user.user.dto.MessageDTO;
import com.user.user.dto.UserDto;
import com.user.user.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final RestTemplate restTemplate;
  /*  static List<UserDto> userDtos = new ArrayList<>();

    static {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setName("R");
        userDtos.add(userDto);
    }*/



    /*public MessageDTO getMesssages(){

        return messageService.getMessage();

    }*/

    /*
    * message service -    //http://localhost:8082/message/get/all

      * */

    @Override
    public UserDto getUserWithMessages(int userId) {
            List<MessageDTO> messageDTOS = (List<MessageDTO>)restTemplate.getForObject("http://localhost:8082/message/get/{userId}", List.class,userId);
        return new UserDto(userId,"asdfg",messageDTOS);
    }

    @Autowired
    private UserDAO userDAO;

    public UserDto addUser(UserDto userDto){
        UserEntity userEntity= new UserEntity(userDto.getId(), userDto.getName());
        userDAO.save(userEntity);
        return userDto;
    }
}
