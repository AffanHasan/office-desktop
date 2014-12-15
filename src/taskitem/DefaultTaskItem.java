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
    
    private String status = "";
    
    private final PersistenceEngine pEngine = FileBasedDataStore.getInstance();

    public DefaultTaskItem() {
        this.status = pEngine.getDefaultStatusName();
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public String getStatus() {
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
    public void setStatus(String status) {
        this.status = status;
    }
    
}
