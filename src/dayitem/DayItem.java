/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayitem;

/**
 *
 * @author Affan Hasan
 */
public interface DayItem {
        
    long getDateAsLong();
    
    /**
     * Standard string format for Date is for example : <b>Wed, Dec 17 2014</b>
     * @return 
     */
    String getStandardDate();
}