package com.theironyard;

/**
 * Created by dlocke on 12/23/16.
 */
public class User {

    //variable
    String name;

    //constructor
    public User (String name){
        this.name = name;
    }

    //default constructor
    public User (){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}//end class User