package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{

    public void testGeneric(){
	float[] source = {1.0f,5.0f,8.0f};
	float[] destination = {3.0f,12.0f,14.0f};
	float[] result = new App().MuLerp(source, destination, 0.5f);
	assertTrue(result[0]==2.0f && result[1]==8.5f && result[2]==11.0f);
    }

    public void testReverse(){
	float[] source = {11.5f,0.0f};
	float[] destination = {3.5f,-2.8f};
	float[] result = new App().MuLerp(source, destination, 0.5f);
	assertTrue(result[0]==7.5f && result[1]== -1.4f);
    }

    public void testOutOfBounds(){
	float[] source = {22.0f,8.0f};
	float[] destination = {30.0f,-12.0f};
	float[] result = new App().MuLerp(source, destination, 1.25f);
	assertTrue(result[0]==32.0f && result[1]== -17.0f);
    }

    public void testCombined(){
	float[] source = {1.0f,54.0f,-9.0f};
	float[] destination = {1.0f,54.8f,-5.0f};
	float[] result = new App().MuLerp(source, destination, 0.25f);
	assertTrue(result[0]==1.0f && result[1]==54.2f && result[2]== -8.0f);
    }

    public void testExceptions(){
	float[] source = {1.0f,5.0f,8.0f,12.25f,-17.85f};
	float[] destination = {3.0f,12.0f,14.0f};
	float[] result = new App().MuLerp(source, destination, 2.2f);
	assertFalse(result != null);
    }

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    /*public AppTest( String testName )
    {
        super( testName );
    }*/

    /**
     * @return the suite of tests being tested
     */
    /*public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }*/

    /**
     * Rigourous Test :-)
     */
    /*public void testApp()
    {
        assertTrue( true );
    }*/

    /* public void testFound() {
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
      assertTrue(new App().search(array, 4));
    }

    public void testNotFound() {
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
      assertFalse(new App().search(array, 5));
    }

    public void testEmptyArray() {
      ArrayList<Integer> array = new ArrayList<>();
      assertFalse(new App().search(array, 1));
    }

    public void testNull() {
      assertFalse(new App().search(null, 1));
    }*/



}
