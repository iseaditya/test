package com.springboot.h2.serv;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.h2.model.Order;
import com.springboot.h2.repo.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	public void saveOrder(final Order order) {
		orderRepository.save(order);
	}

	public List<Order> getAllOrder() {
		final List<Order> orders = new ArrayList<>();
		orderRepository.findAll().forEach(order -> orders.add(order));
		return orders;
	}
}

