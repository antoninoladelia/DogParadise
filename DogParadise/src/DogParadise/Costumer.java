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
import DogParadise.JsonTools;
import javax.swing.JOptionPane;

/**
 *
 * @author aladelia
 */
public class Costumer extends JsonTools {

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

    public Boolean fiscalCodeResearch(String cf) {

        for (int i = 0; i <= this.cList.size(); i++) {
            
            if (cf.equalsIgnoreCase(this.cList.get(i).getFiscalcode())) {
                System.out.println("esiste");
                return true;
            } else {
                System.out.println("no costumer");
    
            }
            
        }

        return false;
    }

    @Override
    public void ReadJson() {
        super.ReadJson(); //To change body of generated methods, choose Tools | Templates.

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("costumers.json")) {

            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray costumersList = (JSONArray) obj;

            //Iterate over dog array
            costumersList.forEach(costumer -> parseObject((JSONObject) costumer));

            this.cList = super.getcList();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void WriteJSON(Costumer costumer) {
        super.WriteJSON(costumer); //To change body of generated methods, choose Tools | Templates.
    }

}
