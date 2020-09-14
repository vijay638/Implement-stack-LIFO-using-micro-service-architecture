package com.Nokia.Assignment;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PushPopController {
	
	@Autowired
	private StackRepository repository;
	@Autowired
	private  Environment environment;
	
	static Logger logger = LoggerFactory.getLogger(PushPopController.class);

	@GetMapping("stackOperation/push/{data}")
	public LinkedList<StackData> push(@PathVariable int data){
		
		logger.debug("called stack-push-pop-service instance running on port -> {}" ,environment.getProperty("local.server.port"));
		logger.debug("called stack-push-pop-service stackOperation/push/{data} api");
		
		StackData sdata = new StackData();	
	    sdata.setData(data);
	    repository.save(sdata);	    
	    logger.debug("Data pushed to stack -> {}",sdata.getData() );
		List<StackData> ar = repository.findAll();
		LinkedList<StackData> list = new LinkedList<StackData>();
		for(StackData i : ar) {
			list.addFirst(i);
		}
		
		return list;
	}
	
	@GetMapping("stackOperation/pop/")
	public List<StackData> pop(){
		 
		logger.debug("called stack-push-pop-service instance running on port -> {}" ,environment.getProperty("local.server.port"));
		logger.debug("called stack-push-pop-service stackOperation/pop api");
		
		List<StackData> ar = repository.findAll();
		if(ar.isEmpty()) {
			return null;
		}
		LinkedList<StackData> list = new LinkedList<StackData>();
		for(StackData i : ar) {
			list.addFirst(i);
		}
		StackData sdata = list.peek();
		list.removeFirst();
		repository.deleteById(sdata.getId());
		logger.debug("Data poped from stack -> {}",sdata.getData() );
		return list; 
	}
	
}
