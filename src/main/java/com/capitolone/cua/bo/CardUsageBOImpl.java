package com.capitolone.cua.bo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capitolone.cua.bo.vo.UserExpenditure;
import com.capitolone.cua.service.response.ServiceResponse;
import com.capitolone.cua.service.response.Transactions;
import com.capitolone.cua.util.CardUsageUtil;

@Component
public class CardUsageBOImpl implements CardUsageBO{

	@Autowired
	CardUsageUtil cardUsageUtil;
	
	public Map<String,UserExpenditure> getMonthlyExpenditureOfUser(ServiceResponse response) {
		Map<String,UserExpenditure> monthlyTransactionMap = new HashMap<String, UserExpenditure>();
		if(response != null){
			
			
			Iterator itr = (Iterator) response.getTransactions().iterator();
			while (itr.hasNext()) {
				Transactions transaction = (Transactions) itr.next();
				addTransaction(monthlyTransactionMap,transaction);
			}
				
		}
		return monthlyTransactionMap;
	}

	private void addTransaction(Map<String, UserExpenditure> monthlyTransactionMap, Transactions transaction) {
		UserExpenditure userExpenditure = monthlyTransactionMap.get(cardUsageUtil.getDateKey(transaction.getTransaction_time()));
		if(userExpenditure !=null){
			if(transaction.getAmount() < 0){
				Double spentAmt = new Double(userExpenditure.getSpent() + transaction.getAmount());
				userExpenditure.setSpent(spentAmt);
			} else{
				Double incomeAmt = userExpenditure.getIncome() + transaction.getAmount();
				userExpenditure.setIncome(incomeAmt);
			}
		} else{
			userExpenditure = new UserExpenditure();
			if(transaction.getAmount() < 0)
				userExpenditure.setSpent(transaction.getAmount());
			else
				userExpenditure.setIncome(transaction.getAmount());
			monthlyTransactionMap.put(cardUsageUtil.getDateKey(transaction.getTransaction_time()), userExpenditure);
		}
	}

	

}
