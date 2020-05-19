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
    @Test
    public void checkForInchObject_WhenNull_ShouldReturnFalse() {
        QuantityMeasurement quantityMeasurement1=null;
        Assert.assertNotEquals(quantityMeasurement1,quantityMeasurement);
    }
    @Test
    public void checkForInchObject_WhenReferenceEqual_ShouldReturnTrue() {
        quantityMeasurement.getMeasurement(Measurement.ConversionUnit.INCHTOFEET,1);
        Assert.assertEquals(quantityMeasurement,quantityMeasurement);
    }
    @Test
    public void checkForInchObject_WhenClassTypeNotEqual_ShouldReturnFalse() {
        quantityMeasurement.getMeasurement(Measurement.ConversionUnit.INCHTOFEET,1);
        Assert.assertNotEquals(quantityMeasurement,new Measurement(Measurement.ConversionUnit.FEETTOINCH));
    }
    @Test
    public void checkForInchObjectValue_WhenEqual_ShouldReturnTrue() {
        quantityMeasurement.getMeasurement(Measurement.ConversionUnit.INCHTOFEET,1);
        QuantityMeasurement quantityMeasurement1=new QuantityMeasurement();
        quantityMeasurement1.getMeasurement(Measurement.ConversionUnit.INCHTOFEET,1);
        Assert.assertEquals(quantityMeasurement,quantityMeasurement1);
    }
    @Test
    public void checkForInchObjectValue_WhenNotEqual_ShouldReturnFalse() {
        quantityMeasurement.getMeasurement(Measurement.ConversionUnit.INCHTOFEET,1);
        QuantityMeasurement quantityMeasurement1=new QuantityMeasurement();
        quantityMeasurement1.getMeasurement(Measurement.ConversionUnit.INCHTOFEET,2);
        Assert.assertNotEquals(quantityMeasurement,quantityMeasurement1);
    }
    @Test
    public void givenOneFeetOneInch_WhenNotEqual_ShouldReturnFalse() {
        Assert.assertFalse(quantityMeasurement.checkEquality
                          (Measurement.Unit.FEET,1, Measurement.Unit.INCH,1));
    }
    @Test
    public void givenOneInchOneFeet_WhenNotEqual_ShouldReturnFalse() {
        Assert.assertFalse(quantityMeasurement.checkEquality
                          (Measurement.Unit.INCH,1,Measurement.Unit.FEET,1));
    }
    @Test
    public void givenOneFeet12Inch_WhenEqual_ShouldReturnTrue() {
        Assert.assertTrue(quantityMeasurement.checkEquality
                         (Measurement.Unit.FEET, 1, Measurement.Unit.INCH,12));
    }
    @Test
    public void given12InchOneFeet_WhenEqual_ShouldReturnTrue() {
        Assert.assertTrue(quantityMeasurement.checkEquality
                         (Measurement.Unit.INCH,12,Measurement.Unit.FEET,1));
    }
    @Test
    public void givenLengthInFeet_WhenProper_ShouldReturnYard() {
        Assert.assertEquals(1.002, quantityMeasurement.getMeasurement
                           (Measurement.ConversionUnit.FEETTOYARD,3),0.0);
    }
    @Test
    public void givenLengthInFeet_WhenZero_ShouldReturnYard() {
        Assert.assertEquals(0.0, quantityMeasurement.getMeasurement
                (Measurement.ConversionUnit.FEETTOYARD, 0), 0.0);
    }
    @Test
    public void givenLengthInFeet_WhenImproper_ShouldReturnYard() {
        Assert.assertEquals(0.0, quantityMeasurement.getMeasurement
                           (Measurement.ConversionUnit.FEETTOYARD,-1),0.0);
    }
    @Test
    public void givenLengthInYard_WhenProper_ShouldReturnFeet() {
        Assert.assertEquals(3, quantityMeasurement.getMeasurement
                           (Measurement.ConversionUnit.YARDTOFEET,1),0.0);
    }
    @Test
    public void givenZeroFeetZeroYard_WhenEqual_ShouldReturnTrue() {
        Assert.assertTrue(quantityMeasurement.checkEquality
                         (Measurement.Unit.FEET,0, Measurement.Unit.YARD,0));
    }
    @Test
    public void givenThreeFeetOneYard_WhenEqual_ShouldReturnTrue() {
        Assert.assertTrue(quantityMeasurement.checkEquality
                         (Measurement.Unit.FEET,3, Measurement.Unit.YARD,1));
    }
    @Test
    public void givenOneFeetOneYard_WhenNotEqual_ShouldReturnFalse() {
        Assert.assertFalse(quantityMeasurement.checkEquality
                          (Measurement.Unit.FEET,1, Measurement.Unit.YARD,1));
    }
    @Test
    public void givenOneYard36Inch_WhenEqual_ShouldReturnTrue() {
        Assert.assertTrue(quantityMeasurement.checkEquality
                        (Measurement.Unit.YARD,1,Measurement.Unit.INCH,36));
    }
    @Test
    public void given36InchOneYard_WhenEqual_ShouldReturnTrue() {
        Assert.assertTrue(quantityMeasurement.checkEquality
                         (Measurement.Unit.INCH,36,Measurement.Unit.YARD,1));
    }
    @Test
    public void givenOneYardThreeFeet_WhenEqual_ShouldReturnTrue() {
        Assert.assertTrue(quantityMeasurement.checkEquality
                         (Measurement.Unit.YARD,1,Measurement.Unit.FEET,3));
    }
    @Test
    public void givenTwoInch5Cm_WhenEqual_ShouldReturnEqual() {
        Assert.assertTrue(quantityMeasurement.checkEquality
                         (Measurement.Unit.INCH,2,Measurement.Unit.CENTIMETER,5));
    }
    @Test
    public void given5CentimeterTwoInch_WhenEqual_ShouldReturnTrue() {
        Assert.assertTrue(quantityMeasurement.checkEquality
                         (Measurement.Unit.CENTIMETER,5,Measurement.Unit.INCH,2));
    }
    @Test
    public void givenTwoValue_WhenAdded_ShouldReturnResult() {
        Assert.assertEquals(2.0,quantityMeasurement.performAddition
                           (Measurement.Unit.INCH,0,Measurement.Unit.INCH, 2,Measurement.Unit.INCH)
                            ,0.0);
    }
    @Test
    public void givenTwoLengthInInch_WhenAdded_ShouldReturnResult() {
        Assert.assertEquals(4.0,quantityMeasurement.performAddition
                           (Measurement.Unit.INCH,2,Measurement.Unit.INCH,2,Measurement.Unit.INCH)
                            ,0.0);
    }
    @Test
    public void givenOneFeetTwoInch_WhenAdded_ShouldReturnResult() {
        Assert.assertEquals(14.0,quantityMeasurement.performAddition
                            (Measurement.Unit.FEET,1,Measurement.Unit.INCH,2,Measurement.Unit.INCH)
                            ,0.0);
    }
    @Test
    public void givenOneFeetOneFeet_WhenAdded_ShouldReturnResult() {
        Assert.assertEquals(24.0,quantityMeasurement.performAddition
                           (Measurement.Unit.FEET,1,Measurement.Unit.FEET,1,Measurement.Unit.INCH)
                            ,0.0);
    }
    @Test
    public void givenTwoInchTwoAndHalfCm_WhenAdded_ShouldReturnResult() {
        Assert.assertEquals(3.0,quantityMeasurement.performAddition
                           (Measurement.Unit.INCH,2,Measurement.Unit.CENTIMETER,2.5,Measurement.Unit.INCH)
                           ,0.0);
    }
    @Test
    public void givenGallonAndLiter_WhenEqual_ShouldReturnTrue() {
        Assert.assertTrue(quantityMeasurement.checkEquality
                (Measurement.Unit.GALLON,1,Measurement.Unit.LITER,3.78));
    }
    @Test
    public void givenLiterAndMiliLiter_WhenEqual_ShouldReturnTrue() {
        Assert.assertTrue(quantityMeasurement.checkEquality
                         (Measurement.Unit.LITER,1,Measurement.Unit.MILILITER,1000));
    }



}
