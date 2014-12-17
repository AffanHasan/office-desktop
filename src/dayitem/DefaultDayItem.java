/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayitem;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Affan Hasan
 */
public class DefaultDayItem implements DayItem {
    
    private final long date = System.currentTimeMillis();
    
    private final String standardDatePattern = "EEE, MMM dd, yyyy";

    @Override
    public long getDateAsLong() {
        return date;
    }

    @Override
    public String getStandardDate() {
        return new SimpleDateFormat(standardDatePattern).
                format(new Date(date));
    }
    
}
