package com.swz.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebsocketController {

	@RequestMapping("/webtest")
	public String websocketString() {
		System.out.println("不知道在请求什么呢");
		return "I don't know what is applied";
	}
}
