package com.springboothibernate.hinbernate.entity;

import javax.persistence.*;
import java.util.Set;


@Entity
public class RoomHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String uuid; // 直接查询 条件是这个 where UUID  = userALL.getUuid

    private String roomId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "roomHisory_index")
    private Set<UserHistory> userHistorySet;


    public RoomHistory() {
    }

    public RoomHistory(String uuid, String roomId, Set<UserHistory> userHistorySet) {
        this.uuid = uuid;
        this.roomId = roomId;
        this.userHistorySet = userHistorySet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Set<UserHistory> getUserHistorySet() {
        return userHistorySet;
    }

    public void setUserHistorySet(Set<UserHistory> userHistorySet) {
        this.userHistorySet = userHistorySet;
    }

    @Override
    public String toString() {
        return "RoomHistory{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", roomId='" + roomId + '\'' +
                ", userHistorySet=" + userHistorySet +
                '}';
    }
}
