package com.toyproject.jpaBoard.user.controller;

import com.toyproject.jpaBoard.user.dto.UserForm;
import com.toyproject.jpaBoard.user.entity.User;
import com.toyproject.jpaBoard.user.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;



@SpringBootTest
@Transactional
class UserControllerTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("회원가입 성공")
    public void createUser(){
        // given
        UserForm userForm = new UserForm();
        userForm.setEmail("lyb6642");
        userForm.setPassword("12345678999");
        userForm.setName("yoseph");

        //when
        User user = User.builder()
                .email(userForm.getEmail())
                .password(userForm.getPassword())
                .name(userForm.getName())
                .build();

        User save = userRepository.save(user);

        //then
        Assertions.assertThat(save.getEmail()).isEqualTo("lyb6642");


    }
}