package kr.co.cinema.management;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes({"brcName","brcCode"})
@Controller
public class ManagementController {

	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

	@Autowired
	private ManagementService managementService;
	
	//할인정보 등록
	@RequestMapping(value="discountInfoInsert", method=RequestMethod.GET)
	public String insertDiscountInfoView() {
		logger.debug(" Controller insertDiscountInfoView get실행");
		return "management/discountInfoInsert";
	}
	
	//할인정보리스트
	@RequestMapping(value="discountInfoList", method=RequestMethod.GET)
	public String selectDiscountInfoList() {
		logger.debug(" Controller selectDiscountInfoList get실행");
		return "management/discountInfoList";
	}
}
