package com.springboothibernate.hinbernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String userId;
    private int score;
    private String cards;

    public UserHistory() {
    }

    public UserHistory(String userId, int score, String cards) {
        this.userId = userId;
        this.score = score;
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "UserHistory{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", score=" + score +
                ", cards='" + cards + '\'' +
                '}';
    }
}
