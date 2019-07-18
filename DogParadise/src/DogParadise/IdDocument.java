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
public class IdDocument {
    private String type;
    private String nDocument;
    private String dateExpiry;

    public IdDocument() {
    }
    
    

    public IdDocument(String type, String nDocument, String dateExpiry) {
        this.type = type;
        this.nDocument = nDocument;
        this.dateExpiry = dateExpiry;
    }

    public String getDateExpiry() {
        return dateExpiry;
    }

    public void setDateExpiry(String dateExpiry) {
        this.dateExpiry = dateExpiry;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getnDocument() {
        return nDocument;
    }

    public void setnDocument(String nDocument) {
        this.nDocument = nDocument;
    }
}
