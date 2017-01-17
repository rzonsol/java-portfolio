package org.elearning.portfolio.controller;

/**
 * Created by rzonsol on 10.01.2017.
 */
import org.elearning.portfolio.message.Message;
import org.elearning.portfolio.services.MessageService;
import org.elearning.portfolio.services.UserService;
import org.elearning.portfolio.user.Role;
import org.elearning.portfolio.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsersController {

    @Autowired
    UserService userService;

    @Autowired
    MessageService messageService;

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


    @RequestMapping(method = RequestMethod.GET, value = "/userDetails/{id}")
    public String userDetails(Model model, @PathVariable Integer id) {
        User user = userService.getUser(id);
        List<Role> roles = userService.getUserRoles(id);
        List<Message> messageList = messageService.getUserMessages(id);
        model.addAttribute("user", user);
        model.addAttribute("roles",roles);
        model.addAttribute("messages", messageList);
        return "UserDetails";
    }
}