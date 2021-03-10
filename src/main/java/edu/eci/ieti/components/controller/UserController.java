package edu.eci.ieti.components.controller;

import edu.eci.ieti.components.model.User;
import edu.eci.ieti.components.persistence.TaskPlannerException;
import edu.eci.ieti.components.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userServices;

    @RequestMapping(value = "/{username}",method = RequestMethod.GET)
    public ResponseEntity<?> getUserByUsername(@PathVariable String username){
        try{
            User user = userServices.getByName(username);

            return new ResponseEntity<>(user, HttpStatus.OK);


        } catch (TaskPlannerException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public ResponseEntity<?> addUsers(@RequestBody User user){
        try{
            User userNew = userServices.create(user);
            return new ResponseEntity<>(userNew, HttpStatus.CREATED);
        } catch (TaskPlannerException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }

    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getUsers(){
        try {
            return new ResponseEntity<>(userServices.getAll(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/removeUser",method = RequestMethod.DELETE)
    public ResponseEntity<?> removeUser(@RequestBody User user){
        try {
            userServices.remove(user.getUsername());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@RequestBody User user){
        try {
            User userNew = userServices.update(user);
            return new ResponseEntity<>(userNew,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }
}
