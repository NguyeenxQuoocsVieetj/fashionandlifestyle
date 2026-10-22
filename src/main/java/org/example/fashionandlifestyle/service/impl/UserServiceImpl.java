package org.example.fashionandlifestyle.service.impl;

import org.example.fashionandlifestyle.dto.UserDTO;
import org.example.fashionandlifestyle.entity.Enum.UserStatus;
import org.example.fashionandlifestyle.entity.Users;
import org.example.fashionandlifestyle.repository.UserRepo;
import org.example.fashionandlifestyle.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    private UserDTO userResponse(Users u){
        return UserDTO.builder()
                .userName(u.getUserName())
                .fullName(u.getFullName())
                .avatar(u.getAvatar())
                .gender(u.getGender())
                .phone(u.getPhone())
                .email(u.getEmail())
                .address(u.getAddress())
                .role(u.getRole())
                .status(u.getStatus())
                .createAt(u.getCreateAt())
                .build();
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepo.findAll()
                .stream()
                .map(this::userResponse)
                .toList();
    }

    @Override
    public Optional<UserDTO> findById(Long id) {
        return userRepo.findById(id)
                .map(this::userResponse);
    }

    @Override
    public UserDTO login(String email, String passWord) {
        Users entity = userRepo.findUsersByEmail(email).orElseThrow(() -> new RuntimeException("Email Không tồn tại"));

        if(!entity.getPassWord().equals(passWord)) new RuntimeException("Sai mật khẩu");

        if(entity.getStatus().equals(UserStatus.LOCKED)) new RuntimeException("Tài khoản đã bị khóa");

        return userResponse(entity);
    }
}
