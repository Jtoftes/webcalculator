package com.acabra.calculator.integral;

import com.acabra.calculator.util.WebCalculatorConstants;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Agustin on 9/29/2016.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({IntegralSubRangeProvider.class})
@PowerMockIgnore(value = {"javax.management.*"})
public class IntegralSubRangeProviderTest {

    @Before
    public void setup() {

    }

    @Test
    public void provideIntegralsOnSubRanges1Test() {
        double lowerBound1 = -10;
        double upperBound1 = -0.0;
        double[] expectedLowerRanges = {lowerBound1, -8.0, -6.0, -4.0, -2.0};
        double[] expectedUpperRanges = {-8.0, -6.0, -4.0, -2.0, upperBound1};
        int repeatedCalculations1 = 5;
        IntegralSubRangeProvider integralSubRangeProvider = new IntegralSubRangeProvider(lowerBound1, upperBound1, repeatedCalculations1, IntegralFunctionType.EXPONENTIAL);
        int i = 0;
        for(i=0;integralSubRangeProvider.hasMoreSubRanges(); i++) {
            IntegrableFunction integrableFunction = integralSubRangeProvider.provideNextIntegral();
            assertEquals(expectedLowerRanges[i], integrableFunction.getLowerBound(), WebCalculatorConstants.ACCURACY_EPSILON);
            assertEquals(expectedUpperRanges[i], integrableFunction.getUpperBound(), WebCalculatorConstants.ACCURACY_EPSILON);
        }
        assertEquals(i, repeatedCalculations1);
    }

    @Test
    public void provideIntegralsOnSubRanges2Test() {
        double lowerBound1 = -10;
        double upperBound1 = -0.0;
        int repeatedCalculations1 = 1;
        IntegralSubRangeProvider integralSubRangeProvider = new IntegralSubRangeProvider(lowerBound1, upperBound1, repeatedCalculations1, IntegralFunctionType.EXPONENTIAL);
        int i = 0;
        for(i=0;integralSubRangeProvider.hasMoreSubRanges(); i++) {
            IntegrableFunction currentIntegral = integralSubRangeProvider.provideNextIntegral();
            assertEquals(lowerBound1, currentIntegral.getLowerBound(), WebCalculatorConstants.ACCURACY_EPSILON);
            assertEquals(upperBound1, currentIntegral.getUpperBound(), WebCalculatorConstants.ACCURACY_EPSILON);
        }
        assertEquals(i, repeatedCalculations1);
    }

    @Test
    public void provideIntegralsOnSubRanges3Test() {
        double lowerBound1 = -0.2;
        double upperBound1 = 0.2;
        double[] expectedLowerRanges = {lowerBound1, 0.0};
        double[] expectedUpperRanges = {0.0, upperBound1};
        int repeatedCalculations1 = 2;
        IntegralSubRangeProvider integralSubRangeProvider = new IntegralSubRangeProvider(lowerBound1, upperBound1, repeatedCalculations1, IntegralFunctionType.EXPONENTIAL);
        int i = 0;
        for(i=0;integralSubRangeProvider.hasMoreSubRanges(); i++) {
            IntegrableFunction currentIntegral = integralSubRangeProvider.provideNextIntegral();
            assertEquals(expectedLowerRanges[i], currentIntegral.getLowerBound(), WebCalculatorConstants.ACCURACY_EPSILON);
            assertEquals(expectedUpperRanges[i], currentIntegral.getUpperBound(), WebCalculatorConstants.ACCURACY_EPSILON);
        }
        assertEquals(i, repeatedCalculations1);
    }

}
