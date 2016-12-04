package com.capitolone.cua.bo;

import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capitolone.cua.bo.vo.UserExpenditure;
import com.capitolone.cua.service.response.ServiceResponse;
import com.capitolone.cua.service.response.Transactions;
import com.capitolone.cua.util.CardUsageUtil;

@Component
public class CardUsageBOImpl implements CardUsageBO {

	@Autowired
	CardUsageUtil cardUsageUtil;

	public Map<String, UserExpenditure> getMonthlyExpenditureOfUser(ServiceResponse response) {
		SortedMap<String, UserExpenditure> monthlyTransactionMap = new TreeMap<String, UserExpenditure>();
		if (response != null) {
			Iterator itr = (Iterator) response.getTransactions().iterator();
			while (itr.hasNext()) {
				Transactions transaction = (Transactions) itr.next();
				addTransaction(monthlyTransactionMap, transaction);
			}
			addAverage(monthlyTransactionMap);

		}
		return monthlyTransactionMap;
	}

	private void addAverage(Map<String, UserExpenditure> monthlyTransactionMap) {
		if (monthlyTransactionMap != null) {
			Integer mapSize = monthlyTransactionMap.keySet().size();
			Double spent = new Double(0.0);
			Double income = new Double(0.0);
			Iterator it = monthlyTransactionMap.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry) it.next();
				UserExpenditure usrExp = (UserExpenditure) pair.getValue();
				income += usrExp.getIncome();
				spent += usrExp.getSpent();
			}
			UserExpenditure avgUsrExp = new UserExpenditure();
			avgUsrExp.setIncome(income/mapSize);
			avgUsrExp.setSpent(spent/mapSize);
			monthlyTransactionMap.put("average",avgUsrExp);
		}
	}

	private void addTransaction(Map<String, UserExpenditure> monthlyTransactionMap, Transactions transaction) {
		UserExpenditure userExpenditure = monthlyTransactionMap
				.get(cardUsageUtil.getDateKey(transaction.getTransaction_time()));
		if (userExpenditure != null) {
			if (transaction.getAmount() < 0) {
				Double spentAmt = new Double(userExpenditure.getSpent() + transaction.getAmount());
				userExpenditure.setSpent(spentAmt);
			} else {
				Double incomeAmt = userExpenditure.getIncome() + transaction.getAmount();
				userExpenditure.setIncome(incomeAmt);
			}
		} else {
			userExpenditure = new UserExpenditure();
			if (transaction.getAmount() < 0)
				userExpenditure.setSpent(transaction.getAmount());
			else
				userExpenditure.setIncome(transaction.getAmount());
			monthlyTransactionMap.put(cardUsageUtil.getDateKey(transaction.getTransaction_time()), userExpenditure);
		}
	}

}
