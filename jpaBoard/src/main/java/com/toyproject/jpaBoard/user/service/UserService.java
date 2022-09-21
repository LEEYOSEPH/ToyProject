package com.toyproject.jpaBoard.user.service;

import com.toyproject.jpaBoard.user.dto.LoginUserForm;
import com.toyproject.jpaBoard.user.dto.UserForm;
import com.toyproject.jpaBoard.user.entity.User;

public interface UserService {
    public void createUser(UserForm userForm);

    User findByEmail(String email);

    void login(LoginUserForm loginUserForm);
}
