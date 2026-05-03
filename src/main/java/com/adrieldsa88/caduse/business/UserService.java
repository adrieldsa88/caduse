package com.adrieldsa88.caduse.business;

import com.adrieldsa88.caduse.business.converter.UserConverter;
import com.adrieldsa88.caduse.business.dto.UserDTO;
import com.adrieldsa88.caduse.infrastructure.entity.User;
import com.adrieldsa88.caduse.infrastructure.exceptions.ConflictException;
import com.adrieldsa88.caduse.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final PasswordEncoder passwordEncoder;

    public UserDTO saveUser(UserDTO dto){
        emailExists(dto.getEmail());
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        User user = userConverter.toUser(dto);
        return userConverter.toUserDTO(userRepository.save(user));

    }

    public void emailExists(String email){
        try{
            boolean exists = existsByEmail(email);
            if(exists){
                throw new ConflictException("Email já cadastrado");
            }

        } catch (ConflictException e){
            throw new ConflictException("Email já cadastrado", e.getCause());
        }
    }


    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }


    public UserDTO getUserByEmail(String email){
        return userConverter.toUserDTO(userRepository.findByEmail(email).orElseThrow());

    }

    public void deleteUserByEmail(String email){
        userRepository.deleteByEmail(email);
    }

}
