package com.toyproject.jpaBoard.user.service;

import com.toyproject.jpaBoard.user.dto.UserForm;
import com.toyproject.jpaBoard.user.entity.User;
import com.toyproject.jpaBoard.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceIml implements  UserService{

    private final UserRepository userRepository;

    private final JavaMailSender javaMailSender;

    @Override
    @Transactional
    public void createUser(UserForm userForm) {
        User user = User.builder()
                .email(userForm.getEmail())
                .password(userForm.getPassword()) //encoding
                .name(userForm.getName())
                .build();
        User newUser = userRepository.save(user);

        //토큰값 생성
        newUser.generateEmailCheckToken();
        sendSignUpConformEmail(newUser);
    }

    private void sendSignUpConformEmail(User newUser) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setText("게시판, 회원가입인증");
        simpleMailMessage.setText("/checkEmailToken?token=" + newUser.getEmailCheckToken() + "&email=" + newUser.getEmail());
        javaMailSender.send(simpleMailMessage);
    }

    @Override
    public User findByEmail(String email) {
        return  userRepository.findByEmail(email);
    }
}
