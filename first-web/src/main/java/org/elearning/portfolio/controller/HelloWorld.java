package org.elearning.portfolio.controller;

/**
 * Created by rzonsol on 10.01.2017.
 */
import org.elearning.portfolio.services.UserService;
import org.elearning.portfolio.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloWorld {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String loadExample(Model model) {
        // Send the variable "pageTitle" to the view.
        // This can be accessed by ${pageTitle} in the FreeMarker file "hello-world.ftl"

        List<User> usersList = userService.getUsers();
        String login = usersList.get(1).getLogin();
        List<String> userListString = new ArrayList<String>();
        for (User user: usersList) {
            userListString.add(user.getFullName());
        }
        model.addAttribute("userListString", userListString);



        // When the user navigates to http://<deploy-url>/<context>/, tell the server to use
        // `/WEB-INF/ftl/views/hello-world.ftl` to render the view
        return "hello-world";
    }
}