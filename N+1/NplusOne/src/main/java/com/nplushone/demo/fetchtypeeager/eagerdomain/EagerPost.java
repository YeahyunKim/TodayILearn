package com.nplushone.demo.fetchtypeeager.eagerdomain;

import com.nplushone.demo.fetchtypelazy.lazyDomain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "eager_posts")
@Getter
@Setter
@NoArgsConstructor
public class EagerPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "eager_user_id", nullable = false)
    private EagerUser eagerUser;

    private String title;

    public EagerPost(EagerUser user, String title) {
        this.eagerUser = user;
        this.title = title;
    }
}
