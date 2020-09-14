package com.Nokia.Stack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/StackImlementation")
public class StackController {
	
	@Autowired
	private StackPushPopServiceProxy proxy;

   @GetMapping("/push/{data}")
   public List<StackData> push(@PathVariable int data) {
	   
	   List<StackData> response = proxy.performPush(data);
	   return response;
}
   
   
   @GetMapping("/pop")
   public List<StackData> pop() {
	   
	  List<StackData> response = proxy.performPop();
	   return response;	   	   
	   
   }
}
