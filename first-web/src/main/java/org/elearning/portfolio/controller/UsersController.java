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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UsersController {

    @Autowired
    UserService userService;

    @Autowired
    MessageService messageService;

    @RequestMapping("/")
    public String userList(Model model) {
        List<User> usersList = userService.getUsers();
        Set<User> usersSet = new HashSet<User>();
        usersSet.addAll(usersList);
        usersList.clear();
        usersList.addAll(usersSet);
        model.addAttribute("userListString", usersList);
        return "UsersList";
    }

    @RequestMapping(value = "/users/add", method = { RequestMethod.GET, RequestMethod.POST })
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

    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
    public String userDetails(Model model, @PathVariable Integer id) {
        User user = userService.getUser(id);
        List<Role> roles = userService.getUserRoles(id);
        List<Message> messageList = userService.getMessagesByUserId(id);
        model.addAttribute("user", user);
        model.addAttribute("roles",roles);
        model.addAttribute("messages", messageList);
        return "UserDetails";
    }

    @RequestMapping(value = "/users/{id}/edit", method =  RequestMethod.GET)
    public String saveUserDetail(@PathVariable Integer id, Model model){
        String hide="hide";
        String message = "Changes have been saved";
        User userDetail = userService.getUser(id);
        userService.updateUser(userDetail);
        model.addAttribute("user", userDetail);
        model.addAttribute("hide",hide);
        model.addAttribute("message",message);
        model.addAttribute("roles",userDetail.getRolesToString());
        return "EditUserDetails";
    }

    @RequestMapping(path = "/users/{id}", method =RequestMethod.POST)
    public String addUser(@PathVariable Integer id,@ModelAttribute("user") User user, Model model){
        String hide="";
        String message = "Changes have been saved";
        User userDetail = user;
        userDetail.setRoles(userService.getUserRoles(id));
        userService.updateUser(userDetail);
        model.addAttribute("user", userDetail);
        model.addAttribute("hide",hide);
        model.addAttribute("message",message);
        model.addAttribute("roles",userDetail.getRolesToString());

        return "EditUserDetails";
    }

    @RequestMapping(path = "/users/{id}/role", method =  RequestMethod.POST )
    public String addUser(@ModelAttribute("roles") String roles, @PathVariable Integer id, Model model){

        String hide="";
        String message = "Changes have been saved";
        List<Role> tempRoles = new ArrayList<Role>();
        String[] rolesList = roles.split(",");
        for(String role:rolesList){
            Role tempRole = new Role();
            tempRole.setRoleName(role);
            tempRoles.add(tempRole);
        }
        User userDetail = userService.getUser(id);
        userDetail.setRoles(tempRoles);
        userService.updateUser(userDetail);
        model.addAttribute("user", userDetail);
        model.addAttribute("hide",hide);
        model.addAttribute("message",message);
        model.addAttribute("roles",userDetail.getRolesToString());
        return "EditUserDetails";
    }

    @RequestMapping(value = "/users/{id}/delete", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Integer id, Model model){
        userService.delUser(id);
        List<User> usersList = userService.getUsers();
        model.addAttribute("userListString", usersList);
        return "UsersList";
    }






}