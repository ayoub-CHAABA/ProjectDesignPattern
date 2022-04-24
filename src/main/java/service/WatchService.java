/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import sensor.CameraSensor;
import sensor.MicrophoneSensor;


/**
 *
 * @author Ayoub
 */
public class WatchService extends AbstractService{

    public WatchService() {
        super("Service de surveillance", "Ecouter et observer ce qui se passe dans une piece equipee d'une camera et un microphone", 20);
        this.sensors.add(new CameraSensor());
        this.sensors.add(new MicrophoneSensor());
    }


    
}
