package org.example.kunuz.dto;

import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.kunuz.model.Category;
import org.example.kunuz.model.Region;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {
    private String title;
    private String description;
    private String content;
    private int shared_Count;
    private int imageId;
    private Region regionId;
    private Category categoryId;
    //must create Moderator class
    private Integer moderatorId;
    //must create Publisher class
    private Integer publisherId;
    private String status;
    private Date created_date;
    private Date published_date;
    private String visible;
    private Long view_count;
}