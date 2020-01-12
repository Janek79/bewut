package com.micro.bewut.repository;

import com.micro.bewut.entity.MeasurementPoint;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;

public interface MeasurementPointRepository extends MongoRepository<MeasurementPoint, LocalDateTime> {
}
