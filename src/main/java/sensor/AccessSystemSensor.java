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
public class AccessSystemSensor extends AbstractSensor{
    
    public AccessSystemSensor() {
        super("Access System Sensor", "Systeme de pointage d'access par carte", "");
    }
    
    
    public void simulateEntry(){
        message = "AccessSystemSensor Notification>Personne X a entrer";
        trigger();
    }
    
    public void simulateExit(){
        message = "AccessSystemSensor Notification>Personne X a sorti";
        trigger();
    }
}
