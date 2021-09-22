package com.webproject.web_miniproject.domain;

import static javax.persistence.FetchType.LAZY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.webproject.web_miniproject.domain.common.BaseEntity;

import lombok.Getter;

@Entity
@Getter
@Table(name = "users")
public class User extends BaseEntity {
    
    @Id
    @GeneratedValue
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(name = "user_name", length = 50, nullable = false)
    private String name;

    @Column(name = "user_phone", nullable = false, unique = true)
    private String phone;

    @OneToMany(fetch = LAZY, mappedBy = "writer")
    private List<Board> board;


    protected User(){

    }

    public void changeInfo(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }
    

}
