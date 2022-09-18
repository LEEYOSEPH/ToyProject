package com.toyproject.jpaBoard.user.service;

import com.toyproject.jpaBoard.user.dto.MemberForm;
import com.toyproject.jpaBoard.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    
    /*회원 가입*/
    @Transactional
    public void createUser(MemberForm memberForm) {

        userRepository.save(memberForm);
    }
}
