package com.micro.bewut.service;

import com.micro.bewut.entity.MeasurementPoint;
import com.micro.bewut.repository.MeasurementPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementPointService {

    @Autowired
    MeasurementPointRepository pointRepository;

    public List<MeasurementPoint> getAllPoints(){
        return pointRepository.findAll();
    }

    public void savePoint(MeasurementPoint point) { pointRepository.save(point); }

}
