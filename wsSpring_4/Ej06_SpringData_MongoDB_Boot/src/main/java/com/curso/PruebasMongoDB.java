package com.curso;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class PruebasMongoDB {

	public static void main(String[] args) {
		
		try {
			MongoClient mongoClient = new MongoClient();
			
			DB database = mongoClient.getDB("bbdd");
			
			DBCollection collection = database.getCollection("personas");
			
			DBObject persona = new BasicDBObject("_id", 2)
                    .append("nombre", "Jesus Witness")
                    .append("direccion", "456 ")
                    .append("telefono", "555");	
			//collection.insert(persona);

			DBObject query = new BasicDBObject("_id", 2);
			DBCursor cursor = collection.find(query);
			while(cursor.hasNext()){
				
				DBObject obj = cursor.next();
				System.out.println(obj.get("nombre"));
				
			}
			
			
			
			System.out.println("FIN");
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
