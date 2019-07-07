/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DogParadise.Database;

import org.bson.Document;


/**
 *
 * @author aladelia
 */
public interface Dao{
    
    public Boolean createTable(String collectionName);
    public void saveToDB(String collectionName, Document dbObject);
    public boolean checkExistingFieldInDb(String collectionName,String field, String attribute);
    public Document findADocument(String collectionName,String field, String attribute);
}

