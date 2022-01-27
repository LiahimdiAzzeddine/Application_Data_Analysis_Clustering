package net.mongo.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import net.mongo.api.model.Appartement;
import net.mongo.api.model.DataFlutter;

public interface DataFlutterRepository  extends MongoRepository<DataFlutter,String> {

}
