package com.nokia.example.Entity;

/**
 * Created by YLongYao on 2016/11/13.
 */
public enum  EnumT {

    ADMIN(""),
    NONMOL("");

    private String meaning;

    EnumT(String meaning){
        this.meaning = meaning;
    }

    public String getMeaning(){
        return this.meaning;
    }
}
