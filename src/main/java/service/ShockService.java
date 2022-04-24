/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import sensor.ShockSensor;

/**
 *
 * @author Ayoub
 */
public class ShockService extends AbstractService{

    public ShockService() {
        super("Service de detection de choques", "Detecteur de vibrations fortes", 20);
        this.sensors.add(new ShockSensor());
    }


}
