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
public class ExerciseTest {
    
    public ExerciseTest() {
    }

    @Test
    public void testValidate() {
        Exercise exercise = new Exercise();
        boolean result = exercise.validate();
        assertFalse(result);
        
        // Valid test case
        exercise.setName("Test");
        exercise.setSets(1);
        exercise.setReps(1);
        exercise.setWeight(100);  
        result = exercise.validate();
        assertTrue(result);
        
        // Name not set
        exercise.setName("");
        result = exercise.validate();
        assertFalse(result);      
        
        // Sets not set
        exercise.setName("sampleworkout");
        exercise.setSets(-1);
        result = exercise.validate();
        assertFalse(result);
        
        // Reps not set
        exercise.setSets(1);
        exercise.setReps(-1);
        result = exercise.validate();
        assertFalse(result);
        
        // Weight not set
        exercise.setReps(1);
        exercise.setWeight(-1);
        result = exercise.validate();
        assertFalse(result);
    }
    
}
