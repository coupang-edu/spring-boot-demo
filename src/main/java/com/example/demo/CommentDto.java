package com.example.demo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CommentDto {
    private Long id;
    private String content;

    public CommentDto(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
    }

    public Comment toEntity() {
        return Comment.builder()
                .id(id)
                .content(content)
                .build();
    }
}
