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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author aladelia
 */
public class Costumer {

    private JSONObject costumerObject = new JSONObject();
    private JSONArray costumerList = new JSONArray();

    private ArrayList<Costumer> cList = new ArrayList<>();

    private String name;
    private String surname;
    private int age;
    private String address;
    private String city;
    private String telephone;
    private String fiscalcode;

    public Costumer() {

    }

    public Costumer(String name, String surname, int age, String address, String city, String telephone, String fiscalcode) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.fiscalcode = fiscalcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFiscalcode() {
        return fiscalcode;
    }

    public void setFiscalcode(String fiscalcode) {
        this.fiscalcode = fiscalcode;
    }

    public ArrayList<Costumer> getcList() {
        return cList;
    }

    //Esempio scrittura file json
    public void WriteJSON(Costumer costumer) {

        JSONObject costumerDetails = new JSONObject();

        costumerDetails.put("name", costumer.name);
        costumerDetails.put("surname", costumer.surname);
        costumerDetails.put("age", costumer.age);
        costumerDetails.put("address", costumer.address);
        costumerDetails.put("city", costumer.city);
        costumerDetails.put("telephone", costumer.telephone);
        costumerDetails.put("fiscalcode", costumer.fiscalcode);

        costumerObject.put("costumer", costumerDetails);

        //Add dog to list
        costumerList.add(costumerObject);

        //Write JSON file
        try (FileWriter file = new FileWriter("costumers.json")) {

            file.write(costumerList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Json file reader method
    public void ReadJson() {

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("costumers.json")) {

            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray costumersList = (JSONArray) obj;

            //Iterate over dog array
            costumersList.forEach(costumer -> parseCostumerObject((JSONObject) costumer));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //Parser from json to Employee object
    private void parseCostumerObject(JSONObject costumer) {

        System.out.println(costumer);

        //Get employee object within list
        JSONObject costumerObject = (JSONObject) costumer.get("costumer");

        //Get employee username
        String name = (String) costumerObject.get("name");
        System.out.println(name);

        String surname = (String) costumerObject.get("surname");
        System.out.println(surname);

        String telephone = (String) costumerObject.get("telephone");
        System.out.println(age);

        String city = (String) costumerObject.get("city");
        System.out.println(city);

        int age = Integer.parseInt(costumerObject.get("age").toString());
        System.out.println(age);

        String fiscalcode = (String) costumerObject.get("fiscalcode");
        System.out.println(fiscalcode);

        String address = (String) costumerObject.get("address");
        System.out.println(address);
        Costumer c = new Costumer(name, surname, age, address, city, telephone, fiscalcode);
        this.cList.add(c);

        costumerList.add((JSONObject) costumer);

        //System.out.println(dogList);
    }

}
