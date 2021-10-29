package com.studentcollege.mapper;



import org.springframework.stereotype.Service;

import com.studentcollege.entity.Order;
import com.studentcollege.response.BookResponse;


@Service
public class OrderMapper {

	public Order mapBookResponseToOrder(BookResponse bookResponse, String Price) {
		return new Order(bookResponse.getBookAuthor(), bookResponse.getBookIsbn13(), bookResponse.getBookLanguage(),
				bookResponse.getBookNumOfPages(), bookResponse.getBookPublishDate(), bookResponse.getBookPublisher(),
				bookResponse.getBookTitle(), bookResponse.getBookType(), Price);
	}
}
