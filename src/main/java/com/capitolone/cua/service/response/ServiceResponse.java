package com.capitolone.cua.service.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServiceResponse {
	@JsonProperty("error")
	private String error;
	
	@JsonProperty("transactions")
	private List<Transactions> transactions;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public List<Transactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}

	
	@Override
	public String toString() {
		return "ServiceResponse [error=" + error + ", transactions=" + transactions + "]";
	}

}
