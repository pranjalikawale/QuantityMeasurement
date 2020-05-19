package com.bl.quantitymeasurement.controller;

import com.bl.quantitymeasurement.model.Measurement;

public class QuantityMeasurement {

    public double quantity;
    public double getMeasurement(Measurement.Measurements quantityCategory, double length){
        quantity=length;
        quantity=new Measurement(quantityCategory).getMeasurement(quantity);
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuantityMeasurement that=(QuantityMeasurement)o;
        if(quantity==that.quantity && Double.compare(that.quantity,quantity)==0)
            return true;

        //if(this.quantity==that.quantity) return true;
        return false;
    }

}
