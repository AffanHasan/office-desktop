/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.engine;

/**
 * Interface for the persistence engine
 * @author Affan Hasan
 */
public interface PersistenceEngine {
    
    /**
     * 
     * @return The string name of default status
     */
    String getDefaultStatusName();
}