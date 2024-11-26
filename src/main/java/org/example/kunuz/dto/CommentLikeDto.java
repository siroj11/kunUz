package org.example.kunuz.dto;

import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.kunuz.model.Comment;
import org.example.kunuz.model.Profile;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentLikeDto {
    private Profile profileId;
    private Comment commentId;
    private Date created_date;
    private String status;
}
