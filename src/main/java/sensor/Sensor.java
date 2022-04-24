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
public interface Sensor {
    public void enable();
    public void disable();
    public void trigger();
    public void getData();
}
