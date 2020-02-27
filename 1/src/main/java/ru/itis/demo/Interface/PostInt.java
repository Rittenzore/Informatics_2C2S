package ru.itis.demo.Interface;

import ru.itis.demo.DTO.PostDto;

import java.util.List;

public interface PostInt {
    List<PostDto> list();
    List<PostDto> search(String query);
}
