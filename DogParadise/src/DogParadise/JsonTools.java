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
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author aladelia
 */
public class JsonTools {

    private JSONObject dogObject = new JSONObject();
    private JSONArray dogList = new JSONArray();
    private JSONArray medicalList = new JSONArray();
    private JSONObject costumerObject = new JSONObject();
    private JSONArray costumerList = new JSONArray();
    private ArrayList<Costumer> cList = new ArrayList<>();
    private ArrayList<Employee> eList = new ArrayList<>();
    private ArrayList<Dog> dList = new ArrayList<>();
    private ArrayList<MedicalRecords> mrList = new ArrayList<>();

    public JsonTools() {
    }

    public void WriteJSON() {

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

        //Add dog to list
        dogList.add(dogObject);

        this.dList.add(dog);

        //Write JSON file
        try (FileWriter file = new FileWriter("dogs.json")) {

            file.write(dogList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //modifica file json
    public void WriteJSON(Dog dog, int index) {

        JSONObject dogDetails = new JSONObject();
        

        dogDetails.put("name", dog.getName());
        dogDetails.put("race", dog.getRace());
        dogDetails.put("color", dog.getColor());
        dogDetails.put("domestic", dog.getDomestic());
        dogDetails.put("age", dog.getAge());
        dogDetails.put("gender", dog.getGender());
        dogDetails.put("size", dog.getSize());
        dogDetails.put("quarantine", "No");
        for(int d=0; d<dog.getMrList().size();d++)
        System.out.println(dog.getMrList().get(d).getId());
        
        
        /*if(dList.get(index).getMrList() != null){
            
            for (int i = 0; i < dList.get(index).getMrList().size(); i++){
                
                JSONObject medicalDetails = new JSONObject();
                medicalDetails.put("medical record id", dList.get(index).getMrList().get(i).getId());
                medicalDetails.put("date", dList.get(index).getMrList().get(i).getCreationdate());
                medicalList.add(medicalDetails);
            }
            
            
            
        }*/
        
        for (int i = 0; i < dog.getMrList().size(); i++) {
            JSONObject medicalDetails1 = new JSONObject();
            medicalDetails1.put("medical record id", dog.getMrList().get(i).getId());
            medicalDetails1.put("date", dog.getMrList().get(i).getCreationdate());
            medicalList.add(medicalDetails1);
            
      
        }
        
        dogDetails.put("medicalRecords", medicalList);
            

        System.out.println(dogDetails.get("medicalRecords"));

        dogObject.put("dog", dogDetails);
        System.out.println(dogObject.get("dog"));
        System.out.println(dogList.size());

        //Add dog to list
        dogList.set(index, dogObject);
        System.out.println("salvezza3");

        this.dList.set(index, dog);
        System.out.println("salvezza4");

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
        System.out.println("Read Json Method in the Mother Class");
    }

    //Parser from json to Employee object
    public void parseObject(JSONObject o) {

        System.out.println(o);

        if (o.containsKey("dog")) {
            
                ArrayList<MedicalRecords> tempmrList = new ArrayList<>();
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

                Boolean domestic = Boolean.parseBoolean(dogObject.get("domestic").toString());

                //Boolean quarantine = Boolean.parseBoolean(dogObject.get("quarantine").toString()) ;
                int age = Integer.parseInt(dogObject.get("age").toString());
                System.out.println(age);

                String gender = (String) dogObject.get("gender");
                System.out.println(gender);

                JSONArray medicalObject = (JSONArray) dogObject.get("medicalRecords");
                
                
                
                
                if(dogObject.get("medicalRecords")!= null) {
                    for (int i = 0; i < medicalObject.size(); i++) {
                        MedicalRecords medicalrecords = new MedicalRecords();
                        JSONObject obj = (JSONObject) medicalObject.get(i);
                        int id = Integer.parseInt(obj.get("medical record id").toString());
                        String date = (String) obj.get("date");
                        medicalrecords.setId(id);
                        medicalrecords.setCreationdate(date);
                        tempmrList.add(medicalrecords);
                        
                    }
                    
                    Dog d = new Dog(name, race, color, domestic, age, gender, size, tempmrList);
                    this.dList.add(d);
                
                }else{
                    Dog d = new Dog(name, race, color, domestic, age, gender, size);
                    this.dList.add(d);
                }
                
                
                


                dogList.add((JSONObject) o);

                
            

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
            Costumer c = new Costumer(name, surname, age, address, city, telephone, fiscalcode);
            this.cList.add(c);

            costumerList.add((JSONObject) o);
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

    public ArrayList<Dog> getdList() {
        return dList;
    }

}
