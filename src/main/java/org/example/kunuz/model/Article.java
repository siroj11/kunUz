package org.example.kunuz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private int shared_Count;
    @Column(nullable = false)
    private int imageId;
    @OneToOne
    private Region regionId;
    @OneToOne
    private Category categoryId;
    @Column(nullable = false)
    //must create Moderator class
    private Integer moderatorId;
    @Column(nullable = false)
    //must create Publisher class
    private Integer publisherId;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private Date created_date;
    @Column(nullable = false)
    private Date published_date;
    @Column(nullable = false)
    private String visible;
    @Column(nullable = false)
    private Long view_count;
}