package com.homeoffice.nanoerp.gen;

import models.general.User;

import org.junit.Test;

import play.db.jpa.JPA;


public class UserModelTest {

    @Test
    public void basicCRUDTest() {
        try {
            // create user
            User user = new User("Name", "Email");
            JPA.em().persist(user);
            // find such user
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
