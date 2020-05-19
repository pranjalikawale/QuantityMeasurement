package com.bl.quantitymeasurement.model;

public class Measurement {

    public double quantity;
    public Measurement(ConversionUnit quantity) {
        this.quantity=quantity.measurement;
    }
    public enum Unit{FEET,INCH,YARD,CENTIMETER,LITER,MILILITER,GALLON,KILOGRAM,GRAM,TON,CELSIUS,FAHRENHEIT;}
    public enum ConversionUnit{FEETTOINCH(12),INCHTOFEET(0.084),FEETTOYARD(0.334),YARDTOFEET(3);
        public double measurement;
        ConversionUnit(double i) {
            this.measurement=i;
        }
    };

    public double getMeasurement(double length){
        if(length>0)
            length*=quantity;
        return Math.max(length,0.0);
    }

}
