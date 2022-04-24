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
public class CompositeService extends AbstractService{
    List<AbstractService> subServices = new ArrayList<AbstractService>();
    float promo = 0;

    public CompositeService(String name, String description) {
        super(name, description);
    }
    
    public CompositeService() {
    }

    public List<AbstractService> getSubServices() {
        return subServices;
    }

    public void setPromo(float promo) {
        this.promo = promo;
    }

    public void setSubServices(List<AbstractService> subServices) {
        this.subServices = subServices;
    }
    
    @Override
    public float getPrice(){
        float price = 0;
        for(int i=0; i<subServices.size(); i++){
            price += subServices.get(i).getPrice();
        }
        return price * (1 - promo);
    }
    
    @Override
    public List<AbstractSensor> getSensors(){
        List<AbstractSensor> result = new ArrayList<AbstractSensor>();
        for(int i=0; i<subServices.size(); i++){
            for(int j=0; j<subServices.get(i).getSensors().size(); j++){
                result.add(subServices.get(i).getSensors().get(j));
            }
        }
        return result;
    }
    
    @Override
    public void loadServiceMenu(){
        for(int i=0; i<subServices.size(); i++){
            subServices.get(i).loadServiceMenu();
        }
    }

    
}
