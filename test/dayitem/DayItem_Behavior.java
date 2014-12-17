/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayitem;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import taskitem.DefaultTaskItem;
import static org.testng.Assert.*;
import taskitem.TaskItem;

/**
 *
 * @author Affan Hasan
 */
public class DayItem_Behavior {
    
    private DayItem dayItem;
    private TaskItem taskItem;
    
    @BeforeMethod
    public void setUpMethod() throws Exception{
        dayItem = new DefaultDayItem();
        taskItem = new DefaultTaskItem();
    }
    
    @Test
    public void add_a_task_item(){
        int size = dayItem.getTasks().size();
        dayItem.addTask(taskItem);
        assertTrue(dayItem.getTasks().size() == size + 1);
    }
    
    @Test
    public void adding_a_task_item_at_index_0(){
        int size = dayItem.getTasks().size();
        dayItem.addTask(taskItem, 0);
        assertTrue(dayItem.getTasks().size() == size + 1);
    }
    
    @Test
    public void adding_a_task_item_at_index_3(){
        for(int index = 0; index < 4; index++){
            taskItem = new DefaultTaskItem();
            dayItem.addTask(taskItem);
        }
        int size = dayItem.getTasks().size();
        taskItem = new DefaultTaskItem();
        dayItem.addTask(taskItem, 3);
        assertTrue(dayItem.getTasks().size() == size + 1);
    }
    
    @Test
    public void adding_a_task_item_at_index_should_auto_assign_the_order_no_to_task_item(){
        for(int index = 0; index < 4; index++){
            taskItem = new DefaultTaskItem();
            dayItem.addTask(taskItem);
            assertTrue(dayItem.getTasks().get(index).getOrderNumber() == index);
        }
        int size = dayItem.getTasks().size();
        taskItem = new DefaultTaskItem();
        dayItem.addTask(taskItem, 3);
        
        for(int index = 0; index < size + 1; index++){
            assertTrue(dayItem.getTasks().get(index).getOrderNumber() == index);
        }
    }
    
    @Test
    public void adding_a_task_item_at_invalid_index_should_through__exception(){
        try{
            for(int index = 0; index < 4; index++){
                taskItem = new DefaultTaskItem();
                dayItem.addTask(taskItem);
                assertTrue(dayItem.getTasks().get(index).getOrderNumber() == index);
            }
            int size = dayItem.getTasks().size();
            taskItem = new DefaultTaskItem();
            dayItem.addTask(taskItem, 8);
        }catch(Exception e){
            return ;
        }
        fail();
    }
    
    @Test
    public void add_a_task_item_should_auto_assign_the_order_no_to_task_item(){
        for(int index = 0; index < 3; index++){
            taskItem = new DefaultTaskItem();
            dayItem.addTask(taskItem);
            assertTrue(dayItem.getTasks().get(index).getOrderNumber() == index);
        }
    }
    
    @Test
    public void remove_task_item_by_order_number(){
        dayItem.addTask(taskItem);
        int size = dayItem.getTasks().size();
        byte orderNo = 0;
        dayItem.removeTask(orderNo);
        assertTrue(dayItem.getTasks().size() == size - 1);
    }
    
    @Test
    public void remove_task_item_by_order_number_must_maintain_correct_ordering(){
        dayItem.addTask(taskItem);
        int size = dayItem.getTasks().size();
        byte orderNo = 0;
        dayItem.removeTask(orderNo);
        fail();
    }
    
    @Test
    public void remove_task_item_by_order_number_illegal_argument_exception_when_no_is_negative(){
        try{
            dayItem.addTask(taskItem);
            int size = dayItem.getTasks().size();
            byte orderNo = -1;
            dayItem.removeTask(orderNo);
        }catch(IllegalArgumentException e){
            return;
        }
        fail();
    }
    
    @Test
    public void reordering_a_task(){
        for(int index = 0; index < 4; index++){
            taskItem = new DefaultTaskItem();
            dayItem.addTask(taskItem);
            assertTrue(dayItem.getTasks().get(index).getOrderNumber() == index);
        }
        taskItem = new DefaultTaskItem();
        String description = "reordering_a_task";
        taskItem.setDescription(description);
        dayItem.reorderTaskItem(taskItem, 0);
        assertTrue(dayItem.getTasks().get(0).getDescription().equals("reordering_a_task"));
    }
    
    @Test
    public void reordering_a_task_must_maintain_correct_ordering(){
        for(int index = 0; index < 4; index++){
            taskItem = new DefaultTaskItem();
            dayItem.addTask(taskItem);
        }
        taskItem = new DefaultTaskItem();
        String description = "reordering_a_task";
        taskItem.setDescription(description);
        dayItem.reorderTaskItem(taskItem, 0);
        for(int index = 0; index < 4; index++){
            assertTrue(dayItem.getTasks().get(index).getOrderNumber() == index);
        }
    }
}