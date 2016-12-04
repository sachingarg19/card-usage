package com.capitolone.cua.service.request;

public class Args {

	private String uid;
	private String token;
	private String api_token = "api-token";
	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * @return the api_token
	 */
	public String getApi_token() {
		return api_token;
	}
	/**
	 * @param api_token the api_token to set
	 */
	public void setApi_token(String api_token) {
		this.api_token = api_token;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "{\"args\": {\"uid\":" + uid + ", \"token\":" + "\""+ token +"\"" + ", \"api_token\":" + "\""+ api_token + "\""+ "}}";
	}
	
	
	
}
