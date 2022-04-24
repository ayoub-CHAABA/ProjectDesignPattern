/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa_test;


import app.AbstractApp;
import app.ProxyApp;
import java.util.ArrayList;
import java.util.List;
import user.User;

import java.util.Scanner;
import sensor.AbstractSensor;
import service.CompositeService;
import service.AbstractService;

/**
 *
 * @author Ayoub
 */
public class Main {
    static Scanner sc = new Scanner( System.in );
    static Scanner scStr = new Scanner( System.in );
    
    static AbstractApp app = null;
    public static List<User> allowedUsers = new ArrayList<User>();
    public static CompositeService selectedPackService = new CompositeService();
    public static List<AbstractSensor> installedSensors = new ArrayList<AbstractSensor>();
    
    public static void main(String args[]){
        allowedUsers.add(new User("ayoub"));
        homeMenu();     
    }
    
    public static void homeMenu(){
        int option;
        System.out.println("********** MY APP / Home **********");
        System.out.println("[1] Login");
        System.out.println("[0] Close Menu");
        System.out.println("********** ______ **********");
        
        do{
            option = sc.nextInt();
            if(option == 1){
                loginMenu();
            }
        }while(option != 0);
        
        System.out.println("Closing the app ...");
    }
    
    public static void loginMenu(){
        System.out.println("********** MY APP / Login **********");
        System.out.println("Username: ");
        String username = scStr.nextLine();
        System.out.println(username);
        User user = new User(username);
        app = new ProxyApp(user);
        try {
            app.run();
            packBuildingMenu();
        } catch (Exception ex) {
            System.out.println("Exception occured: " + ex.getMessage());
            loginMenu();
        }
    }
    
    public static void packBuildingMenu(){
    System.out.println("********** MY APP / Services Pack Building **********");
    for(int i=0; i<app.getAvailableServices().size(); i++){
        System.out.print("["+app.getAvailableServices().get(i).id+"]");
        System.out.print(" " + app.getAvailableServices().get(i).getName()+ ": " + app.getAvailableServices().get(i).getDescription() +"\n");
    }
    System.out.println("Entrer la combinaison souhaite (les numeros separe par virgule: ");
    
    
    List<Integer> serviceIds = new ArrayList<Integer>();
    String[] serviceIdsStr = scStr.nextLine().split(",");
    for (String number : serviceIdsStr) {
        serviceIds.add(Integer.parseInt(number.trim()));
    }
    
    List<AbstractService> selectedServices = new ArrayList<AbstractService>();
    for(int j=0; j<serviceIds.size(); j++){
    for(int i=0; i<app.getAvailableServices().size(); i++){
    AbstractService curr = app.getAvailableServices().get(i);
    if(serviceIds.get(j) == curr.id){
        selectedServices.add(curr);
    }}
    }
    
    selectedPackService.setSubServices(selectedServices);
    
    System.out.println("Le prix du pack choisi sera: " + selectedPackService.getPrice() + " MAD");
    System.out.println("Les capteurs requis:");
    for(int i=0; i<selectedPackService.getSubServices().size(); i++){
        for(int j=0; j<selectedPackService.getSubServices().get(i).getSensors().size(); j++){
            installedSensors.add(selectedPackService.getSubServices().get(i).getSensors().get(j));
            selectedPackService.getSubServices().get(i).getSensors().get(j).addObserver(app);
            System.out.println("-" + selectedPackService.getSubServices().get(i).getSensors().get(j).getName() 
                    + ": " + selectedPackService.getSubServices().get(i).getSensors().get(j).getDescription());
        }
    }
    System.out.println("[1] Confimer");
    System.out.println("[0] Refuser");
    int option = sc.nextInt();
    if(option == 1){
        simulationMenu();
    }
    else{
        packBuildingMenu();
    }      
    }
    
    public static void simulationMenu(){
        System.out.println("********** MY APP / Events Simulation **********");
        System.out.println("[-2] Exit Menu");
        System.out.println("[-1] Trigger Sensors Menu");
        for(int i=0; i<selectedPackService.getSubServices().size(); i++){
            AbstractService curr = selectedPackService.getSubServices().get(i);
            System.out.println("["+curr.id+"]"+curr.getName()+": "+curr.getDescription());
        }
        System.out.println("Option #: ");
        int selectedServiceId = sc.nextInt();
        if (selectedServiceId == -2){
            return;
        }
        if(selectedServiceId == -1){
            sensorsTriggerMenu();
        }
        for(int i=0; i<selectedPackService.getSubServices().size(); i++){
            AbstractService curr = selectedPackService.getSubServices().get(i);
            if(curr.id == selectedServiceId){
                curr.loadServiceMenu();
                break;
            }
        }
        simulationMenu();
    }
    
    public static void sensorsTriggerMenu(){
        System.out.println("********** MY APP / Sensors Trigger Simulation **********");
        for(int i=0; i<installedSensors.size(); i++){
            AbstractSensor curr = installedSensors.get(i);
            System.out.println("["+curr.id+"]"+curr.getName()+": "+curr.getDescription());
        }
        System.out.println("Trigger sensor #: ");
        int selectedSensorId = sc.nextInt();
        for(int i=0; i<installedSensors.size(); i++){
            AbstractSensor curr = installedSensors.get(i);
            if(curr.id == selectedSensorId){
                sensorMenu(curr);
                break;
            }
        }
    }
    
    public static void sensorMenu(AbstractSensor sensor){
        System.out.println("********** MY APP / Sensors Trigger Simulation /" + sensor.getName() + " **********");
        System.out.println("[-1] Exit Menu");
        if(sensor.isEnabled)
            System.out.println("[0] Disable Sensor");
        else
            System.out.println("[0] Enable Sensor");
        System.out.println("[1] Trigger Sensor");
        int option = sc.nextInt();
        if(option == -1)
            return;
        if(option == 0){
            if(sensor.isEnabled)
                sensor.disable();
            else
                sensor.enable();
        }
        if(option == 1)
            sensor.trigger();
        sensorMenu(sensor);
    }
    
}
