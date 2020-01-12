package com.micro.bewut.controller;

import com.micro.bewut.annotation.Counter;
import com.micro.bewut.annotation.CounterField;
import com.micro.bewut.annotation.CounterFields;
import com.micro.bewut.dto.Book;
import com.micro.bewut.entity.MeasurementPoint;
import com.micro.bewut.service.MeasurementPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuasiController {

    @Autowired
    MeasurementPointService measurementPointService;

    @Counter
    @PostMapping("/age")
    public Integer getAgeOfAuthorWhenBookPublished(
            @CounterFields(
                    {@CounterField(path = "author.firstName", as = "firstName"),
                            @CounterField(path = "title", as = "bookTitle"),
                    @CounterField(path = "author.address.city", as = "authorCity")}) @RequestBody Book book){
        return book.getYearOfPublishing() - book.getAuthor().getYearOfBirth();
    }

    @GetMapping("/")
    public List<MeasurementPoint> getAllMeasurements(){
        return measurementPointService.getAllPoints();
    }


}
