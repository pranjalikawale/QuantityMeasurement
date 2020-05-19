package com.bl.quantitymeasurementtest;

import com.bl.quantitymeasurement.controller.QuantityMeasurement;
import com.bl.quantitymeasurement.model.Measurement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuantityMeasurementTest {
    QuantityMeasurement quantityMeasurement;

    @Before
    public void setUp() {
        quantityMeasurement=new QuantityMeasurement();
    }

    @Test
    public void givenLengthInFeet_WhenProper_ShouldReturnInch() {
        Assert.assertEquals(12.0, quantityMeasurement
                .getMeasurement(Measurement.ConversionUnit.FEETTOINCH,1),0.0);
    }
    @Test
    public void givenLengthInFeet_WhenZero_ShouldReturnInch() {
        Assert.assertEquals(0.0, quantityMeasurement
                .getMeasurement(Measurement.ConversionUnit.FEETTOINCH,0),0.0);
    }

    @Test
    public void givenLengthInFeet_WhenImproper_ShouldReturnInch() {
        Assert.assertEquals(0.0, quantityMeasurement
                .getMeasurement(Measurement.ConversionUnit.FEETTOINCH,-1),0.0);
    }
    //1.1
    @Test
    public void givenZeroFeetZeroFeet_WhenEqual_ShouldReturnTrue() {
        Assert.assertTrue(quantityMeasurement.checkEquality(Measurement.Unit.FEET,0,
                                                            Measurement.Unit.FEET,0));
    }
    @Test
    public void givenObject_WhenNull_ShouldReturnFalse() {
        QuantityMeasurement quantityMeasurement1=null;
        Assert.assertNotEquals(quantityMeasurement1,quantityMeasurement);
    }
    @Test
    public void checkForObject_WhenReferenceEqual_ShouldReturnTrue() {
        quantityMeasurement.getMeasurement(Measurement.ConversionUnit.FEETTOINCH,1);
        Assert.assertEquals(quantityMeasurement,quantityMeasurement);
    }
    @Test
    public void checkForObject_WhenClassTypeNotEqual_ShouldReturnFalse() {
        quantityMeasurement.getMeasurement(Measurement.ConversionUnit.FEETTOINCH,1);
        Assert.assertNotEquals(quantityMeasurement,new Measurement(Measurement.ConversionUnit.INCHTOFEET));
    }
    @Test
    public void checkForObjectValue_WhenEqual_ShouldReturnTrue() {
        quantityMeasurement.getMeasurement(Measurement.ConversionUnit.FEETTOINCH,1);
        QuantityMeasurement quantityMeasurement1=new QuantityMeasurement();
        quantityMeasurement1.getMeasurement(Measurement.ConversionUnit.FEETTOINCH,1);
        Assert.assertEquals(quantityMeasurement,quantityMeasurement1);
    }
    @Test
    public void checkForObjectValue_WhenNotEqual_ShouldReturnFalse() {
        quantityMeasurement.getMeasurement(Measurement.ConversionUnit.FEETTOINCH,1);
        QuantityMeasurement quantityMeasurement1=new QuantityMeasurement();
        quantityMeasurement1.getMeasurement(Measurement.ConversionUnit.FEETTOINCH,2);
        Assert.assertNotEquals(quantityMeasurement,quantityMeasurement1);
    }
    @Test
    public void givenLengthInInch_WhenProper_ShouldReturnFeet() {
        Assert.assertEquals(1.008, quantityMeasurement.getMeasurement
                            (Measurement.ConversionUnit.INCHTOFEET,12),0.0);
    }
    @Test
    public void givenLengthInInch_WhenZero_ShouldReturnFeet() {
        Assert.assertEquals(0.0, quantityMeasurement.getMeasurement
                            (Measurement.ConversionUnit.INCHTOFEET,0),0.0);
    }
    @Test
    public void givenLengthInInch_WhenImproper_ShouldReturnFeet() {
        Assert.assertEquals(0.0, quantityMeasurement.getMeasurement
                            (Measurement.ConversionUnit.INCHTOFEET,-1),0.0);
    }
    @Test
    public void givenZeroFeetZeroInch_WhenEqual_ShouldReturnTrue() {
        Assert.assertTrue(quantityMeasurement.checkEquality(Measurement.Unit.FEET,0,
                            Measurement.Unit.INCH,0));
    }



}
