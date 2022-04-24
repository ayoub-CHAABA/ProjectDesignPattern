/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensor;

/**
 *
 * @author Ayoub
 */
public class CameraSensor extends AbstractSensor{
    
    public CameraSensor() {
        super("Camera Sensor", "Une Camera qui filme des videos HD en 24/7", "CameraSensor Notification>Mouvement detecte");
    }
    
}
