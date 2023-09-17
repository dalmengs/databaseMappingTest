package com.dalmeng.databaseMappingTest.Service;

import com.dalmeng.databaseMappingTest.Entity.User;
import com.dalmeng.databaseMappingTest.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User createUser() {
        User user = new User();
        return userRepository.save(user);
    }

}
