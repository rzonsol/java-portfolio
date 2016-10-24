package org.elearning.portfolio.user;


import org.junit.Assert;
import org.junit.Test;


public class UserTest {

    private  User user = new User();

    @Test
    public void userFullNameTest() {
        user.setFirstName("Piotr");
        user.setLastName("Rzonsowski");
        Assert.assertEquals("it ought to be: Piotr Rzonsowski", "Piotr Rzonsowski", user.getFullName());
    }
}