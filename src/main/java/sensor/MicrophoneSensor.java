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
public class MicrophoneSensor extends AbstractSensor{
    public MicrophoneSensor() {
        super("Microphone Sensor", "Un microphone qui peut enregistrer le son dans une chambre", "MicrophoneSensor Notification>Son detecte");
    }
}
