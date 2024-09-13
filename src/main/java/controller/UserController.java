package controller;

import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUser/{userId}")
    public String getUser(@PathVariable(name = "userId") Long userId, Model model){
        User user = userService.findUser(userId);
        model.addAttribute("user", user);
        return "user";
    }
    @GetMapping("getUsers")
    public String getUsers(Model model){
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "user";
    }
    @PostMapping("/addUser")
    public String addUser(@ModelAttribute(name = "user") User user, Model model){
        User addedUser = userService.addUser(user);
        model.addAttribute("user", addedUser);
        return "user";
    }
    @DeleteMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable(name = "userId") Long userId, Model model){
        User user = userService.deleteUserById(userId);
        model.addAttribute("user", user);
        return "user";
    }
    @PutMapping("/updateUser/{userId}")
    public String updateUser(
            @PathVariable(name = "userId") Long userId,
            @ModelAttribute(name = "user") User user,
            Model model){
        User user1 = userService.updateUser(userId, user);
        model.addAttribute("user1", user1);
        return "user";

    }

}
