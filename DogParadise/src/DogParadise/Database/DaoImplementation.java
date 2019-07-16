/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DogParadise.Database;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import java.net.UnknownHostException;
import org.bson.Document;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;

/**
 *
 * @author aladelia
 */
public class DaoImplementation implements Dao {
    
    private Document d = null;

    private static DaoImplementation mongoDao = null;

    final private String url = "mongodb://127.0.0.1:27017";
    final private String dbName = "DogParadise";
    private MongoDatabase database = null;

    private DaoImplementation() throws UnknownHostException {
        com.mongodb.client.MongoClient mongoClient = MongoClients.create(url);
        database = mongoClient.getDatabase(dbName);
    }

    public static DaoImplementation getInstance() throws UnknownHostException {
        if (mongoDao == null) {
            mongoDao = new DaoImplementation();
        }
        return mongoDao;
    }

    //This is how you create a table in the mongoDB
    @Override
    public Boolean createTable(String collectionName) {

        final MongoIterable<String> iterable = database.listCollectionNames();
        try (final MongoCursor<String> it = iterable.iterator()) {
            while (it.hasNext()) {
                if (it.next().equalsIgnoreCase(collectionName)) {
                    return false;
                }
            }

        }

        database.createCollection(collectionName);
        return true;
    }

    @Override
    public void saveToDB(String collectionName, Document dbObject) {
        MongoCollection<Document> collection;

        collection = database.getCollection(collectionName);
        collection.insertOne(dbObject);
    }

    @Override
    public boolean checkExistingFieldInDb(String collectionName, String field, String attribute) {
        MongoCollection<Document> collection = null;
        collection = database.getCollection(collectionName);

        Document document = collection
                .find(new BasicDBObject(field, attribute)).first();
        //.projection(Projections.fields(Projections.include(field), Projections.excludeId())).first();
        if (document != null) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public Document findADocument(String collectionName,String field, String attribute){
        MongoCollection<Document> collection = database.getCollection(collectionName);
        
        d= collection.find(eq(field, attribute)).first();
        System.out.println(d.getObjectId("_id").toString());
        return d;
    }

}
