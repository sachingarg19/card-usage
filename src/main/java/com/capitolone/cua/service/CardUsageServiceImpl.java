package com.capitolone.cua.service;

import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capitolone.cua.bo.CardUsageBO;
import com.capitolone.cua.bo.vo.UserExpenditure;
import com.capitolone.cua.service.client.COServiceClient;
import com.capitolone.cua.service.response.ServiceResponse;
import com.capitolone.cua.service.response.Transactions;

@Component
public class CardUsageServiceImpl implements CardUsageService {

	@Autowired
	private COServiceClient coServiceClient;
	
	@Autowired
	private CardUsageBO cardUsageBO;
	
	public Map<String,UserExpenditure> getMonthlyMoneyUsageOfUser() {
		ServiceResponse response = coServiceClient.getTransactions(ServiceResponse.class);
		if(response.getError().equalsIgnoreCase("no-error")){
			return cardUsageBO.getMonthlyExpenditureOfUser(response);
		}
		return null;
	}

}
