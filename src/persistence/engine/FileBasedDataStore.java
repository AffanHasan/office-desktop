/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.engine;

/**
 * @author Affan Hasan
 */
public class FileBasedDataStore implements PersistenceEngine {
    
    /**
     * Making this constructor a private in order to make it singleton
     */
    private FileBasedDataStore(){
    }
    
//    private enum STATUS_LIST{
//        PENDING,
//        IN_PROGRESS,
//        DONE,
//        DISCARDED
//    }
    
    private final String[] statusNames = {"PENDING", "IN PROGRESS", "DONE", "DISCARDED"};

    @Override
    public String[] getStatusNames() {
        return statusNames;
    }
    
    private static class Holder{
        private static final FileBasedDataStore holder = new FileBasedDataStore();
    }
    
    /**
     * Since this class is implemented as singleton; hence this is the factory method.
     * @return 
     */
    public static FileBasedDataStore getInstance(){
        return Holder.holder;
    }
    
    @Override
    public String getDefaultStatusName() {
        return statusNames[0];
    }
    
}
