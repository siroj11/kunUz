package org.example.kunuz.dto;

import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.kunuz.model.Article;
import org.example.kunuz.model.Profile;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleLikeDto {
    private Profile profile_id;
    private Article article_id;
    private Date created_date;
    private String status;
}
