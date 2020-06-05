/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.User;

/**
 *
 * @author Acer
 */
public class UserDataManager {
    public User findUser(String username,String password){
        if("admin".equalsIgnoreCase(username)&& "1234".equalsIgnoreCase(password)){
            return new User("admin","1234");
        }
        return null;
    }
}
