package kz.nursike.dao;

import kz.nursike.model.User;

/**
 * Created by ЕрежеповН on 22.12.2017.
 */
public interface UserDAO {
    public User findByUsername(String username);
    public void save(User user);
}
