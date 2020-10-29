package be.ifosup.boilerplate.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.ifosup.boilerplate.entities.User;
import be.ifosup.boilerplate.models.UserDTO;
import be.ifosup.boilerplate.repositories.UserRepository;
import be.ifosup.boilerplate.services.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

    private final UserRepository userRepository;

    @Autowired
    public UsersServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO getUser(String username) {
        User user = userRepository.findByUsername(username);

        UserDTO userDTO = UserDTO.builder()
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .id(user.getId())
                .username(user.getUsername())
                .build();

        return userDTO;
    }
}
