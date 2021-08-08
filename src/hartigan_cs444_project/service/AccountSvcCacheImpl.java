/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hartigan_cs444_project.service;

import hartigan_cs444_project.domain.*;
import java.util.*;

/**
 *
 * @author Matt
 */
public class AccountSvcCacheImpl implements IAccountSvc {
    
    // CONSTRUCTORS
    private AccountSvcCacheImpl() {
    }

    
    // FIELDS
    private static AccountSvcCacheImpl instance = new AccountSvcCacheImpl();
    private List<Account> cache = new ArrayList<>();
    private int nextId = 0;
    

    // METHODS
    public static AccountSvcCacheImpl getInstance() {
        return instance;
    }

    public Account create (Account account) {
        account.setId(++nextId);
        cache.add(account);
        return account;
    }
    
    public List<Account> retrieveAll() {
        return cache;
    }
    
    public Account update (Account account) {
        for (int i=0; i < cache.size(); i++) {
            Account next = cache.get(i);
            if (next.getId() == account.getId()) {
                cache.set(i, account);
                break;
            }
        }
        return account;
    }
    
    public Account delete (Account account) {
        for (int i=0; i < cache.size(); i++) {
            Account next = cache.get(i);
            if (next.getId() == account.getId()) {
                cache.remove(i);
                break;
            }
        }
        return account;
    }
    
    public Account authenticate (Login login) {
        Account account = null;
        for (int i=0; i<cache.size(); i++) {
            account = cache.get(i);
            Login accountLogin = account.getLogin();
            if (login.equals(accountLogin)) return account;
        }
        return null;
    }
    
}
