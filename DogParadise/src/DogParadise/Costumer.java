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
public class Costumer {

    private String name;
    private String surname;
    private int age;
    private String address;
    private String city;
    private String telephone;
    private String fiscalcode;

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

}
