/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task_item;

import java.sql.Time;
import java.time.Instant;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
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
    private PersistenceEngine.STATUS_LIST status = null;
    
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
    public void must_accept_a_byte_as_order_number(){
        byte number = 1;
        taskItem.setOrderNumber(number);
        assertEquals(this.taskItem.getOrderNumber(), number);
    }
    
    @Test
    public void must_not_accept_a_negative_byte_value_as_order_number(){
        byte number = -1;
        try{
            taskItem.setOrderNumber(number);
        }catch(IllegalArgumentException e){
            return;
        }
        fail();
    }
    
    @Test
    public void must_return_status_as_STATUS_LIST(){
        assertTrue(taskItem.getStatus() instanceof PersistenceEngine.STATUS_LIST);
    }
    
    @Test
    public void must_accept_status_as_STATUS_LIST_value(){
        taskItem.setStatus(PersistenceEngine.STATUS_LIST.IN_PROGRESS);
        assertEquals(taskItem.getStatus(), PersistenceEngine.STATUS_LIST.IN_PROGRESS);
    }
    
    @Test
    public void must_throw_illegalArgsException_when_null_is_passed_as_status(){
        try{
            taskItem.setStatus(null);
        }catch(IllegalArgumentException e){
            return;
        }
        fail();
    }
    
    @Test
    public void status_changing_status_must_record_time_stamp(@Mocked("now") Instant instant){
        Instant base =  Instant.parse("2007-12-03T10:15:30.00Z");
//      Wait for random time intervals
            for(long i = 1; i < 10; i++){
                
                new Expectations(){
                    {
                        Instant.now();
                        result = base;
                    }
                };
                taskItem.setStatus(PersistenceEngine.STATUS_LIST.IN_PROGRESS);
                final long counter = i;
                new Expectations(){
                    {
                        Instant.now();
                        result = base.plusSeconds(counter);
                    }
                };
                taskItem.setStatus(PersistenceEngine.STATUS_LIST.DONE);
                assertTrue(taskItem.getTotalTime().equals(i + " second(s)"));
            }
    }
    
}