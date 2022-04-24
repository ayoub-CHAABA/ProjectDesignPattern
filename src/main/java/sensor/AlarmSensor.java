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
public class AlarmSensor extends AbstractSensor{

    public AlarmSensor() {
        super("Alarm Sensor", "Une alarme qui peut etre activee a la demande pour sonner", "AlarmSensor Notification>Sonne");
    }

}
