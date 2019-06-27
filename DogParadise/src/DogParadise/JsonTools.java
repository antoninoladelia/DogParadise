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
public class JsonTools {

    //Json objects lists
    private JSONObject dogObject = new JSONObject();
    private JSONArray dogList = new JSONArray();
    private JSONObject costumerObject = new JSONObject();
    private JSONArray costumerList = new JSONArray();

    //java objects lists
    private ArrayList<Costumer> cList = new ArrayList<>();
    private ArrayList<Employee> eList = new ArrayList<>();
    private ArrayList<Dog> dList = new ArrayList<>();

    public JsonTools() {
    }


    //Esempio scrittura file json
    public void WriteJSON(Dog dog) {

        JSONObject dogDetails = new JSONObject();

        dogDetails.put("name", dog.getName());
        dogDetails.put("race", dog.getRace());
        dogDetails.put("color", dog.getColor());
        dogDetails.put("domestic", dog.getDomestic());
        dogDetails.put("age", dog.getAge());
        dogDetails.put("gender", dog.getGender());
        dogDetails.put("size", dog.getSize());
        dogDetails.put("medicalRecords", null);
        dogDetails.put("quarantine", "No");

        dogObject.put("dog", dogDetails);

        //Add dog to Jsonlist
        dogList.add(dogObject);
        
        
        //Add dog to ObjectList
        this.dList.add(dog);

        //Write JSON file
        try (FileWriter file = new FileWriter("dogs.json")) {

            file.write(dogList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Esempio scrittura file json
    public void WriteJSON(Costumer costumer) {

        JSONObject costumerDetails = new JSONObject();

        costumerDetails.put("name", costumer.getName());
        costumerDetails.put("surname", costumer.getSurname());
        costumerDetails.put("age", costumer.getAge());
        costumerDetails.put("address", costumer.getAddress());
        costumerDetails.put("city", costumer.getCity());
        costumerDetails.put("telephone", costumer.getTelephone());
        costumerDetails.put("fiscalcode", costumer.getFiscalcode());

        costumerObject.put("costumer", costumerDetails);

        //Add costumer to list
        costumerList.add(costumerObject);
        
        //add costumer ot the object list
         this.cList.add(costumer);

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
        System.out.println("Read Json Method in the Mother Class");
    }

    //Parser from json to Employee object
    public void parseObject(JSONObject o) {

        System.out.println(o);

        if (o.containsKey("dog")) {
            //Get employee object within list
            JSONObject dogObject = (JSONObject) o.get("dog");

            //Get employee username
            String name = (String) dogObject.get("name");
            System.out.println(name);

            String race = (String) dogObject.get("race");
            System.out.println(race);

            String size = (String) dogObject.get("size");
            System.out.println(size);

            String color = (String) dogObject.get("color");
            System.out.println(color);

            Boolean domestic = (Boolean) dogObject.get("domestic");

            int age = Integer.parseInt(dogObject.get("age").toString());
            System.out.println(age);

            String gender = (String) dogObject.get("gender");
            System.out.println(gender);

            dogList.add((JSONObject) o);

            Dog dog = new Dog(name, race, color, domestic, age, gender, size);
            this.dList.add(dog);

            //System.out.println(dogList);
        } else if (o.containsKey("costumer")) {
            System.out.println(o);

            //Get employee object within list
            JSONObject costumerObject = (JSONObject) o.get("costumer");

            //Get employee username
            String name = (String) costumerObject.get("name");
            System.out.println(name);

            String surname = (String) costumerObject.get("surname");
            System.out.println(surname);

            String telephone = (String) costumerObject.get("telephone");
            System.out.println(telephone);

            String city = (String) costumerObject.get("city");
            System.out.println(city);

            int age = Integer.parseInt(costumerObject.get("age").toString());
            System.out.println(age);

            String fiscalcode = (String) costumerObject.get("fiscalcode");
            System.out.println(fiscalcode);

            String address = (String) costumerObject.get("address");
            System.out.println(address);
            
            costumerList.add((JSONObject) o);
            
            Costumer c = new Costumer(name, surname, age, address, city, telephone, fiscalcode);
            this.cList.add(c);

        } else if (o.containsKey("employee")) {
            //Get employee object within list
            JSONObject employeeObject = (JSONObject) o.get("employee");
            System.out.println(employeeObject.size());

            //Get employee username
            String username = (String) employeeObject.get("username");
            System.out.println(username);

            String password = (String) employeeObject.get("password");
            System.out.println(password);

            String typeemployee = (String) employeeObject.get("typeemployee");
            System.out.println(typeemployee);

            Employee emp = new Employee(username, password, typeemployee);

            this.eList.add(emp);

        }

    }

    public ArrayList<Costumer> getcList() {
        return cList;
    }

    public ArrayList<Employee> geteList() {
        return eList;
    }

}
