package com.nokia.example.Basics.Abstract;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public abstract class AbstractClassC extends AbstractClassA{

    private String a = "s";
    public String b = "k";
    public int getNum(){
        return 4;
    }

    abstract void menthodS();

    public static void main(String args[]){
        AbstractClassC c = new AbstractClassC() {
            @Override
            void menthodS() {

            }

            @Override
            protected void MethodA() {

            }

            @Override
            void MethodC() {

            }

            @Override
            public void MethodD() {

            }
            public int getNum(){
                return 5;
            }

        };
        System.out.println(c.getNum());
    }

}
