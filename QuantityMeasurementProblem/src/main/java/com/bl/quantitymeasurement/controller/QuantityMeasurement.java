package com.bl.quantitymeasurement.controller;

import com.bl.quantitymeasurement.model.Measurement;

public class QuantityMeasurement {
    //Variables
    public double quantity;
    //Conversion of unit
    public double getMeasurement(Measurement.ConversionUnit quantityCategory, double length){
        quantity=length;
        quantity=new Measurement(quantityCategory).getMeasurement(quantity);
        return quantity;
    }
    //Check the Equality of units
    public boolean checkEquality(Measurement.Unit type1,double val1,Measurement.Unit type2,double val2){
        if(checkType(type1,type2))
            val1=convertUnit(type1,val1,type2);
        return checkForValueEquality((int)val1,(int)val2);
    }
    //Check unit type is same or not
    public boolean checkType(Measurement.Unit type1,Measurement.Unit type2){
        if(type1!=type2)
            return true;
        return false;
    }
    //Conversion of two different unit into one
    public double convertUnit(Measurement.Unit type1,double val1,Measurement.Unit type2){
        String var=null;
        if(!(type1.equals(Measurement.Unit.CELSIUS) || type1.equals(Measurement.Unit.FAHRENHEIT))){
            var = String.valueOf(type1) + "TO" + String.valueOf(type2);
            Measurement.ConversionUnit type3 = Measurement.ConversionUnit.valueOf(var);
            val1 = getMeasurement(type3, val1);
        }
        else
            val1 = Measurement.temperatureConversion(val1, type1);
        return val1;
    }
    //Value are equal or not
    public boolean checkForValueEquality(double val1,double val2){
        if(Double.compare(val1,val2)==0)
            return true;
        return false;
    }
    //Perform Addition
    public double performAddition(Measurement.Unit type1,double val1,Measurement.Unit type2,double val2,Measurement.Unit type3){
        if(val1==0)  //we are converting V1 to V2
            return val2;
        if (checkType(type1,type3))
            val1 = convertUnit(type1, val1, type3);
        if (checkType(type2,type3))
            val2 = convertUnit(type2, val2, type3);
        return addition(val1,val2);
    }
    //Addition of two value
    public double addition( double value1,double value2){
        return value1+value2;
    }
    //Override equal method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuantityMeasurement that=(QuantityMeasurement)o;
        if(quantity==that.quantity && Double.compare(that.quantity,quantity)==0)
            return true;
        return false;
    }

}
