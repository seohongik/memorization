package com.fastcampus.jpa.bookmanager.domain;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)//아이디 자동으로 증가
    private long id;

    @NonNull
    private String name;

    @NonNull
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
