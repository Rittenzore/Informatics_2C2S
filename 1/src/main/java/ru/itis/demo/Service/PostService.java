package ru.itis.demo.Service;

import org.springframework.stereotype.Service;
import ru.itis.demo.DTO.PostDto;
import ru.itis.demo.Interface.PostInt;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService implements PostInt {

    private List<PostDto> postDto = new ArrayList<>();

    public PostService() {
        for (int i = 0; i < 51; i++) {
            postDto.add(new PostDto("test" + i, String.valueOf(i)));
        }
    }

    @Override
    public List<PostDto> list() {
        return postDto;
    }

    @Override
    public List<PostDto> search(String query) {
        return query != null && !query.isEmpty() ? postDto.stream().filter(postDto ->
                postDto.getTitle().toLowerCase().matches(".*" + query.toLowerCase() + ".*"))
                .collect(Collectors.toList())
                : postDto;
    }
}
