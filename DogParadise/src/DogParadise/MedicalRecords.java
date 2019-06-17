/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DogParadise;

import java.util.Date;

/**
 *
 * @author aladelia
 */
public class MedicalRecords {
    private int id;
    private Date creationdate;

    public MedicalRecords(int id, Date creationdate) {
        this.id = id;
        this.creationdate = creationdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }
    
    
}
