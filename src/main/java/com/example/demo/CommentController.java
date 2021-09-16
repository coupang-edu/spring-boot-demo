package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("")
    public String commentList(Model model) {
        model.addAttribute("comments", commentService.getList());
        return "comment/list.html";
    }

    @PostMapping("/comments")
    public RedirectView commentCreate(@ModelAttribute CommentDto commentDto) {
        commentService.create(commentDto);
        return new RedirectView("/comments");
    }

    @DeleteMapping("/comments/{id}")
    public RedirectView commentDelete(@PathVariable Long id) {
        commentService.delete(id);
        return new RedirectView("/comments");
    }
}
