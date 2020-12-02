package com.seok.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//Entity 클래스와 기본 Entity Repository는 함께 위치 해야 함
public interface PostsRepository extends JpaRepository<Posts, Long>{
}
