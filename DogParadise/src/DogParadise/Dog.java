/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DogParadise;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author aladelia
 */
public class Dog {

    private int index = 0;

    private JSONObject dogObject = new JSONObject();
    private JSONArray dogList = new JSONArray();
    
    

    private String name;
    private String race;
    private String color;
    private Boolean domestic = null;
    private int Age;
    private String Gender;
    private String size;
    private ArrayList<MedicalRecords> medicalrecords = new ArrayList<>();
    private Boolean quarantine = false;

    public Dog() {

    }

    public Dog(String name, String race, String color,Boolean domestic, int Age, String Gender, String size) {

        this.name = name;
        this.race = race;
        this.color = color;
        this.domestic= domestic;
        this.Age = Age;
        this.Gender = Gender;
        this.size = size;
        this.medicalrecords = null;
        this.quarantine = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getDomestic() {
        return domestic;
    }

    public void setDomestic(Boolean domestic) {
        this.domestic = domestic;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public ArrayList<MedicalRecords> getMedicalrecords() {
        return medicalrecords;
    }

    public void setMedicalrecords(ArrayList<MedicalRecords> medicalrecords) {
        this.medicalrecords = medicalrecords;
    }

    public Boolean getQuarantine() {
        return quarantine;
    }

    public void setQuarantine(Boolean quarantine) {
        this.quarantine = quarantine;
    }

    //Esempio scrittura file json
    public void WriteJSON(Dog dog) {


            JSONObject dogDetails = new JSONObject();
            
            
            dogDetails.put("name", dog.name);
            dogDetails.put("race", dog.race);
            dogDetails.put("color", dog.color);
            dogDetails.put("domestic", dog.domestic);
            dogDetails.put("age", dog.Age);
            dogDetails.put("gender", dog.Gender);
            dogDetails.put("size", dog.size);
            dogDetails.put("medicalRecords", null);
            dogDetails.put("quarantine", "No");

            dogObject.put("dog", dogDetails);

            //Add dog to list
            dogList.add(dogObject);

            //Write JSON file
            try (FileWriter file = new FileWriter("dogs.json")) {

                file.write(dogList.toJSONString());
                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }

        
    }

    //Json file reader method
    public void ReadJson() {

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("dogs.json")) {

            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray dogsList = (JSONArray) obj;

            //Iterate over dog array
            dogsList.forEach(dog -> parseDogObject((JSONObject) dog));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //Parser from json to Employee object
    private void parseDogObject(JSONObject dog) {
        
        System.out.println(dog);

        //Get employee object within list
        JSONObject dogObject = (JSONObject) dog.get("dog");
        
       
        //Get employee username
        String name = (String) dogObject.get("name");
        System.out.println(name);

        String race = (String) dogObject.get("race");
        System.out.println(race);

        String size = (String) dogObject.get("size");
        System.out.println(size);

        String color = (String) dogObject.get("color");
        System.out.println(color);

        int age = Integer.parseInt(dogObject.get("age").toString());
        System.out.println(age);

        String gender = (String) dogObject.get("gender");
        System.out.println(gender);
        
     
        dogList.add((JSONObject) dog);
        //System.out.println(dogList);
    }

}
