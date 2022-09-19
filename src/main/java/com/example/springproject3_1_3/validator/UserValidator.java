package com.example.springproject3_1_3.validator;

import com.example.springproject3_1_3.entity.User;
import com.example.springproject3_1_3.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class UserValidator implements Validator {

    private final UserRepository userRepository;

    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User anotherUser = (User) target;

        Optional<User> optional = userRepository.findByEmail(anotherUser.getUsername());

        if (optional.isPresent()) {
            errors.rejectValue("email", "", "User already exists");
        }

    }
}
