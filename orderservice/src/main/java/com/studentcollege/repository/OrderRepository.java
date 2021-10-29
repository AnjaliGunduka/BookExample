package com.studentcollege.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.studentcollege.entity.Order;


@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

   
//    void deleteByOrderId(String orderId);
}
