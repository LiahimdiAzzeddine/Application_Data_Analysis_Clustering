package net.mongo.api.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import net.mongo.api.model.Appartement;

public interface AppartementRepository extends MongoRepository<Appartement,String> {

}
