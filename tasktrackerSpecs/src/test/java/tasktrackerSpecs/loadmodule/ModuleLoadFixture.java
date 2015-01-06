/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tasktrackerSpecs.loadmodule;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

/**
 *
 * @author Affan Hasan
 */
@RunWith(ConcordionRunner.class)
public class ModuleLoadFixture {
    
    public String getGreeting() {
        return "Hello World!";
    }
}