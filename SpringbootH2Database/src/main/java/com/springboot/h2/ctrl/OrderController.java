package com.springboot.h2.ctrl;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.h2.model.Order;
import com.springboot.h2.serv.OrderService;

@RestController
public class OrderController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	OrderService orderService;

	@PostMapping(value = "/order/save")
	public int createOrder(final @RequestBody @Valid Order order) {
		log.info("Creating order details in the database.");
		orderService.saveOrder(order);
		return order.getOrderId();
	}

	@GetMapping(value = "/order/getall", produces = "application/vnd.jcg.api.v1+json")
	public List<Order> retrieveAllOrder() {
		log.info("e student details from the database.");
		return orderService.getAllOrder();
	}
}
