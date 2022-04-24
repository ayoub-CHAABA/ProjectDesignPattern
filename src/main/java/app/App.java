/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;


import service.AccessMonitoringService;
import service.AlarmService;
import service.BasicPackService;
import service.ShockService;
import service.SpecialPackService;
import service.WatchService;
import service.ZazilService;

/**
 *
 * @author Ayoub
 */
public class App extends AbstractApp{
    
    
    
    public void init(){
        availableServices.add(new BasicPackService());
        availableServices.add(new AlarmService());
        availableServices.add(new AccessMonitoringService());
        availableServices.add(new WatchService());
        availableServices.add(new ShockService());
        availableServices.add(new ZazilService());
        availableServices.add(new SpecialPackService());
    }
    
    @Override
    public void run() {
        System.out.println("App > run() > Application Started");
        init();
    }

    @Override
    public void update(String message) {
        System.out.println(message);
    }


    
}
