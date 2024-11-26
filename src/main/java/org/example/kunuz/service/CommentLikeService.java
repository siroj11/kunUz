package org.example.kunuz.service;

import org.example.kunuz.dto.ArticleLikeDto;
import org.example.kunuz.dto.CommentLikeDto;
import org.example.kunuz.model.ArticleLike;
import org.example.kunuz.model.CommentLike;
import org.example.kunuz.model.Result;
import org.example.kunuz.repository.ArticleLikeRepo;
import org.example.kunuz.repository.CommentLikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentLikeService {
    @Autowired
    CommentLikeRepo commentLikeRepo;

    public List<CommentLike> read() {
        return commentLikeRepo.findAll();
    }

    public Result create(CommentLikeDto commentLikeDto) {
        CommentLike commentLike = new CommentLike();
        commentLike.setCreated_date(commentLikeDto.getCreated_date());
        commentLike.setStatus(commentLikeDto.getStatus());
        commentLike.setCommentId(commentLikeDto.getCommentId());
        commentLike.setStatus(commentLikeDto.getStatus());
        commentLikeRepo.save(commentLike);
        return new Result(true, "CommentLike created successfully");
    }

    public Result update(CommentLikeDto commentLikeDto, Integer id) {
        Optional<CommentLike> commentLikeOptional = commentLikeRepo.findById(id);
        if (commentLikeOptional.isPresent()) {
            CommentLike commentLike = commentLikeOptional.get();
            commentLike.setStatus(commentLikeDto.getStatus());
            commentLike.setCreated_date(commentLikeDto.getCreated_date());
            commentLike.setCommentId(commentLikeDto.getCommentId());
            commentLike.setProfileId(commentLikeDto.getProfileId());
            commentLikeRepo.save(commentLike);
            return new Result(true, "CommentLike updated successfully");
        }
        return new Result(false, "CommentLike not found");
    }

    public Result delete(Integer id) {
        commentLikeRepo.deleteById(id);
        return new Result(true, "CommentLike deleted successfully");
    }
}
