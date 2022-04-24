/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensor;

import observer.AbstractObservable;
import observer.Observer;

/**
 *
 * @author Ayoub
 */
public abstract class AbstractSensor extends AbstractObservable implements Sensor {
    
    private static int counter = 0;
    
    public int id;
    public String name;
    public String description;
    public String message;
    public boolean isEnabled = true;

    public AbstractSensor(String name, String description, String message) {
        this.id = ++counter;
        this.name = name;
        this.message = message;
        this.description = description;
    }



    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public void enable() {
        this.isEnabled = true;
    }
    
    @Override
    public void disable() {
        this.isEnabled = false;
    }
    
    @Override
    public void trigger() {
        if(isEnabled)
            notifyObservers();
        else
            System.out.println("Sensor " + name + " is disabled");
    }
    
    @Override
    public void getData(){}
    
    @Override
    public void notifyObservers(){
        for(int i=0; i < this.observers.size(); i++){
            this.observers.get(i).update(message);
        }
    }
    
    @Override
    public void addObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        for(int i=0; i < this.observers.size(); i++){
            if (this.observers.get(i) == o){
                this.observers.remove(o);
            }
        }
    }
}
