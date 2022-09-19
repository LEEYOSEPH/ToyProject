package com.toyproject.jpaBoard.user.service;

import com.toyproject.jpaBoard.user.dto.UserForm;
import com.toyproject.jpaBoard.user.entity.User;
import com.toyproject.jpaBoard.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceIml implements  UserService{

    private final UserRepository userRepository;


    @Override
    @Transactional
    public void createUser(UserForm userForm) {
        User user = User.builder()
                .email(userForm.getEmail())
                .password(userForm.getPassword()) //encoding
                .name(userForm.getName())
                .build();
        User newUser = userRepository.save(user);
    }
}
