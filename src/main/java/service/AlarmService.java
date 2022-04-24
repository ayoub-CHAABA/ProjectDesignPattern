/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import sensor.AlarmSensor;

/**
 *
 * @author Ayoub
 */
public class AlarmService extends AbstractService{

    public AlarmService() {
        super("Service d'alarme", "Activer et Desactiver votre alarme maison", 20);
        this.sensors.add(new AlarmSensor());
    }


    
}
