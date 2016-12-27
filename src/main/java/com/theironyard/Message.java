package com.theironyard;

import javax.persistence.*;

/**
 * Created by dlocke on 12/23/16.
 */

@Entity
@Table(name = "messages")
public class Message {

    //variables
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String text;

    //constructor
    public Message(int id, String text) {
        this.id = id;
        this.text = text;
    }

    //default constructor
    public Message (){

    }

    public Message (String text){
        this.text = text;
    }

    public Message (int id){
        this.id = id;
    }

}//end class Message