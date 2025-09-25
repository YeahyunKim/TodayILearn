package com.nplushone.demo.fetchtypeeager.eagerdomain;

import com.nplushone.demo.fetchtypelazy.lazyDomain.Post;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "eager_users")
public class EagerUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "eagerUser", fetch = FetchType.EAGER)
    private List<EagerPost> eagerPosts = new ArrayList<>();

    private String name;

    private String email;

    public EagerUser(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
