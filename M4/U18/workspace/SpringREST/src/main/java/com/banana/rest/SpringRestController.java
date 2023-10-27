package com.banana.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banana.model.Message;

@RestController
public class SpringRestController {
	@RequestMapping("/")
	public String welcome() {// Welcome page, non-rest
		return "Welcome to RestTemplate Example.";
	}

	@RequestMapping("/hello/{player}")
	public Message message(@PathVariable String player) {// REST Endpoint.

		Message msg = new Message();
		msg.setName(player);
		msg.setText("Hello " + player);

		return msg;
	}

	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public ResponseEntity<Message> updateMessage(@RequestBody Message msg) {

		System.out.println("Entra:" + msg);

		if (msg != null) {
			msg.setName("Hello " + msg.getName());
		}

		return new ResponseEntity<Message>(msg, HttpStatus.OK);
	}
}
