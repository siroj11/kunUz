package org.example.kunuz.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.kunuz.model.Article;
import org.example.kunuz.model.Profile;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentDto {
    private Date created_date;
    private Date updated_date;

    private Profile profile_id;
    private String content;
    private Article article_id;
    private Integer reply_id;
    private String visible;
}
