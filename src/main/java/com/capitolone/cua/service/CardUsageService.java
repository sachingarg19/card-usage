package com.capitolone.cua.service;

import java.util.Map;
import java.util.Set;

import com.capitolone.cua.bo.vo.UserExpenditure;


public interface CardUsageService {
	Map<String,UserExpenditure> getMonthlyMoneyUsageOfUser(Set<String> ignoreMerchant);
}
