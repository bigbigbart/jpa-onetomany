package com.springboothibernate.hinbernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HistoryId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userId;
    private String historyId;

    public HistoryId() {
    }

    public HistoryId(String userId, String historyId) {
        this.userId = userId;
        this.historyId = historyId;
    }

    @Override
    public String toString() {
        return "HistoryId{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", historyId='" + historyId + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId;
    }

    //
    //通过userID拿到证玩家升上所有玩过局数的uuid 每次小结算产生一个。
    // 存入数据库中
    // 通UIID找到对应的RoomID 拿到 RoomHistory 一对多 房间信息 List<UserHistory>
    //UserHistory
}
