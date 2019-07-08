/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DogParadise;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
    private String dateOfBirth;
    private String cityOfBirth;
    private String cityOfResidence;
    private String address;
    private String telephone;
    private String fiscalCode;
    private String province;
    private IdDocument document;

    public Costumer(String name, String surname, String dateOfBirth, String cityOfBirth, String cityOfResidence, String address, String telephone, String fiscalCode, String province, IdDocument document) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.cityOfBirth = cityOfBirth;
        this.cityOfResidence = cityOfResidence;
        this.address = address;
        this.telephone = telephone;
        this.fiscalCode = fiscalCode;
        this.province = province;
        this.document = document;
    }

    public JSONObject getCostumerObject() {
        return costumerObject;
    }

    public void setCostumerObject(JSONObject costumerObject) {
        this.costumerObject = costumerObject;
    }

    public JSONArray getCostumerList() {
        return costumerList;
    }

    public void setCostumerList(JSONArray costumerList) {
        this.costumerList = costumerList;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCityOfBirth() {
        return cityOfBirth;
    }

    public void setCityOfBirth(String cityOfBirth) {
        this.cityOfBirth = cityOfBirth;
    }

    public String getCityOfResidence() {
        return cityOfResidence;
    }

    public void setCityOfResidence(String cityOfResidence) {
        this.cityOfResidence = cityOfResidence;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public IdDocument getDocument() {
        return document;
    }

    public void setDocument(IdDocument document) {
        this.document = document;
    }
    
    

    public Costumer() {
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


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFiscalcode() {
        return fiscalCode;
    }

    public void setFiscalcode(String fiscalcode) {
        this.fiscalCode = fiscalcode;
    }

    public ArrayList<Costumer> getcList() {
        return cList;
    }

    public Boolean fiscalCodeResearch(String cf) {

        for (int i = 0; i < this.cList.size(); i++) {

            if (cf.equalsIgnoreCase(this.cList.get(i).getFiscalcode())) {
                System.out.println("esiste");
                return true;
            } else {
                System.out.println("no costumer");

            }

        }

        return false;
    }


}
