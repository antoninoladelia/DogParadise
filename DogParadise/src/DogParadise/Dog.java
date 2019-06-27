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
public class Dog extends JsonTools {


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

    @Override
    public void ReadJson() {
        super.ReadJson(); //To change body of generated methods, choose Tools | Templates.
        
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("dogs.json")) {

            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray dogsList = (JSONArray) obj;

            //Iterate over dog array
            dogsList.forEach(dog -> parseObject((JSONObject) dog));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("polydog");
    }

    
    public void WriteJSON(Dog dog) {
        super.WriteJSON(dog); //To change body of generated methods, choose Tools | Templates.
    }

    

}
