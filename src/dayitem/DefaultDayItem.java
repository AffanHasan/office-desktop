/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayitem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import taskitem.TaskItem;

/**
 *
 * @author Affan Hasan
 */
public class DefaultDayItem implements DayItem {
    
    private final long date;
    
    private final SimpleDateFormat standardDateFormat = new SimpleDateFormat("EEE, MMM dd yyyy");
    
    private final List<TaskItem> taskList = new ArrayList<>();

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

    @Override
    public List<TaskItem> getTasks() {
        return taskList;
    }

    @Override
    public void addTask(TaskItem task) {
        taskList.add(task);
        int size = taskList.size();
        taskList.get(size - 1).setOrderNumber(size -1);
    }
    
    @Override
    public void addTask(TaskItem task, int index) {
        taskList.add(index, task);
//      Reordering the order numbers
        byte orderNo = 0;
        for(TaskItem item : taskList){
            item.setOrderNumber(orderNo++);
        }
    }

    @Override
    public void removeTask(int orderNo) {
        if(orderNo >= 0)
            taskList.remove(orderNo);
        else
            throw new IllegalArgumentException("orderNo must not be smaller than 0");
    }
    
}