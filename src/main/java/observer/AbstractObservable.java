/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Ayoub
 */

public abstract class AbstractObservable implements Observable {
    public List<Observer> observers = new ArrayList();
        
}
