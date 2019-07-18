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
public class Login {

    private Employee employee = new Employee();
    
    private Costumer costumer = new Costumer();

    private static Login singleton = null;

    private Login() {
    }

    public static Login getIstance() {
        if (singleton == null) {
            singleton = new Login();
        }
        return singleton;
    }

    public int checkLoginEmployee(Employee employee, Document doc) {

        this.employee = employee;
        this.employee = employee;
        
        
        String username = this.employee.getUser();
        String password = this.employee.getPassword();

        if (doc.getString("username").equals(username) && doc.getString("password").equals(password)) {
            switch (doc.getString("typeemployee")) {
                case "admin":
                    return 0;

                case "vet":
                    return 1;
            }
        } else {
            System.out.println("User and password doesn't match!");
        }
        return -1;

    }
    
    
    public int checkLoginCostumer(Costumer costumer, Document doc) {

        this.costumer = costumer;
        this.costumer = costumer;
        
        String username = this.costumer.getFiscalCode();
        String password = this.costumer.getPassword();

        if (doc.getString("fiscalCode").equals(username) && doc.getString("password").equals(password)) {
            return 0;
        } else {
            System.out.println("User and password doesn't match!");
        }
        return -1;

    }

}
