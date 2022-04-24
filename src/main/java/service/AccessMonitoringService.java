/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import sensor.AccessSystemSensor;



/**
 *
 * @author Ayoub
 */
public class AccessMonitoringService extends AbstractService{

    public AccessMonitoringService() {
        super("System de pointage", "Connaitre les entres et sorties a toute heure de la journee", 60);
        this.sensors.add(new AccessSystemSensor());
    }


    
}
