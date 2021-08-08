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
public interface IAccountSvc {
    
    public Account create(Account account);
    public List<Account> retrieveAll();
    public Account update(Account account);
    public Account delete(Account account);
    public Account authenticate(Login login);
    
}
