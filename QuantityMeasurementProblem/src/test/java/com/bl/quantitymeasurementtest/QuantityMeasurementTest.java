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
        Assert.assertEquals(12.0, quantityMeasurement.getMeasurement(Measurement.Measurements.FEETTOINCH,1),0.0);
    }

    @Test
    public void givenLengthInFeet_WhenZero_ShouldReturnInch() {
        Assert.assertEquals(0.0, quantityMeasurement.getMeasurement(Measurement.Measurements.FEETTOINCH,0),0.0);
    }

    @Test
    public void givenLengthInFeet_WhenImproper_ShouldReturnInch() {
        Assert.assertEquals(0.0, quantityMeasurement.getMeasurement(Measurement.Measurements.FEETTOINCH,-1),0.0);
    }

}
