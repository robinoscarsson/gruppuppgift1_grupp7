/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.pagebeans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import se.nackademin.domain.User;
import se.nackademin.session.SessionBean;
import se.nackademin.backend.FakeDB;

/**
 *
 * @author carl
 */
@Named
@RequestScoped
public class AuthenticationPageBean {

    @Inject
    SessionBean sessionHandler;

    private User selectedUser;

    public String doLogin() {
        if (getSessionHandler().retrieve(getSelectedUser().getId()) != null) {
            throw new RuntimeException("Du är redan inloggad "
                    + getSelectedUser().getUserName());
        }
        User dbUser = FakeDB.getUser(getSelectedUser().getUserName());
        if(dbUser != null && dbUser.getUserName().equals(getSelectedUser().getUserName())
                && dbUser.getPassword().equals(getSelectedUser().getPassword())){
            getSessionHandler().persist(getSelectedUser());
            System.out.println("Inloggning fungerar.");
            return "/userPages/welcome.xhtml";
        } else {
            return "/outcomes/loginFailed.xhtml";
        }
        
    }
    public String doLogout() {
        setSelectedUser(null);
        System.out.println("Loggat ut!");
        return "/index.xhtml";
    }

    // Getters and setters
    public User getSelectedUser() {
        if (selectedUser == null) {
            selectedUser = new User();
        }
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;

    }

    public SessionBean getSessionHandler() {
        return sessionHandler;
    }

    public void setSessionHandler(SessionBean sessionHandler) {
        this.sessionHandler = sessionHandler;
    }
}
