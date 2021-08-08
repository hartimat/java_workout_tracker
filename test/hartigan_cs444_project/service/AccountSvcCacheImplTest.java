/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hartigan_cs444_project.service;

import org.junit.Test;
import static org.junit.Assert.*;
import hartigan_cs444_project.domain.*;
import java.util.*;

/**
 *
 * @author Matt
 */
public class AccountSvcCacheImplTest {
    
    public AccountSvcCacheImplTest() {
    }

    @Test
    public void testCRUD() {
        AccountSvcCacheImpl impl = AccountSvcCacheImpl.getInstance();
        List<Account> accounts = impl.retrieveAll();
        assertEquals(accounts.size(), 0);
        
        Account account = new Account();
        account.setFirstName("John");
        account.setLastName("Doe");
        Login login = new Login();
        login.setUsername("hartimat");
        login.setPassword("abcde12345");
        account.setLogin(login);
        
        // test create
        account = impl.create(account);
        assertNotNull(account);
        assertNotEquals(account.getId(), 0);
        
        // test retrieveAll
        accounts = impl.retrieveAll();
        assertEquals(accounts.size(), 1);
        
        // test update
        account.setFirstName("Jane");
        account = impl.update(account);
        accounts = impl.retrieveAll();
        assertEquals(accounts.size(), 1);
        assertEquals(account.getFirstName(), "Jane");

        // test delete
        account = impl.delete(account);
        assertEquals(accounts.size(), 0);
        
        // test account authentication
        Account account1 = new Account();
        account1.setFirstName("John");
        account1.setLastName("Doe");
        Login login1 = new Login();
        login1.setUsername("user1");
        login1.setPassword("password123");
        account1.setLogin(login1);
        account1 = impl.create(account1);
        assertNotNull(account1);
       
        Account account2 = new Account();
        account2.setFirstName("Matt");
        account2.setLastName("Hartigan");
        Login login2 = new Login();
        login2.setUsername("user2");
        login2.setPassword("password456");
        account2.setLogin(login2);
        account2 = impl.create(account2);
        assertNotNull(account2);
        
        Login login3 = new Login();
        login3.setUsername("user3");
        login3.setPassword("password789");
        Account authenticatedAccount = impl.authenticate(login3);
        assertNull(authenticatedAccount);
        login3.setUsername("user1");
        authenticatedAccount = impl.authenticate(login3);
        assertNull(authenticatedAccount);
        login3.setPassword("password123");
        authenticatedAccount = impl.authenticate(login3);
        assertNotNull(authenticatedAccount);
        login3.setUsername("user2");
        authenticatedAccount = impl.authenticate(login3);
        assertNull(authenticatedAccount);
        login3.setPassword("password456");
        authenticatedAccount = impl.authenticate(login3);
        assertNotNull(authenticatedAccount);
    }
    
}
