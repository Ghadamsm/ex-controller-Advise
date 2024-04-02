package com.example.hospital.Controller;


import com.example.hospital.API.ApiResponse;
import com.example.hospital.Model.User;
import com.example.hospital.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {



    private final UserService userService ;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/get")
    public ResponseEntity getAll(){
        logger.info("get all users");
        return ResponseEntity.status(200).body(userService.getAll());
    }



    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user){
        logger.info("add new users");

        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("User added"));

    }



    @PutMapping("/update/{Id}")
    public ResponseEntity updateUser(@PathVariable Integer Id , @RequestBody @Valid User user){

        logger.info("update users");

        userService.updateUser(Id , user);

        return ResponseEntity.status(200).body(new ApiResponse("user updated"));
    }



    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteUser(@PathVariable Integer Id ){

        logger.info("delete users");

        userService.deleteUser(Id);

        return ResponseEntity.status(200).body(new ApiResponse("User deleted"));
    }


}
