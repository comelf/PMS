package com.pms.web.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String textKey;

    @Column(nullable = false)
    private String name;

    public Role(String textKey, String name){
        this.textKey = textKey;
        this.name = name;
    }

}
