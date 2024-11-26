package org.example.kunuz.service;

import org.example.kunuz.dto.CommentDto;
import org.example.kunuz.model.Comment;
import org.example.kunuz.model.Result;
import org.example.kunuz.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CommentService {
    @Autowired
    CommentRepo commentRepo;

    public List<Comment> read(){
        return commentRepo.findAll();
    }

    public Result create(CommentDto commentDto){
        Comment comment = new Comment();
        comment.setCreated_date(commentDto.getCreated_date());
        comment.setUpdated_date(commentDto.getUpdated_date());
        comment.setProfile_id(commentDto.getProfile_id());
        comment.setContent(commentDto.getContent());
        comment.setArticle_id(commentDto.getArticle_id());
        comment.setReply_id(commentDto.getReply_id());
        comment.setVisible(commentDto.getVisible());
        commentRepo.save(comment);
        return new Result(true,"Comment created successfully");
    }

    public Result update(CommentDto commentDto,Integer id){
        Optional<Comment> optionalComment = commentRepo.findById(id);
        if(optionalComment.isPresent()){
            Comment comment = optionalComment.get();
            comment.setCreated_date(commentDto.getCreated_date());
            comment.setUpdated_date(commentDto.getUpdated_date());
            comment.setProfile_id(commentDto.getProfile_id());
            comment.setContent(commentDto.getContent());
            comment.setArticle_id(commentDto.getArticle_id());
            comment.setReply_id(commentDto.getReply_id());
            comment.setVisible(commentDto.getVisible());
            commentRepo.save(comment);
            return new Result(true,"Comment updated successfully");
        }
        return new Result(false,"Comment not found");
    }

    public Result delete(Integer id){
        commentRepo.deleteById(id);
        return new Result(true,"Comment deleted successfully");
    }
}