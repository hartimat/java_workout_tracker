/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hartigan_cs444_project.domain;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;

/**
 *
 * @author Matt
 */
public class Workout {
    private int id;
    private String name;
    private String date;    // parse string using DateFormat class methods
    private LinkedList<Exercise> exercises;
    
    public Workout() {
        id = -1;
        name = "'";
        date = "";
        exercises = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public LinkedList<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(LinkedList<Exercise> exercises) {
        this.exercises = exercises;
    }
    
    public boolean validate() {
        if (name == null || name.equals("")) return false;        
        if (date == null || date.equals("")) return false;
        return true;
    }
}
