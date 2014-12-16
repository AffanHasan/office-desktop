/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task_item;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import taskitem.DefaultTaskItem;
import taskitem.TaskItem;

/**
 * Requirements for newly created TaskItem object
 * 
 * @author Affan Hasan
 */
public class TaskItem_new_object {
    
    private TaskItem taskItem = new DefaultTaskItem();
    
    public TaskItem_new_object() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    
    @Test
    public void task_item_must_return_CATEGORY_as_string() {
        assertTrue(taskItem.getCategory() instanceof String);
    }
    
    @Test
    public void task_item_must_return_CATEGORY_as_empty_string() {
        assertTrue(taskItem.getCategory().equals(""));
    }
    
    @Test
    public void task_item_must_return_DESCRIPTION_as_string() {
        assertTrue(taskItem.getDescription() instanceof String);
    }
    
    @Test
    public void task_item_must_return_DESCRIPTION_as_empty_string() {
        assertTrue(taskItem.getDescription().equals(""));
    }
    
    @Test
    public void task_item_must_return_PENDING_as_status_string() {
        assertTrue(taskItem.getStatus().equals("PENDING"));
    }
    
    @Test
    public void must_have_an_order_number() {
        assertNotNull(taskItem.getOrderNumber());
    }
    
}