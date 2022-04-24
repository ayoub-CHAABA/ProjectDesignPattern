/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.ArrayList;
import java.util.List;
import observer.Observer;
import service.CompositeService;
import service.AbstractService;

/**
 *
 * @author Ayoub
 */
public abstract class AbstractApp  implements Observer<String>{
    public List<AbstractService> availableServices = new ArrayList<AbstractService>();
    public CompositeService currentPack = null;
    
    public abstract void run() throws Exception;

    public List<AbstractService> getAvailableServices() {
        return availableServices;
    }

    public void setAvailableServices(List<AbstractService> availableServices) {
        this.availableServices = availableServices;
    }

    public CompositeService getCurrentPack() {
        return currentPack;
    }

    public void setCurrentPack(CompositeService currentPack) {
        this.currentPack = currentPack;
    }

    @Override
    public void update(String message) {
        System.out.println(">>>> " + message);
    }
    
    
}
