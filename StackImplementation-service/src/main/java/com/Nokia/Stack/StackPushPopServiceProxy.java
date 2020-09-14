package com.Nokia.Stack;

import java.util.LinkedList;
import java.util.List;

//import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="stack-push-pop-service", url="${STACK_PUSH_POP}:8000")
//@FeignClient(name="stack-push-pop-service")
//@RibbonClient(name="stack-push-pop-service")
public interface StackPushPopServiceProxy {
	
	@GetMapping("stackOperation/push/{data}")
	public LinkedList<StackData> performPush(@PathVariable int data);
	
	@GetMapping("stackOperation/pop/")
	public List<StackData> performPop();

}
