package ru.itis.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.demo.DTO.PostDto;
import ru.itis.demo.Service.PostService;

@Controller
public class HelloController {

    private final PostService postService;

    public HelloController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "User") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @PostMapping("/note")
    public String add(@ModelAttribute PostDto postDto) {
        postService.list().add(postDto);
        return "redirect:notes";
    }

    @GetMapping("/note")
    public String getAdd() {
        return "addPost";
    }

    @GetMapping("/search")
    public String getAll(Model model, @RequestParam(required = false) String query) {
        model.addAttribute("notes", postService.search(query));

        return "allPost";
    }

    @GetMapping("/notes")
    public String showAll(Model model, @RequestParam(defaultValue = "1", required = false) int page) {

        int pages = (int) Math.ceil((double) postService.list().size() / 5);
        if (pages == page) {
            model.addAttribute("pages", pages);
            model.addAttribute("notes", postService.list().subList(page * 5 - 5, postService.list().size()));
        } else if (pages > page && page > 0) {
            model.addAttribute("pages", pages);
            model.addAttribute("notes", postService.list().subList(page * 5 - 5, page * 5));
        } else {
            model.addAttribute("pages", 1);
            model.addAttribute("notes", postService.list().subList(0, 5));
        }

        return "allPost";
    }

}