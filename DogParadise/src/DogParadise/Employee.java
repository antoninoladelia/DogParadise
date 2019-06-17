/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DogParadise;

/**
 *
 * @author aladelia
 */
public class Employee {

    private String user;
    private String password;
    private String typeemployee;
    String provagit;

    public Employee(String user, String password, String typeemployee) {
        this.user = user;
        this.password = password;
        this.typeemployee = typeemployee;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeemployee() {
        return typeemployee;
    }

    public void setTypeemployee(String typeemployee) {
        this.typeemployee = typeemployee;
    }

}
