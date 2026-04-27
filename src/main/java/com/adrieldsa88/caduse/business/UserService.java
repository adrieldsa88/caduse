package com.adrieldsa88.caduse.business;

import com.adrieldsa88.caduse.business.converter.UserConverter;
import com.adrieldsa88.caduse.business.dto.UserDTO;
import com.adrieldsa88.caduse.infrastructure.entity.User;
import com.adrieldsa88.caduse.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    public UserDTO saveUser(UserDTO dto){
        User user = userConverter.toUser(dto);
        return userConverter.toUserDTO(userRepository.save(user));

    }

}
