package com.example.a1_hw4_recview;


import java.io.Serializable;

public class MessageModel implements Serializable {
    private String name;
    private String message;

    public MessageModel(String name, String message) {
        this.name = name;
        this.message = message;
    }


    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

}
