package org.example.kunuz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ArticleType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Integer order_number;
    @Column(nullable = false)
    private String name_uz;
    @Column(nullable = false)
    private String name_ru;
    @Column(nullable = false)
    private String name_eng;
    @Column(nullable = false)
    private String visible;
    @Column(nullable = false)
    private Date created_date;
}
