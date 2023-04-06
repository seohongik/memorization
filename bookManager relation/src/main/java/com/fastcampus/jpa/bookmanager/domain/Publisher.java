package com.fastcampus.jpa.bookmanager.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Publisher extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private  String name;

    @OneToMany
    @JoinColumn(name = "publisher_id")
    @ToString.Exclude
    private List<Book> books= new ArrayList<>();
}
