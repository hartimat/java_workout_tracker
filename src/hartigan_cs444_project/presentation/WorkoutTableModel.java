/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hartigan_cs444_project.presentation;

import java.util.*;
import hartigan_cs444_project.domain.*;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jeffrey
 */
public class WorkoutTableModel extends AbstractTableModel
{
    private String[] columnNames = {"Name", "Date"};
    
    private List<Workout> workouts = new LinkedList<Workout>();

    public void setWorkouts(List<Workout> workouts)
    {
        this.workouts = workouts;
    }
    
    @Override 
    public int getRowCount()
    {
        return workouts.size();
    }
    
    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }
    
    @Override
    public Object getValueAt(int row, int column)
    {
        Workout workout = workouts.get(row);
        
        switch(column)
        {
            case 0: 
                return workout.getName();
            case 1:
                return workout.getDate();
        }
        
        return "";
    }
    
    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }
}
