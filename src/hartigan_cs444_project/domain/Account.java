/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hartigan_cs444_project.domain;

import java.util.LinkedList;

/**
 *
 * @author Matt
 */
public class Account {
    private int id;
    private String firstName;
    private String lastName;
    private Login login;
    private LinkedList<Workout> workoutLog;
    
    public Account() {
        id = 0;
        firstName = "";
        lastName = "";
        login = null;
        workoutLog = new LinkedList<Workout>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public LinkedList<Workout> getWorkoutLog() {
        return workoutLog;
    }

    public void setWorkoutLog(LinkedList<Workout> workoutLog) {
        this.workoutLog = workoutLog;
    }
    
    public boolean validate() {
        if (firstName == null || firstName.equals("") || !Character.isUpperCase(firstName.charAt(0))) return false;
        if (lastName == null || lastName.equals("") || !Character.isUpperCase(lastName.charAt(0))) return false;
        if (login == null || !login.validate()) return false;
        return true;
    }
    
    public Workout workoutAdd(Workout workout) {
        workout.setId(id++);
        workoutLog.add(workout);
        return workout;
    }
}
