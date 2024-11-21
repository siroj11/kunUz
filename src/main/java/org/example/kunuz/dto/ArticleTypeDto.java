package org.example.kunuz.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleTypeDto {
    private Integer order_number;
    private String name_uz;
    private String name_ru;
    private String name_eng;
    private String visible;
    private Date created_date;
}
