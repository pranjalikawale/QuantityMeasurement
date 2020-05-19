package com.bl.quantitymeasurement.model;

public class Measurement {
    //Variable
    public double quantity;
    //Constructor
    public Measurement(ConversionUnit quantity) {
        this.quantity=quantity.measurement;
    }
    //Enum of different unit
    public enum Unit{FEET,INCH,YARD,CENTIMETER,LITER,MILILITER,GALLON,KILOGRAM,GRAM,TON,CELSIUS,FAHRENHEIT;}
    //Enum of Conversion Type
    public enum ConversionUnit{FEETTOINCH(12),INCHTOFEET(0.084),FEETTOYARD(0.334),YARDTOFEET(3)
                             ,INCHTOYARD(0.028),YARDTOINCH(36),CENTIMETERTOINCH(0.40),INCHTOCENTIMETER(2.54);
        public double measurement;
        ConversionUnit(double i) {
            this.measurement=i;
        }
    };
    //Method for conversion of unit
    public double getMeasurement(double length){
        if(length>0)
            length*=quantity;
        return Math.max(length,0.0);
    }

}
