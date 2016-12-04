package com.capitolone.cua.service.client;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public abstract class AServiceClient {
	
	@Value("${user.userId}")
	private String userId;
	@Value("${user.token}")
	private String token;
	@Value("${api.token}")
	private String apiToken;
	@Value("${json.strict.mode:true}")
	private Boolean jsonStrictMode;
	@Value("${json.verbose.mode:true}")
	private Boolean jsonVerboseResponse;
	
	protected RestTemplate serviceClient;

	@PostConstruct
	public void init() throws Exception {
		serviceClient = new RestTemplate();
	}
	protected HttpHeaders setHeaders()
	{
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept",MediaType.APPLICATION_JSON_VALUE);
		headers.setContentType(MediaType.APPLICATION_JSON);
//		headers.add("uid", userId);
//		headers.add("token", token);
//		headers.add("api-token", "AppTokenForInterview");
//		headers.add("json-strict-mode", jsonStrictMode.toString());
//		headers.add("json-verbose-response", jsonVerboseResponse.toString());
		//headers.setContentType(MediaType.APPLICATION_JSON_VALUE);
		return headers;
	}

	protected static String getUrl(String endPoint, String resource) {
		String url = "";
		if (StringUtils.isNotBlank(endPoint)) {
			url = endPoint + "/" + resource;
			url = StringUtils.replacePattern(url, "//", "/");
			url = StringUtils.replaceOnce(url, "/", "//");
		}
		return url;
	}
}
