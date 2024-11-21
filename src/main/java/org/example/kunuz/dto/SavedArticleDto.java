package org.example.kunuz.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.kunuz.model.Article;
import org.example.kunuz.model.Profile;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SavedArticleDto {
    private Profile profile_id;
    private Article article_id;
    private Date created_date;
}
