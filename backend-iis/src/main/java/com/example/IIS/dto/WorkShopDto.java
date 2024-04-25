package com.example.IIS.dto;

import com.example.IIS.domain.enums.WorkshopCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WorkShopDto {
    private Long id;

    private String name;

    private String description;

    private Date date;

    private Time startTime;

    private Time endTime;

    private WorkshopCategoryDto category;

    private boolean isOnline;

    private double price;

    private List<String> images;

    private Long psychologistId;

    private List<Long> userIds;

    private Long hallId;
}
