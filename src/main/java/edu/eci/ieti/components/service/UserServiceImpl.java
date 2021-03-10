package edu.eci.ieti.components.service;

import edu.eci.ieti.components.model.User;
import edu.eci.ieti.components.persistence.TaskPlannerException;
import edu.eci.ieti.components.persistence.UserPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserPersistence up;

    @Override
    public List<User> getAll() {
        return up.getAllUsers();
    }

    @Override
    public User getByName(String username) throws TaskPlannerException {
        return up.getUserByUsername(username);
    }

    @Override
    public User create(User user) throws TaskPlannerException {
        return up.addUser(user);
    }

    @Override
    public User update(User user) {
        return up.updateUser(user);
    }

    @Override
    public void remove(String userName) {
        up.deleteUser(userName);
    }
}
