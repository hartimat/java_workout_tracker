/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hartigan_cs444_project.domain;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matt
 */
public class LoginTest {
    
    public LoginTest() {
    }

    @Test
    public void testEquals() {
        Login login1 = new Login();
        login1.setUsername("testuser1");
        login1.setPassword("password123");
        
        Login login2 = new Login();
        login2.setUsername("testuser2");
        login2.setPassword("password456");
        
        assertFalse(login1.equals(login2));
        login2.setUsername("testuser1");
        assertFalse(login1.equals(login2));
        login2.setPassword("password123");
        assertTrue(login1.equals(login2));
    }
    
    
    public void testValidate() {
        Login login = new Login();
        boolean result = login.validate();
        assertFalse(result);
        
        // Valid test case
        login.setUsername("gooduser");
        login.setPassword("workingpassword123");        
        result = login.validate();
        assertTrue(result);
        
        // username > 10 chars
        login.setUsername("verylongusernamefortest");
        login.setPassword("workingpassword123");
        result = login.validate();
        assertFalse(result);

        // username < 10 chars
        login.setUsername("short");
        login.setPassword("workingpassword123");
        result = login.validate();
        assertTrue(result);

        // password < 10 chars
        login.setUsername("gooduser");
        login.setPassword("short");
        result = login.validate();
        assertFalse(result);
        
        // password > 25 chars
        login.setUsername("gooduser");
        login.setPassword("thispasswordiswaytoolongtobeapassword");
        result = login.validate();
        assertFalse(result);
                
        // password has digit
        login.setUsername("gooduser");
        login.setPassword("goodpassbutnodigits");
        result = login.validate();
        assertFalse(result);
    }
    
}
