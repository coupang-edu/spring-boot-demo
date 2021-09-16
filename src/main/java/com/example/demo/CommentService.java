package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    final private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<CommentDto> getList() {
        return commentRepository.findAll().stream()
                .map(CommentDto::new)
                .collect(Collectors.toList());
    }

    public CommentDto create(CommentDto commentDto) {
        return new CommentDto(commentRepository.save(commentDto.toEntity()));
    }

    public void delete(Long id) {
        commentRepository.deleteById(id);
    }
}
