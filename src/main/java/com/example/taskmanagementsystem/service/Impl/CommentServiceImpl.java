package com.example.taskmanagementsystem.service.Impl;

import com.example.taskmanagementsystem.models.Comment;
import com.example.taskmanagementsystem.models.Task;
import com.example.taskmanagementsystem.repository.CommentRepository;
import com.example.taskmanagementsystem.service.CommentService;
import com.example.taskmanagementsystem.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    private final TaskService taskService;

    @Transactional
    @Override
    public Comment create(Comment comment, Long taskId) {
        Task task = taskService.getById(taskId);
        comment.setTask(task);
        comment.setLocalDateTime(LocalDateTime.now());
        commentRepository.save(comment);
        return comment;
    }

    @Override
    public List<Comment> getByTaskId(Long taskId) {
        return commentRepository.findByTaskId(taskId);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

}
