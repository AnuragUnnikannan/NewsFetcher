package com.example.demo;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class NewsFetcher {
    public JSONObject fetcher(String target)throws Exception
    {
        URL url = new URL(target);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

//Getting the response code
        int responsecode = conn.getResponseCode();

        if (responsecode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responsecode);
        }
        else
        {
            String inline = "";
            Scanner scanner = new Scanner(url.openStream());

            //Write all the JSON data into a string using a scanner
            while (scanner.hasNext())
            {
                inline += scanner.nextLine();
            }

            //Close the scanner
            scanner.close();

//            JSONParser parser = new JSONParser();
//            Object obj  = parser.parse(inline);

            //Using the JSON simple library parse the string into a json object
            JSONParser parse = new JSONParser();
            JSONObject data_obj = (JSONObject) parse.parse(inline);
//            System.out.println(data_obj.get("totalResults"));
////            //Get the required object from the above created object
//            JSONObject obj = (JSONObject) data_obj.get("articles");
//
//            //Get the required data using its key
//            System.out.println(obj.get("TotalRecovered"));
            return data_obj;

        }
    }
}
