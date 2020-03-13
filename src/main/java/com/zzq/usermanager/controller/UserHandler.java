package com.zzq.usermanager.controller;

import com.zzq.usermanager.entity.User;
import com.zzq.usermanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findAll/{page}/{size}")

    public Page<User> findAll(@PathVariable("page") Integer page,
                              @PathVariable("size") Integer size){

        PageRequest pageRequest = PageRequest.of(page,size);
        return userRepository.findAll(pageRequest);
    }

    @PostMapping("/save")
    public String save(@RequestBody User user){
        User result = userRepository.save(user);
        if (result == null){
            return "error";
        }else{
            return "success";
        }
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable ("id") Integer id){
        return userRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody User user){
        User result = userRepository.save(user);
        if (result == null){
            return "error";
        }else{
            return "success";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
    }
}
