package edu.eci.ieti.components.persistence;

import edu.eci.ieti.components.model.User;

import java.util.ArrayList;
import java.util.List;

public interface UserPersistence {
    List<User> users = new ArrayList<>();

    User addUser(User user) throws TaskPlannerException;

    void deleteUser(String username);

    User updateUser(User user);

    User getUserByUsername(String username) throws TaskPlannerException;

    List<User> getAllUsers();
}
