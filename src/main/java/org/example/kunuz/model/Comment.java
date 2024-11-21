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
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Date created_date;
    @Column(nullable = false)
    private Date updated_date;
    @ManyToOne
    private Profile profile_id;
    @Column(nullable = false)
    private String content;
    @OneToOne
    private Article article_id;
    @Column(nullable = false)
    private Integer reply_id;
    @Column(nullable = false)
    private String visible;
}
