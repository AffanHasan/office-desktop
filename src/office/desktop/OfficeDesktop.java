/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package office.desktop;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.time.temporal.ValueRange;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
class OfficeDesktop {
    static A a ;
    /**
     * @param args the command line arguments
     */
    public static void main(String... args){
        a = new B();
        a.m1();
    }
    
    static class A{
        A(){
            System.out.println("Constructor A");
            m1();
        }
        
        void m1(){
            System.out.println("A: m1 called");
        }
    }
    
    static class B extends A{
        
        B(){
            System.out.println("Constructor B");
            m1();
        }

        @Override
        void m1() {
            System.out.println("B: m1 called");
        }
    }
    
}