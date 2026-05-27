package com.pluralsight;

import java.time.LocalDate;

public class Vehicle extends Asset{

    private String makeModel;
    private int year;
    private int odometer;


    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
    public int add(int number1, int number2){
        return number1 + number2;
    }

    public int add(int number1, int number2, int numer3){
        return number1 + number2 + numer3;
    }



    @Override
    public double getValue(){
        double value;
        int currentYear = LocalDate.now().getYear();
        int age = currentYear - year;
        switch (age){
            case 1, 2, 3:
                value = getOriginalCost() - getOriginalCost()*.03;
            case 4, 5, 6:
                value = getOriginalCost() - getOriginalCost()*.06;
            case 7, 8, 9, 10:
                value = getOriginalCost() - getOriginalCost()*.08;
            default:
                value = 1000;
        }

        if(odometer > 100000 && (!makeModel.equalsIgnoreCase("Honda") && !makeModel.equalsIgnoreCase("Toyota"))){
            value -= value * .25;
        }
        return value;

    }
   // 0-3 years old - 3% reduced value of cost per year
// 4-6 years old - 6% reduced value of cost per year
// 7-10 years old - 8% reduced value of cost per year
// over 10 years old - $1000.00
// MINUS reduce final value by 25% if over 100,000 miles
// unless makeModel contains word Honda or Toyota
}
