package com.capitolone.cua.controller;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capitolone.cua.bo.vo.UserExpenditure;
import com.capitolone.cua.service.CardUsageService;
import com.capitolone.cua.service.response.ServiceResponse;

@RestController
public class UsageAnalyticController {
	
	@Autowired
	CardUsageService cardUsageService;
	
	@RequestMapping("/usageAnalytic")
	public Map<String,UserExpenditure> getUsageAnalytic(){
		return cardUsageService.getMonthlyMoneyUsageOfUser(null);
	}
	
	@RequestMapping("/usageAnalytic-ignoreDonuts")
	public Map<String, UserExpenditure> getUsageAnalyticIgnoreMerchant(){
		Set<String> ignoreMerchant = new HashSet<String>();
		ignoreMerchant.add("Krispy Kreme Donuts");
		ignoreMerchant.add("DUNKIN #336784");
		return cardUsageService.getMonthlyMoneyUsageOfUser(ignoreMerchant);
	}

}
