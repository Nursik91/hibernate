package kz.nursike.service;

import kz.nursike.model.User;

/**
 * Created by ЕрежеповН on 22.12.2017.
 */
public interface UserService {
    public User findByUsername(String username);
}
