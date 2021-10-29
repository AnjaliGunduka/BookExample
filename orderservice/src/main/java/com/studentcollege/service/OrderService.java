package com.studentcollege.service;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentcollege.cleint.OrderClient;
import com.studentcollege.entity.Order;
import com.studentcollege.mapper.OrderMapper;
import com.studentcollege.repository.OrderRepository;
import com.studentcollege.request.OrderRequest;
import com.studentcollege.response.BookResponse;





@Service
public class OrderService {
	@Autowired
	OrderClient orderClient;

	@Autowired
	OrderRepository orderRepository;

	
	@Autowired
	OrderMapper orderMapper;
	private static final Logger log = LoggerFactory.getLogger(OrderService.class);
	
	public Order makeOrder(OrderRequest orderRequest)
	{
		ModelMapper modelMapper = new ModelMapper();
		BookResponse bookRequest= modelMapper.map(orderRequest, BookResponse .class);
		log.info("Order initiated");
		try {
			BookResponse bookResponse = orderClient.adding(bookRequest);
			log.info("Center from College student");
			Order  order=orderMapper.mapBookResponseToOrder(bookResponse,orderRequest.getBookId());
			return orderRepository.save(order);
	}catch (Exception e) {
		e.printStackTrace();
	}
		return null;
	}
	
	
	

	
	
	
	
	
	
	
	
}
