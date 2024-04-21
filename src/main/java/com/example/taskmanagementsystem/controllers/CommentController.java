package com.example.taskmanagementsystem.controllers;

import com.example.taskmanagementsystem.dto.entity.CommentDTO;
import com.example.taskmanagementsystem.mappers.CommentMapper;
import com.example.taskmanagementsystem.models.Comment;
import com.example.taskmanagementsystem.service.CommentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
@Tag(name = "Comment Controller")
public class CommentController {

    private final CommentService commentService;
    private final CommentMapper commentMapper;


    @PostMapping("/{taskId}/create")
    public CommentDTO create(@RequestBody @Validated CommentDTO commentDTO, @PathVariable Long taskId){
        Comment comment = commentMapper.toEntity(commentDTO);
        Comment createdComment = commentService.create(comment,taskId);
        return commentMapper.toDto(createdComment);
    }

    @GetMapping("/{taskId}/getByTask")
    public List<CommentDTO> getByTaskId(@PathVariable Long taskId){
        List<Comment> list = commentService.getByTaskId(taskId);
        return commentMapper.toDto(list);
    }

    @DeleteMapping("/{commentId}/delete")
    public ResponseEntity<?> deleteComment(@PathVariable Long commentId){
        commentService.deleteById(commentId);
        return ResponseEntity.ok("Comment deleted");
    }
}
