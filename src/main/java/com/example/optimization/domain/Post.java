package com.example.optimization.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Post {

    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    private String title;
    private String content;

//    private String etc1;
//    private String etc2;
//    private String etc3;
//    private String etc4;
//    private String etc5;
//    private String etc6;
//    private String etc7;
//    private String etc8;
//    private String etc9;
}
