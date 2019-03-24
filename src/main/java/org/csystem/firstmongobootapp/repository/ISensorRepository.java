package org.csystem.firstmongobootapp.repository;

import org.csystem.firstmongobootapp.entity.SensorInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

@Repository
public interface ISensorRepository extends MongoRepository<SensorInfo, String> {

}
