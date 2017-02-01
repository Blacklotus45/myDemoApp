package com.mycompany.app;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.*;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

/**
 * Hello world!
 *
 */
public class App 
{
     public static float[] MuLerp(ArrayList<Float> source, ArrayList<Float> destination, float lerp){

	int size = source.size();	
	if(size == 0) return null;
	if(size != destination.size()) return null;

	float[] interpolate = new float[size];

	for(int i=0; i<size; i++){

		float diff = destination.get(i) - source.get(i); 
		diff *= lerp;

		interpolate[i] = source.get(i) + diff;
	}

	return interpolate;
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Multiple Linear Interpolution");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Float> sourceList = new java.util.ArrayList<Float>();
          while (sc1.hasNext())
          {
            float value = Float.parseFloat(sc1.next().replaceAll("\\s",""));
            sourceList.add(value);
          }
          //System.out.println(inputList);

	  String input2 = req.queryParams("input2");
          java.util.Scanner sc2 = new java.util.Scanner(input2);
          sc2.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Float> destinationList = new java.util.ArrayList<Float>();
          while (sc2.hasNext())
          {
            float value = Float.parseFloat(sc2.next().replaceAll("\\s",""));
            destinationList.add(value);
          }
          //System.out.println(inputList);

          String input3 = req.queryParams("input3").replaceAll("\\s","");
          float input3AsFloat = Float.parseFloat(input3);

          float[] result = App.MuLerp(sourceList, destinationList, input3AsFloat);

         Map map = new HashMap();
          map.put("result", Arrays.toString(result));
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
	    int port = Integer.parseInt(processBuilder.environment().get("PORT"));
	    System.out.println(port);
            return port;
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static boolean search(ArrayList<Integer> array, int e) {
        System.out.println("inside search");
        if (array == null) return false;
  
        for (int elt : array) {
          if (elt == e) return true;
        }
        return false;
    }
}
