package com.capitolone.cua.bo.vo;

import java.text.NumberFormat;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserExpenditure {
	
	@JsonProperty("spent")
	private Double spent=0.0;
	@JsonProperty("income")
	private Double income =0.0;
	
	public Double getSpent() {
		return spent;
	}
	public void setSpent(Double spent) {
		this.spent = spent;
	}
	public Double getIncome() {
		return income;
	}
	public void setIncome(Double income) {
		this.income = income;
	}
	
	@JsonGetter("spent")
	public String getSpentStr() {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		return formatter.format(spent);
	}
	
	@JsonGetter("income")
    public String getIncomeStr() {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(income);
    }
}
