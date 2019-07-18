/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DogParadise.Database;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import java.net.UnknownHostException;
import org.bson.Document;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.types.ObjectId;

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
    public Boolean createCollection(String collectionName) {

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
    public void updateDB(String collectionName, Document filter, Document dbObject) {
        MongoCollection<Document> collection;

        collection = database.getCollection(collectionName);
        collection.updateOne(filter, dbObject);

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
    public Document findADocument(String collectionName, String field, String attribute) {
        MongoCollection<Document> collection = database.getCollection(collectionName);

        d = collection.find(eq(field, attribute)).first();

        return d;
    }

    @Override
    public Document findADocument(String collectionName, String field, ObjectId attribute) {
        MongoCollection<Document> collection = database.getCollection(collectionName);

        d = collection.find(eq(field, attribute)).first();

        return d;
    }

    @Override
    public ArrayList<Document> getCollection(String collectionName) {

        MongoCollection<Document> collection = database.getCollection(collectionName);
        FindIterable<Document> findIterable = collection.find(new Document());
        MongoCursor<Document> cursor = findIterable.iterator();
        ArrayList<Document> doc = new ArrayList<Document>();

        while (cursor.hasNext()) {
            Document d = cursor.next();
            doc.add(d);
        }

        return doc;
    }

    @Override
    public void initializeEmployeeCollection() {
        try {
            this.createCollection("Employee");

            Dao dao = DaoImplementation.getInstance();

            ArrayList<Document> docs = new ArrayList<>();

            docs = dao.getCollection("Employee");

            if (docs.isEmpty()) {
                Document docAdmin = new Document("username", "aladelia")
                        .append("password", "qazwsx")
                        .append("typeemployee", "admin");

                Document docVet = new Document("username", "amonciino")
                        .append("password", "qazwsx")
                        .append("typeemployee", "vet");

                dao.saveToDB("Employee", docAdmin);
                dao.saveToDB("Employee", docVet);
                System.out.println("Initialized");
            } else {
                System.out.println("Already initialized");
            }

        } catch (UnknownHostException ex) {
            Logger.getLogger(DaoImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
