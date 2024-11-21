package org.example.kunuz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Attach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String original_name;
    @Column(nullable = false)
    private String path;
    @Column(nullable = false)
    private String size;
    @Column(nullable = false)
    private String extension;
    @Column(nullable = false)
    private String created_date;
}
