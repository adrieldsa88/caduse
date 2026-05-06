package com.adrieldsa88.caduse.controller;

import com.adrieldsa88.caduse.business.UserService;
import com.adrieldsa88.caduse.business.dto.UserDTO;
import com.adrieldsa88.caduse.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.saveUser(userDTO));
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDTO userDTO){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userDTO.getEmail(),
                userDTO.getPassword()));

        return "Bearer " + jwtUtil.generateToken(authentication.getName());
    }
    
    @GetMapping
    public ResponseEntity<UserDTO> getUserByEmail(@RequestParam("email") String email){
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    @DeleteMapping("/{email}")
    public void deleteUserByEmail(@PathVariable String email){
        userService.deleteUserByEmail(email);
    }

    @PutMapping
    public ResponseEntity<UserDTO> updateUserData(@RequestHeader("Authorization") String token, @RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.updateUser(token, userDTO));
    }
}
