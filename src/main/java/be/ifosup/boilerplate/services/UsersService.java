package be.ifosup.boilerplate.services;

import be.ifosup.boilerplate.models.UserDTO;

public interface UsersService {
    UserDTO getUser(String username);
}
