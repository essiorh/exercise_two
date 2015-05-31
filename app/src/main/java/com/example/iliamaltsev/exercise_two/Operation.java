package com.example.iliamaltsev.exercise_two;

import java.io.Serializable;

/**
 * Created by Ilia Maltsev on 30.05.2015.
 */
public class Operation implements Serializable{
    private String  firstFragment;
    private String secondFiagment;
    public Operation(String firstFragment,String secondFiagment)
    {
        this.firstFragment=firstFragment;
        this.secondFiagment=secondFiagment;
    }
    public Operation(){}

    public String getFirstFragment() {
        return firstFragment;
    }

    public void setFirstFragment(String firstFragment) {
        this.firstFragment = firstFragment;
    }

    public String getSecondFiagment() {
        return secondFiagment;
    }

    public void setSecondFiagment(String secondFiagment) {
        this.secondFiagment = secondFiagment;
    }
}
