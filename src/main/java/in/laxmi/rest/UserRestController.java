package in.laxmi.rest;

import java.util.HashMap;
import java.util.Map;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.laxmi.binding.User;

@RestController
public class UserRestController {
	
	private Map<Integer, User> dataMap = new HashMap<>();
	
	@PostMapping(value = "/user",
			     consumes="application/json")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		System.out.println(user);
		dataMap.put(user.getId(), user);
		return new ResponseEntity<String>("User Saved", HttpStatus.CREATED);
	}
	
	
	/*@GetMapping("/user")
	public User getUser(@RequestParam("userid") Integer UserId) {
		User user = dataMap.get(UserId);
		return user;
	}*/
	
	/*@GetMapping("/user")
	public User getUserData(@RequestParam("userid") Integer UserId,@RequestParam("username") String name) {
		User user = dataMap.get(UserId);
		return user;
	}*/
	
	@GetMapping(value = "/user/{id}/data",
			    produces="application/json")
	public User getUserData(@PathVariable("id") Integer UserId) {
		User user = dataMap.get(UserId);
		return user;
	}
}
