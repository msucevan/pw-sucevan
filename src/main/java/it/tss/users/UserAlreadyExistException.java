package it.tss.users;

import javax.ejb.EJBException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author spaceman33
 */
public class UserAlreadyExistException extends EJBException {

    private final String username;

    public UserAlreadyExistException(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

}
