package kr.co.cinema.booking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
	private static final Logger logger = LoggerFactory.getLogger(BookingService.class);
	
	@Autowired
	BookingDao bookingDao;
	
}
