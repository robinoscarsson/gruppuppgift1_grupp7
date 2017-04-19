/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.pagebeans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import se.nackademin.domain.User;
import se.nackademin.services.UserHandler;

/**
 *
 * @author carl
 */
@Named
@RequestScoped
public class RegisterBean {

    User selected;

    @Inject
    private UserHandler userHanldler;

    public User getSelectedUser() {
        if (selected == null) {
            selected = new User();
        }
        return selected;
    }

    public void setSelectedUser(User selectedUser) {
        this.selected = selectedUser;
    }

    public void doRegister() {
        User registeredUser = userHanldler.doRegister(getSelectedUser());
        registeredUser.setActive(true);
        System.out.println("Regg lyckades!");
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Registreringen lyckades!"));
    }
}
