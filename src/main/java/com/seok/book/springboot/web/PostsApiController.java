package com.seok.book.springboot.web;

import com.seok.book.springboot.service.posts.PostsService;
import com.seok.book.springboot.web.dto.PostsResponseDto;
import com.seok.book.springboot.web.dto.PostsSaveRequestDto;
import com.seok.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor                        //final이 선언된 모든 필드를 인자값6으로 하는 생성자를 만들어 줌 -> lombok을 쓰지 않으면 의존성 관계가 변경될 때마다 생성자 코드를 계속 변경해야 함
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestsDto){
        return postsService.update(id, requestsDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }

}
