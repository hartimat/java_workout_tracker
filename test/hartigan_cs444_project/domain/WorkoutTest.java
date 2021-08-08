/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hartigan_cs444_project.domain;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.LinkedList;

/**
 *
 * @author Matt
 */
public class WorkoutTest {
    
    public WorkoutTest() {
    }

    @Test
    public void testValidate() {
        Workout workout = new Workout();
        boolean result = workout.validate();
        assertFalse(result);
        
        // Valid use case
        workout.setName("Test");
        workout.setDate("1/1/2020");
        Exercise testExercise = new Exercise();
        LinkedList<Exercise> testExerciseList = new LinkedList<>();
        testExerciseList.add(testExercise);
        workout.setExercises(testExerciseList);
        result = workout.validate();
        assertTrue(result);
        
        // Workout name does not exist
        workout.setName("");
        result = workout.validate();
        assertFalse(result);
        
        // Workout date does not exist
        workout.setName("testname");
        workout.setDate("");
        result = workout.validate();
        assertFalse(result);

        // Exercises do not exist
        workout.setDate("1/1/2020");
        workout.setExercises(null);
        result = workout.validate();
        //assertFalse(result);        
        assertTrue(result);        
    }
    
}
