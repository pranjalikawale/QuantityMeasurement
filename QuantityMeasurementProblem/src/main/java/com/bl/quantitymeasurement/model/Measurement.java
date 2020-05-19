package com.bl.quantitymeasurement.model;

public class Measurement {

    public double quantity;
    public Measurement(Measurements quantity) {
        this.quantity=quantity.measurement;
    }
    public enum Unit{FEET,INCH,YARD,CENTIMETER,LITER,MILILITER,GALLON,KILOGRAM,GRAM,TON,CELSIUS,FAHRENHEIT;}
    public enum Measurements{FEETTOINCH(12);
        public double measurement;
        Measurements(double i) {
            this.measurement=i;
        }
    };

    public double getMeasurement(double length){
        if(length>0)
            length*=quantity;
        return Math.max(length,0.0);
    }

}
