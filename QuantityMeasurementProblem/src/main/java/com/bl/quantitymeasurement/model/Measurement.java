package com.bl.quantitymeasurement.model;

public class Measurement {
    //Variable
    public double quantity;
    /**
     * @purpose: Constructor
     * @param: quantity
     */
    public Measurement(ConversionUnit quantity) {
        this.quantity=quantity.measurement;
    }
    //Enum of different unit
    public enum Unit{FEET,INCH,YARD,CENTIMETER,LITER,MILILITER,GALLON,KILOGRAM,GRAM,TON,CELSIUS,FAHRENHEIT;}
    //Enum of Conversion Type
    public enum ConversionUnit{FEETTOINCH(12),INCHTOFEET(0.084),FEETTOYARD(0.334),YARDTOFEET(3)
                             ,INCHTOYARD(0.028),YARDTOINCH(36),CENTIMETERTOINCH(0.40),INCHTOCENTIMETER(2.54)
                             ,LITERTOMILILITER(1000),MILILITERTOLITER(0.001),GALLONTOLITER(3.78)
                             ,LITERTOGALLON(0.265),KILOGRAMTOGRAM(1000),GRAMTOKILOGRAM(0.001)
                             ,TONTOKILOGRAM(1000),KILOGRAMTOTON(0.00113);
        public double measurement;
        ConversionUnit(double i) {
            this.measurement=i;
        }
    };

    /**
     * @purpose: Method for conversion of unit
     * @param: length
     * @return: Unit in double
     */
    public double getMeasurement(double length){
        if(length>0)
            length*=quantity;
        return Math.max(length,0.0);
    }

    /**
     * @purpose: Conversion of temperature
     * @param: temperature,category
     * @return: temperature
     */
    public static double temperatureConversion(double temperature,Measurement.Unit category){
        if(category==Unit.CELSIUS)
            return Math.max(((temperature*1.8)+32),0.0);
        return Math.max(((temperature-32)/1.8),0.0);
    }

}
