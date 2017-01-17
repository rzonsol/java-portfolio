package org.elearning.portfolio.controller;

/**
 * Created by rzonsol on 10.01.2017.
 */
import org.elearning.portfolio.services.UserService;
import org.elearning.portfolio.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsersList {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String userList(Model model) {
        List<User> usersList = userService.getUsers();
        List<String> userListString = new ArrayList<String>();
        for (User user: usersList) {
            userListString.add(user.getFullName());
        }
        model.addAttribute("userListString", usersList);
        return "UsersList";
    }

    @RequestMapping(value = "/addUser", method = { RequestMethod.GET, RequestMethod.POST })
    public String addUser(@ModelAttribute("user") User user,Model model){
        String message = "";
        String hide="hide";
        if (null != user && null != user.getFirstName()
                && null != user.getLastName()) {
            userService.addUser(user.getLogin(),user.getEmail(),user.getFirstName(),user.getLastName(),null);
            message = "User saved";
            hide="";
        }
        model.addAttribute("hide",hide);
        model.addAttribute("message",message);
        return "AddUser";
    }
}