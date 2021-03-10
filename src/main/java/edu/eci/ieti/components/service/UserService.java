package edu.eci.ieti.components.service;

import edu.eci.ieti.components.model.User;
import edu.eci.ieti.components.persistence.TaskPlannerException;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getByName(String userId) throws TaskPlannerException;

    User create(User user) throws TaskPlannerException;

    User update(User user);

    void remove(String userId);

}
