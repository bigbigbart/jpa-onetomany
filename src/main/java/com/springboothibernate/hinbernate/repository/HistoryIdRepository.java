package com.springboothibernate.hinbernate.repository;

import com.springboothibernate.hinbernate.entity.HistoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryIdRepository extends JpaRepository<HistoryId, Integer> {

   List<HistoryId> findByUserId(String userId);
}
