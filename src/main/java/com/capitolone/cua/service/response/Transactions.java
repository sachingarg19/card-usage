package com.capitolone.cua.service.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Transactions {
	@JsonProperty("transaction-id")
	private String transaction_id;

	@JsonProperty("account-id")
	private String account_id;

	@JsonProperty("raw-merchant")
	private String raw_merchant;

	private String merchant;

	@JsonProperty("is-pending")
	private Boolean is_pending;

	@JsonProperty("amount")
	private Double amount;

	private String categorization;

	@JsonProperty("memo-only-for-testing")
	private String memo_only_for_testing;

	@JsonProperty("payee-name-only-for-testing")
	private String payee_name_only_for_testing;

	@JsonProperty("clear-date")
	private Long clear_date;

	@JsonProperty("aggregation-time")
	private Long aggregation_time;

	@JsonProperty("transaction-time")
	private String transaction_time;

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	public String getRaw_merchant() {
		return raw_merchant;
	}

	public void setRaw_merchant(String raw_merchant) {
		this.raw_merchant = raw_merchant;
	}

	public String getMerchant() {
		return merchant;
	}

	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}

	public Boolean getIs_pending() {
		return is_pending;
	}

	public void setIs_pending(Boolean is_pending) {
		this.is_pending = is_pending;
	}

	public String getCategorization() {
		return categorization;
	}

	public void setCategorization(String categorization) {
		this.categorization = categorization;
	}

	public String getMemo_only_for_testing() {
		return memo_only_for_testing;
	}

	public void setMemo_only_for_testing(String memo_only_for_testing) {
		this.memo_only_for_testing = memo_only_for_testing;
	}

	public String getPayee_name_only_for_testing() {
		return payee_name_only_for_testing;
	}

	public void setPayee_name_only_for_testing(String payee_name_only_for_testing) {
		this.payee_name_only_for_testing = payee_name_only_for_testing;
	}

	public Long getAggregation_time() {
		return aggregation_time;
	}

	public void setAggregation_time(Long aggregation_time) {
		this.aggregation_time = aggregation_time;
	}

	public Long getClear_date() {
		return clear_date;
	}

	public void setClear_date(Long clear_date) {
		this.clear_date = clear_date;
	}

	@Override
	public String toString() {
		return "Transactions [transaction_id=" + transaction_id + ", account_id=" + account_id + ", raw_merchant="
				+ raw_merchant + ", merchant=" + merchant + ", is_pending=" + is_pending + ", amount=" + amount
				+ ", categorization=" + categorization + ", memo_only_for_testing=" + memo_only_for_testing
				+ ", payee_name_only_for_testing=" + payee_name_only_for_testing + ", clear_date=" + clear_date
				+ ", aggregation_time=" + aggregation_time + ", transaction_time=" + transaction_time + "]";
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getAmount() {
		return amount;
	}

	public String getTransaction_time() {
		return transaction_time;
	}

	public void setTransaction_time(String transaction_time) {
		this.transaction_time = transaction_time;
	}


}
