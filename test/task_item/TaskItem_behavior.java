/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task_item;

import java.util.Arrays;
import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import persistence.engine.FileBasedDataStore;
import persistence.engine.PersistenceEngine;
import taskitem.DefaultTaskItem;
import taskitem.TaskItem;

/**
 *
 * @author root
 */
public class TaskItem_behavior {
    
    private TaskItem taskItem;
    private final String category = "Personalized Menus";
    private final String description = "Some task";
    private final String status = null;
    
    private final PersistenceEngine pEngine = FileBasedDataStore.getInstance();
    
    public TaskItem_behavior() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        taskItem = new DefaultTaskItem();
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    
    @Test
    public void must_set_category_as_string() {
        taskItem.setCategory(category);
        assertTrue(taskItem.getCategory().equals(category));
    }
    
    @Test
    public void must_not_null_after_setting_CATEGORY() {
        taskItem.setCategory(category);
        assertNotNull(taskItem.getCategory());
    }
    
    @Test
    public void must_not_empty_after_setting_CATEGORY() {
        taskItem.setCategory(category);
        assertTrue(taskItem.getCategory().length() > 0);
    }
    
    @Test
    public void must_set_description_as_string() {
        taskItem.setDescription(description);
        assertTrue(taskItem.getDescription().equals(description));
    }
    
    @Test
    public void must_not_null_after_setting_DESCRIPTION() {
        taskItem.setDescription(description);
        assertNotNull(taskItem.getDescription());
    }
    
    @Test
    public void must_not_empty_after_setting_DESCRIPTION() {
        taskItem.setDescription(description);
        assertTrue(taskItem.getDescription().length() > 0);
    }
    
    @Test
    public void must_throw_IllegalArgumentException_when_a_status_value_not_present_in_db_is_passed_as_status() {
        try{
          taskItem.setStatus("$%#@@##***");
        }catch(IllegalArgumentException e){
            return;
        }
        fail();
    }
    
    @Test
    public void must_accept_those_status_values_which_are_in_DB() {
        for(String status : this.getStatusListFromDB()){
            taskItem.setStatus(status);
            assertEquals(taskItem.getStatus(), status);
        }
    }
    
    private String[] getStatusListFromDB(){
        return pEngine.getStatusNames();
    }
    
    @Test
    public void must_accept_a_byte_as_order_number(){
        byte number = 1;
        taskItem.setOrderNumber(number);
        assertEquals(this.taskItem.getOrderNumber(), number);
    }
    
    @Test
    public void must_not_accept_a_negative_byte_value_as_order_number(){
        byte number = 127;
        try{
            taskItem.setOrderNumber(number);        
        }catch(IllegalArgumentException e){
            return;
        }
        fail();
    }
    
}