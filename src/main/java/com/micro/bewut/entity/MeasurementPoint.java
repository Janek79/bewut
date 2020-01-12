package com.micro.bewut.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.Map;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MeasurementPoint {

    @Id
    private LocalDateTime time;

    private String label;

    private Map<String, Object> data;

}
