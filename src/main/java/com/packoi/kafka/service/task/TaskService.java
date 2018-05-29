/**
 * 
 */
package com.packoi.kafka.service.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.packoi.kafka.model.Task;

/**
 * @author tao.wang@jrj.com.cn
 *
 */
@Service
public class TaskService {
	@Autowired
	@Qualifier("taskMongoTemplate")
	private MongoTemplate taskMongoTemplate;
	 
	public void saveTask(Task task) {
		taskMongoTemplate.save(task);
	}
	
	public void updateTaskClick(int plid,int total){
		System.out.println("plid:"+plid+",total:"+total);
		Query query=new Query(Criteria.where("plid").is(plid));
		Update update=new Update().set("total", total);
		taskMongoTemplate.updateFirst(query, update, "task");//updateMulti
	}
}
