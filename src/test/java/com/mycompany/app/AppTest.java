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
	ArrayList<Float> source = new ArrayList<>();
	source.add(1.0f);
	source.add(5.0f);
	source.add(8.0f);
	ArrayList<Float> destination = new ArrayList<>();
	destination.add(3.0f);
	destination.add(12.0f);
	destination.add(14.0f);
	float[] result = new App().MuLerp(source, destination, 0.5f);
	assertTrue(result[0]==2.0f && result[1]==8.5f && result[2]==11.0f);
    }

    public void testReverse(){
	ArrayList<Float> source = new ArrayList<>();
	source.add(11.5f);
	source.add(0.0f);
	ArrayList<Float> destination = new ArrayList<>();
	destination.add(3.5f);
	destination.add(-2.8f);
	float[] result = new App().MuLerp(source, destination, 0.5f);
	assertTrue(result[0]==7.5f && result[1]== -1.4f);
    }

    public void testOutOfBounds(){
	ArrayList<Float> source = new ArrayList<>();
	source.add(22.0f);
	source.add(8.0f);
	ArrayList<Float> destination = new ArrayList<>();
	destination.add(30.0f);
	destination.add(-12.0f);
	float[] result = new App().MuLerp(source, destination, 1.25f);
	assertTrue(result[0]==32.0f && result[1]== -17.0f);
    }

    public void testCombined(){
	ArrayList<Float> source = new ArrayList<>();
	source.add(1.0f);
	source.add(54.0f);
	source.add(-9.0f);
	ArrayList<Float> destination = new ArrayList<>();
	destination.add(1.0f);
	destination.add(54.8f);
	destination.add(-5.0f);
	float[] result = new App().MuLerp(source, destination, 0.25f);
	assertTrue(result[0]==1.0f && result[1]==54.2f && result[2]== -8.0f);
    }

    public void testExceptions(){
	ArrayList<Float> source = new ArrayList<>();
	source.add(1.0f);
	source.add(5.0f);
	source.add(8.0f);
	source.add(12.25f);
	source.add(-17.85f);
	ArrayList<Float> destination = new ArrayList<>();
	destination.add(3.0f);
	destination.add(12.0f);
	destination.add(14.0f);
	float[] result = new App().MuLerp(source, destination, 2.2f);
	assertFalse(result != null);
    }

}
