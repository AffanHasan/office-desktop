/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskitem;

import persistence.engine.FileBasedDataStore;
import persistence.engine.PersistenceEngine;

/**
 *
 * @author root
 */
public class DefaultTaskItem implements TaskItem {
    
    private String category = "";
    
    private String description = "";
    
    private PersistenceEngine.STATUS_LIST status = null;
    
    private int orderNumber;
    
    private final PersistenceEngine pEngine = FileBasedDataStore.getInstance();

    public DefaultTaskItem() {
        this.status = PersistenceEngine.STATUS_LIST.PENDING;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public PersistenceEngine.STATUS_LIST getStatus() {
        return status;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getOrderNumber() {
        return orderNumber;
    }

    @Override
    public void setOrderNumber(int orderNo) {
        if(orderNo < 0){
            throw new IllegalArgumentException("Order Number Must Not Be Negative");
        }
        this.orderNumber = orderNo;
    }

    @Override
    public String getTotalTime() {
        return getCalculatedTime();
    }
    
    private String getCalculatedTime(){
        return "0 minute(s)";
    }

    @Override
    public void setStatus(PersistenceEngine.STATUS_LIST status) {
        if(status != null)
            this.status = status;
        else{
            throw  new IllegalArgumentException("Status cannot be null");
        }
    }
    
}