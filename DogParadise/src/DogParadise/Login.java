/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DogParadise;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

/**
 *
 * @author aladelia
 */
public class Login {

    private Employee employee = new Employee();
    private int index = 0;

    private HashMap<Integer, Employee> employeeMapList = new HashMap<>();

    public Login() {

    }

    public Login(Employee employee) {
        this.employee = employee;

    }

    public int checkLogin() {
        String username = employee.getUser();
        String password = employee.getPassword();
        this.ReadJson();

        int i;

        for (i = 0; i < this.employeeMapList.size(); i++) {

            
            if (username.equals(this.employeeMapList.get(i).getUser()) && password.equals(this.employeeMapList.get(i).getPassword())) {

                //prendere valore type dalla mappa
                switch (this.employeeMapList.get(i).getTypeemployee()) {
                    case "admin":
                        return 0;

                    case "vet":
                        return 1;
                }
            } else {
                System.out.println("Error!");
            }
        }
        return -1;
    }

    //Esempio scrittura file json
    public void WriteJSON() {
        //First Employee
        JSONObject employeeDetails = new JSONObject();
        employeeDetails.put("firstName", "Lokesh");
        employeeDetails.put("lastName", "Gupta");
        employeeDetails.put("website", "howtodoinjava.com");

        JSONObject employeeObject = new JSONObject();
        employeeObject.put("employee", employeeDetails);

        //Second Employee
        JSONObject employeeDetails2 = new JSONObject();
        employeeDetails2.put("firstName", "Brian");
        employeeDetails2.put("lastName", "Schultz");
        employeeDetails2.put("website", "example.com");

        JSONObject employeeObject2 = new JSONObject();
        employeeObject2.put("employee", employeeDetails2);

        //Add employees to list
        JSONArray employeeList = new JSONArray();
        employeeList.add(employeeObject);
        employeeList.add(employeeObject2);

        //Write JSON file
        try (FileWriter file = new FileWriter("employees.json")) {

            file.write(employeeList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Json file reader method
    public void ReadJson() {
        int i = 0;
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("employees.json")) {
            i++;
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray employeeList = (JSONArray) obj;

            //Iterate over employee array
            employeeList.forEach(emp -> parseEmployeeObject((JSONObject) emp));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //Parser from json to Employee object
    private void parseEmployeeObject(JSONObject employee) {

        //Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("employee");
        System.out.println(employeeObject.size());

        //Get employee username
        String username = (String) employeeObject.get("username");
        System.out.println(username);

        String password = (String) employeeObject.get("password");
        System.out.println(password);

        String typeemployee = (String) employeeObject.get("typeemployee");
        System.out.println(typeemployee);

        Employee emp = new Employee(username, password, typeemployee);

        this.employeeMapList.put(index, emp);
        index++;
        System.out.println(this.employeeMapList);
    }

}
