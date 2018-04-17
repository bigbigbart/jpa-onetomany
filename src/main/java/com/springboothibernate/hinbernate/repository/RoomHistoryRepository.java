package com.springboothibernate.hinbernate.repository;

import com.springboothibernate.hinbernate.entity.HistoryId;
import com.springboothibernate.hinbernate.entity.RoomHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomHistoryRepository  extends JpaRepository<RoomHistory, Integer> {
    List<RoomHistory> findByUuid(String userId);

}
