/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskitem;

/**
 * Represents a TaskItem
 * @author root
 */
public interface TaskItem {
    
    String getCategory();
    
    void setCategory(String category);
    
    String getStatus();
    
    void setStatus(String status);
    
    String getDescription();
    
    void setDescription(String description);
}