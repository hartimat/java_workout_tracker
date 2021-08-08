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
public class AccountTest {
    
    public AccountTest() {
    }

    @Test
    public void testValidate() {
        Account account = new Account();
        boolean result = account.validate();
        assertFalse(result);
        
        // Valid test case
        account.setFirstName("Test");
        account.setLastName("Test");
        account.setId(3);
        Login test = new Login();
        account.setLogin(test);
        result = account.validate();
        assertFalse(result);
        test.setUsername("hkitty");
        test.setPassword("Testing123!");
        account.setLogin(test);
        result = account.validate();
        assertTrue(result);
        
        // First name uppercase
        account.setFirstName("lowercase");
        result = account.validate();
        assertFalse(result);
        
        // First name chars only
        account.setFirstName("123");
        result = account.validate();
        assertFalse(result);
        
        // Last name uppercase
        account.setLastName("lowercase");
        result = account.validate();
        assertFalse(result);
        
        // Last name chars only
        account.setLastName("123");
        result = account.validate();
        assertFalse(result);        
    }
    
}
