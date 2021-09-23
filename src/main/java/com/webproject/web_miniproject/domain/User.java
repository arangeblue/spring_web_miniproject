package com.webproject.web_miniproject.domain;

import static javax.persistence.FetchType.LAZY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.webproject.web_miniproject.domain.common.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User extends BaseTimeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "user_name", length = 50, nullable = false)
    private String name;

    @Column(name = "user_phone", nullable = false, unique = true)
    private String phone;

    @OneToMany(fetch = LAZY, mappedBy = "id")
    private List<Board> boards = new ArrayList<>();


    @Builder
    public User( String name, String phone ) {
        
        this.name = name;
        this.phone = phone;
    }



    public void changeInfo(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }
    

        
}
