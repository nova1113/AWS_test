package com.seok.book.springboot.domain.posts;

//lombok -> 테이블 설계 변경시 코드 변경량을 최소화 시켜 주기 때문에 적극 활용
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter                                     //클래스 내 모들 필드의 Getter 메소드를 자동생성
@NoArgsConstructor                          //기본 생성자 자동 추가
//Entity 클래스에서는 절대 Setter 메소드를 만들지 않는다 -> 어디서 값이 변경 되는지 알 수가 없기 때문
//생성자를 통해 값을 채운 후 변경이 필요한 경우 public 메소드를 호출해서 변경 하도록 작성
@Entity                                     //테이블과 링크될 클래스임을 나타냄
public class Posts {

    @Id                                     //해당 테이블의 PK필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK생성 규칙
    private Long Id;

    @Column(length = 500, nullable = false) //테이블의 칼럼을 나타냄
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder                                //해당 클래스의 빌더 패턴 클래스를 생성??
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
