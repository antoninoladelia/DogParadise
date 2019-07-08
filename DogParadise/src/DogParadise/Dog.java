/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DogParadise;

import java.util.ArrayList;

/**
 *
 * @author aladelia
 */
public class Dog {


    private String name;
    private String race;
    private String color;
    private Boolean domestic = null;
    private int Age;
    private String Gender;
    private String size;
    private ArrayList<MedicalRecords> medicalrecords = new ArrayList<>();
    private Boolean quarantine = false;
    private Costumer releaser = null;

    public Dog() {

    }

    public Dog(String name, String race, String color,Boolean domestic, int Age, String Gender, String size ,Costumer releaser) {

        this.name = name;
        this.race = race;
        this.color = color;
        this.domestic= domestic;
        this.Age = Age;
        this.Gender = Gender;
        this.size = size;
        this.medicalrecords = null;
        this.quarantine = false;
        this.releaser = releaser;
    }

    public Costumer getReleaser() {
        return releaser;
    }

    public void setReleaser(Costumer releaser) {
        this.releaser = releaser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getDomestic() {
        return domestic;
    }

    public void setDomestic(Boolean domestic) {
        this.domestic = domestic;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public ArrayList<MedicalRecords> getMedicalrecords() {
        return medicalrecords;
    }

    public void setMedicalrecords(ArrayList<MedicalRecords> medicalrecords) {
        this.medicalrecords = medicalrecords;
    }

    public Boolean getQuarantine() {
        return quarantine;
    }

    public void setQuarantine(Boolean quarantine) {
        this.quarantine = quarantine;
    }
   

}
