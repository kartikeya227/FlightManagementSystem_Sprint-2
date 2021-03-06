package org.com.controller;

import org.com.dao.AirportDao;
import org.com.dao.UsersDao;
import org.com.error.RecordNotFoundException;
import org.com.model.airport;
import org.com.model.scheduledFlight;
import org.com.model.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UsersDao usersDao;

    @PostMapping("/addUser")
    public ResponseEntity<users> addUser(@Valid @RequestBody users user){
        usersDao.addUser(user);
        return new ResponseEntity("New user account with the name "+user.getUserName()+" has been successfully created!", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<users> findUserById(@PathVariable("id") int userId){
        Optional<users> findById = usersDao.viewUserById(userId);
        try{
            if(findById.isPresent()){
                users user=findById.get();
                return new ResponseEntity<users>(user,HttpStatus.FOUND);
            }
            else{
                throw new RecordNotFoundException("No user record found with the provided " + userId + " user Id.");
            }
        }
        catch (RecordNotFoundException e){
            return new ResponseEntity("No user record found with the provided " + userId + " user Id."+e,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public List<users> viewAllUser(){
        return usersDao.viewAllUser();
    }

    @PutMapping("/modifyUser/{id}")
    public ResponseEntity<users> modifyUser(@Valid @RequestBody users users, @PathVariable("id") int userId){
        Optional<users> findById= usersDao.viewUserById(userId);
        try{
            if(findById.isPresent()){
                usersDao.updateUser(users);
                return new ResponseEntity("User has been successfully updated.",HttpStatus.CREATED);
            }
            else{
                throw new RecordNotFoundException("No User record with  user Id "+userId+" found.");
            }
        }
        catch(RecordNotFoundException e){
            return new ResponseEntity(e, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<users> deleteUser(@PathVariable("id") int userId){
        Optional<users> findById= usersDao.viewUserById(userId);
        try{
            if(findById.isPresent()){
                usersDao.deleteUser(userId);
                return new ResponseEntity("User has been deleted successfully",HttpStatus.OK);
            }
            else{
                throw new RecordNotFoundException("No record with user Id "+userId+" found.");
            }
        }
        catch(RecordNotFoundException e){
            return new ResponseEntity(e, HttpStatus.NOT_FOUND);
        }
    }
}
