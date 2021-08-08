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
public class Exercise {
    private String name;
    private int sets;
    private int reps;
    private int weight;
    
    public Exercise() {
        name = "";
        sets = -1;
        reps = -1;
        weight = -1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    public boolean validate() {
        if (name == null || name.equals("")) return false;
        if (sets < 0) return false;
        if (reps < 0) return false;
        if (weight < 0) return false;
        return true;
    }
}
