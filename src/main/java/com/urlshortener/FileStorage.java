package com.urlshortener;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileStorage {
private static final String FILE = "urls.txt";

// SAVE - write entire HashMap to file
   public static void save (Map<String,String> data){
       try {
           BufferedWriter writer = new BufferedWriter(new FileWriter(FILE));

           for(Map.Entry<String,String>entry : data.entrySet()) {
               writer.write(
                       entry.getKey()+ "," + entry.getValue());
               writer.newLine();
           }
           writer.close();
           System.out.println(" Saved to file.");

       } catch (IOException e) {
           System.out.println("Could not save:"+e.getMessage());
       }

   }

   // LOAD -- read file and return as HashMap
    public static Map<String,String>load(){
       Map<String,String>data = new HashMap<>();

       try{
           BufferedReader reader = new BufferedReader(new FileReader(FILE));

           String line;
           while ((line = reader.readLine()) !=null){
               String[]parts = line.split(",");
               if(parts.length == 2){
                   data.put(parts[0], parts[1]);
               }else{
                   System.out.println("Skipping malformed line: " + line);
               }
           }
          reader.close();
            System.out.println("Loaded"+data.size() +"URL from file.");

       }catch (FileNotFoundException e){
           System.out.println("No saved data found. Starting fresh.");
       }catch (IOException e){
           System.out.println("Could not load:"+e.getMessage());
       }
          return data;
    }

}
