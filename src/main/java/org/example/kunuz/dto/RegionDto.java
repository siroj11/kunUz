package org.example.kunuz.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegionDto {
    private Long order_number;
    private String name_uz;
    private String name_ru;
    private String name_eng;
    private String visible;
    private Date created_date;
}
