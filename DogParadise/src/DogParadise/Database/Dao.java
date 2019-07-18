/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DogParadise.Database;

import java.util.ArrayList;
import org.bson.Document;
import org.bson.types.ObjectId;


/**
 *
 * @author aladelia
 */
public interface Dao{
    
    public Boolean createCollection(String collectionName);
    public void saveToDB(String collectionName, Document dbObject);
    public boolean checkExistingFieldInDb(String collectionName,String field, String attribute);
    public Document findADocument(String collectionName,String field, String attribute);
    public void updateDB(String collectionName, Document filter, Document dbObject);
    public Document findADocument(String collectionName,String field, ObjectId attribute);
    public ArrayList<Document> getCollection (String collectionName);
    public void initializeEmployeeCollection();
}

