package com.capitolone.cua.service;

import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.capitolone.cua.bo.vo.UserExpenditure;
import com.capitolone.cua.service.response.ServiceResponse;


public interface CardUsageService {
	Map<String,UserExpenditure> getMonthlyMoneyUsageOfUser();
}
