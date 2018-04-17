package com.springboothibernate.hinbernate;

import com.springboothibernate.hinbernate.entity.HistoryId;
import com.springboothibernate.hinbernate.entity.RoomHistory;
import com.springboothibernate.hinbernate.entity.UserHistory;
import com.springboothibernate.hinbernate.repository.HistoryIdRepository;
import com.springboothibernate.hinbernate.repository.RoomHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Controller
@SpringBootApplication
@Configuration
@EnableAutoConfiguration
public class HinbernateApplication implements CommandLineRunner{

	public static void main(String[] args) {

		SpringApplication.run(HinbernateApplication.class, args);

	}

	@Autowired
	private RoomHistoryRepository roomHistoryRepository;

	@Autowired
	private HistoryIdRepository historyIdRepository;

	@Override
	@Transactional
	public void run(String... strings) throws Exception {
		//HistoryId historyId = new HistoryId();
		//1. 先在HisttoryId表中存放 uuid userId
		//2. 根据userId查找出uuid ,根据uuid 查找到roomId信息
		//3. 根据roomId 查出关联的一对多的信息

		//(String userId, String historyId)
		HistoryId historyId = new HistoryId("admin", "150");
		historyIdRepository.save(historyId);


		//(String userId, int score, String cards)
		HashSet hashSet = new HashSet();
		UserHistory uh1 = new UserHistory("test01", 101, "3, 4, 6");
		UserHistory uh2 = new UserHistory("test02", 80, "10, 15,16");
		hashSet.add(uh1);
		hashSet.add(uh2);

		//(String uuid, String roomId, Set<UserHistory> userHistorySet)


		RoomHistory roomHistory = new RoomHistory("150", "78954", hashSet);

		roomHistoryRepository.save(roomHistory);



		//根据用户名查出UUID
		List<HistoryId> result = historyIdRepository.findByUserId("admin");
		List<RoomHistory> roomResultAll = new ArrayList<>();
		for (HistoryId customer:result){
			//查到
			String hid = customer.getHistoryId();
			System.out.println("------->>>>>>>>>>>>>"+hid);

			// 通过uuid查到房间信息
			List<RoomHistory> roomResult = roomHistoryRepository.findByUuid(hid);
			for(RoomHistory r: roomResult){
				System.out.println(">>>>===="+r.toString());
				if(!r.getUserHistorySet().isEmpty()){
					roomResultAll.add(r);
				}

			}
		}

		// 返回一个list
		for (RoomHistory rh:roomResultAll) {
			System.out.println("hahahahah"+rh.toString());
		}



	}
}
