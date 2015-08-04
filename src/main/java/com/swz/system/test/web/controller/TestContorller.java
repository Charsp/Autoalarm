package com.swz.system.test.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContorller {

	// private Logger logger = LoggerFactory.getLogger(TestContorller.class);
	private static Integer sumInteger = 0;

	private synchronized Integer getSum() {
		sumInteger++;
		return sumInteger;
	}

	private Map<String, Object> returnMap() {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> car = new HashMap<>();
		List<Map<String, Object>> list = new ArrayList<>();
		car.put("code", "车辆断电");
		car.put("car_no", "粤EJU106: " + getSum());
		car.put("car_object_id", "54b0ec6de4b0cd85fb1bd436");
		car.put("id", "54dd5ef999a8ccadc1416229");
		list.add(car);
		car = new HashMap<>();
		car.put("vehideid", 159459);
		car.put("car_no", "粤EJU106");
		returnMap.put("ret", 0);
		returnMap.put("car", car);
		returnMap.put("list", list);
		return returnMap;
	}

	@RequestMapping("/get_alarm_ex")
	public Map<String, Object> virtualGetAddress() {
		// logger.info("返回数据：" + returnMap());
		return returnMap();
	}

	@RequestMapping("/handle_alarm_ex")
	public Map<String, Object> virtualPutAddress() {
		// logger.info("得到数据：-------------------------");
		return returnMap();
	}
}
