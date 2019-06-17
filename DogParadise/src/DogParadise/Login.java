/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DogParadise;

import java.util.HashMap;

/**
 *
 * @author aladelia
 */
public class Login {

    private Employee employee = new Employee();

    private HashMap<Integer, Employee> employeeMapList = new HashMap<Integer, Employee>();

    public Login() {
    }

    public Login(Employee employee) {
        this.employee = employee;
    }

    public int checkLogin() {
        String username = employee.getUser();
        String password = employee.getPassword();
        
        int i;

        for (i = 0; i < this.employeeMapList.size(); i++) {
            
            if (username == this.employeeMapList.get(i).getUser() && password == this.employeeMapList.get(i).getPassword()) {
            
            //prendere valore type dalla mappa
                switch (this.employeeMapList.get(i).getTypeemployee()) {
                    case "admin":
                        return 0;
                       
                    case "vet":
                        return 1;
                }
            } else {
                System.out.println("error");
            }
        }
        return -1;
    }

}
