package org.binar.kamihikoukiairlines.controller;

import org.binar.kamihikoukiairlines.model.Users;
import org.binar.kamihikoukiairlines.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;


    @GetMapping("/getAllUser")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Users> getAllUser(){
            return userService.getAllUser();
        }

    @GetMapping("/getAllUserPagination")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public Page<Users> getAllUsersPagination(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return userService.getAllUsersPagination(page, size);
    }

    @GetMapping("/getUserById/{userId}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Users> getUserById(@PathVariable(value = "userId") Long id) {
        Optional<Users> userData = userService.getUserById(id);
        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateUser")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> updateUser(@RequestParam(value = "userId") Long id, @RequestBody Users user){
        userService.updateUser(id,user);
        return new ResponseEntity<>("Data berhasil di update", HttpStatus.OK);
    }

    @DeleteMapping("/deleteUserById/{userId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> deleteUserById(@RequestParam(name = "userId") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("Data Berhasil dihapus");
    }
}

