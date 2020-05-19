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
    public String checkEquality(Measurement.Unit type1,double val1,Measurement.Unit type2,double val2){
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
        var = String.valueOf(type1) + "TO" + String.valueOf(type2);
        Measurement.ConversionUnit type3 = Measurement.ConversionUnit.valueOf(var);
        val1 = getMeasurement(type3, val1);
        return val1;
    }
    //Value are equal or not
    public String checkForValueEquality(double val1,double val2){
        if(Double.compare(val1,val2)==0)
            return "Equal";
        return "Not Equal";
    }
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
