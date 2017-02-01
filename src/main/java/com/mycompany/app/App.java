package com.mycompany.app;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public static float[] MuLerp(float[] source, float[] destination, float lerp){

	int length = source.length;	
	if(length != destination.length) return null;
	if(length == 0) return null;

	float[] interpolate = new float[length];

	for(int i=0; i<length; i++){

		float diff = destination[i] - source[i]; 
		diff *= lerp;

		interpolate[i] = source[i] + diff;
	}

	return interpolate;
    }

    /*public static boolean search(ArrayList<Integer> array, int e){
	System.out.println( "Inside search" );
	if(array == null) return false;

	for(int elt: array){
	   if(elt == e) return true;
	}
	return false;
    }*/
}
