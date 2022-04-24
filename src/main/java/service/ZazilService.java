/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import sensor.ZazilSensor;



/**
 *
 * @author Houssam
 */
public class ZazilService extends AbstractService {
    public ZazilService() {
        super("Service Zazil", "transporter", 100);
        this.sensors.add(new ZazilSensor());
    }
}
