/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayitem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Affan Hasan
 */
public class DefaultDayItem implements DayItem {
    
    private final long date;
    
    private final SimpleDateFormat standardDateFormat = new SimpleDateFormat("EEE, MMM dd yyyy");

    public DefaultDayItem() {
         date = System.currentTimeMillis();
    }

    /**
     * Standard date format is: <b>Thu, Dec 18 2014</b>
     * @param standardDate 
     */
    public DefaultDayItem(String standardDate) throws ParseException {
        date = standardDateFormat.parse(standardDate).getTime();
    }

    @Override
    public long getDateAsLong() {
        return date;
    }

    @Override
    public String getStandardDate() {
        return standardDateFormat.format(new Date(date));
    }
    
}