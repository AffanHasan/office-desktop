/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayitem;

import java.text.SimpleDateFormat;
import java.util.Date;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author root
 */
public class DayItem_New_Object {
    
    private final DayItem dayItem = new DefaultDayItem();
    
    public DayItem_New_Object() {
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
    public void dayItem_must_have_date_as_milliseconds_long(){
        try{
            long date = dayItem.getDateAsLong();
            new Date(date);
        }catch(NullPointerException e ){
            fail();
        }
        catch(Exception e){
            fail();
        }
    }
    
    @Test
    public void date_must_be_equal_to_current_system_date(){
        Date currentDate = new Date(System.currentTimeMillis());
        Date objectDate = new Date(dayItem.getDateAsLong());
        SimpleDateFormat sdf = new SimpleDateFormat();
        assertEquals(sdf.format(objectDate), sdf.format(currentDate));
    }
    
    /**
     * Standard string format for Date is : <b>Wed, Dec 17 2014</b>
     */
    @Test
    public void must_return_date_in_standard_string_format(){
        SimpleDateFormat standardDateFormat = new SimpleDateFormat("EEE, MMM dd, yyyy");
        String currentDate = standardDateFormat.format(new Date(System.currentTimeMillis()));
        String objectDate = dayItem.getStandardDate();
        assertEquals(objectDate, currentDate);
    }
}