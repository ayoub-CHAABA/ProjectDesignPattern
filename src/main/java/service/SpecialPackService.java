/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author Houssam
 */
public class SpecialPackService extends CompositeService{
    public SpecialPackService() {
        super("Pack Special Ramadan", "");
        subServices.add(new AlarmService());
        subServices.add(new ZazilService());
        
        
        String packDescription = subServices.get(0).getDescription();
        for(int i=1; i<subServices.size(); i++){
            packDescription += ", " + subServices.get(i).getName();
        }
        setDescription(packDescription);
        
        setPromo((float) 0.5);
    }

}
