/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import user.User;
import aa_test.Main;
import java.util.List;
import service.CompositeService;
import service.AbstractService;
/**
 *
 * @author Ayoub
 */
public class ProxyApp extends AbstractApp {
    
    private static App app = null;
    public User currentUser;

    public ProxyApp(User currentUser) {
        this.currentUser = currentUser;
    }
    
    private App getAppInstance(){
        if(ProxyApp.app == null)
            ProxyApp.app = new App();
        return ProxyApp.app;
    }
    
    public boolean isAuthorized(){
        // checking if the user is in the allowed users
        for(int i=0; i<Main.allowedUsers.size(); i++){
            if(Main.allowedUsers.get(i).username.equals(currentUser.username)){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void run() throws Exception{
        if(isAuthorized())
            getAppInstance().run();
        else
            throw new Exception("ProxyApp > run() > User unauthorized, can not start the app");
    }

    public List<AbstractService> getAvailableServices() {
        return app.availableServices;
    }

    public void setAvailableServices(List<AbstractService> availableServices) {
        app.availableServices = availableServices;
    }

    public CompositeService getCurrentPack() {
        return app.currentPack;
    }

    public void setCurrentPack(CompositeService currentPack) {
        app.currentPack = currentPack;
    }
    
}
