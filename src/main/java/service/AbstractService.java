/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import sensor.AbstractSensor;

/**
 *
 * @author Ayoub
 */
public abstract class AbstractService implements Service{
    
    private static int counter = 0;
    
    public int id;
    public String name;
    public String description;
    public List<AbstractSensor> sensors = new ArrayList<AbstractSensor>();
    public float price = 0;
    
    public AbstractService(String name, String description, float price) {
        this.id = ++counter;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public AbstractService(String name, String description) {
        this.id = ++counter;
        this.name = name;
        this.description = description;
    }
    
    public AbstractService() {
        this.id = ++counter;

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<AbstractSensor> getSensors() {
        return sensors;
    }
   
    @Override
    public void loadServiceMenu(){
        System.out.println("******** Service["+name+"] ********");
        System.out.println("\n\n\n Simulation .... \n\n\n" + description);
        System.out.println("\n\n\n******** ______ ********");
    };
}
