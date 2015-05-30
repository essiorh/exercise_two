package com.example.iliamaltsev.exercise_two;

import java.io.Serializable;

/**
 * Created by Ilia Maltsev on 30.05.2015.
 */
public class Operation implements Serializable{
    private int firstFragment;
    private int secondFiagment;
    public Operation(int firstFragment,int secondFiagment)
    {
        this.firstFragment=firstFragment;
        this.secondFiagment=secondFiagment;
    }
    public Operation(){}

    public int getFirstFragment() {
        return firstFragment;
    }

    public void setFirstFragment(int firstFragment) {
        this.firstFragment = firstFragment;
    }

    public int getSecondFiagment() {
        return secondFiagment;
    }

    public void setSecondFiagment(int secondFiagment) {
        this.secondFiagment = secondFiagment;
    }
}
