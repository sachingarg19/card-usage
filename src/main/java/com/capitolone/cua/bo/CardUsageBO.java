package com.capitolone.cua.bo;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.capitolone.cua.bo.vo.UserExpenditure;
import com.capitolone.cua.service.response.ServiceResponse;

public interface CardUsageBO {
	
	public Map<String,UserExpenditure> getMonthlyExpenditureOfUser(ServiceResponse response,Set<String> ignoreMerchant);

}
