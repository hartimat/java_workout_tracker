/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hartigan_cs444_project.domain;

/**
 *
 * @author Matt
 */
public class Login {
        private String username;
        private String password;
        
    public Login() {
        username = "";
        password = "";
}
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean validate() {
        if (username == null || username.equals("") || username.length() > 10) return false;
        if (password == null || password.equals("") || password.length() < 10 || password.length() > 25 || !password.matches(".*\\d.*") || !password.matches(".*[a-zA-Z].*")) return false;
        return true;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (! (obj instanceof Login)) return false;
        Login login = (Login)obj;
        if (!this.username.equals(login.getUsername())) return false;
        if (!this.password.equals(login.getPassword())) return false;
        return true;
    }
    
}
