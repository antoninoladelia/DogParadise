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
import java.util.ArrayList;
import java.util.HashMap;
import org.bson.Document;

/**
 *
 * @author aladelia
 */
public class Login extends JsonTools{

    private Employee employee = new Employee();

    private ArrayList<Employee> employeeList = new ArrayList<>();
    
    private static Login singleton=null;

    private  Login() {}
    
    public static Login getIstance() {
                if(singleton==null)
                        singleton = new Login();
                return singleton;
        }


    public int checkLogin(Employee employee, Document doc) {
        
        String username = employee.getUser();
        String password = employee.getPassword();
        this.ReadJson();
        
        System.out.println("login "+super.geteList());

        int i;
        /*int nEmployee = super.geteList().size();

        for (i = 0; i <  nEmployee ; i++) {

            
            if (username.equals(super.geteList().get(i).getUser()) && password.equals(super.geteList().get(i).getPassword())) {

                //prendere valore type dalla mappa
                switch (super.geteList().get(i).getTypeemployee()) {
                    case "admin":
                        return 0;

                    case "vet":
                        return 1;
                }
            } else {
                System.out.println("User and password doesn't match!");
            }
        }
         System.out.println("Error!");
        return -1;*/
        
        
        if(doc.getString("username").equals(username) && doc.getString("password").equals(password)){
            switch (doc.getString("typeemployee")) {
                    case "admin":
                        return 0;

                    case "vet":
                        return 1;
                }
        }else {
                System.out.println("User and password doesn't match!");
            }
        return -1;
        
    }


   
    

    //Json file reader method
    @Override
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
            employeeList.forEach(emp -> parseObject((JSONObject) emp));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

   

}
