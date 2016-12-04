package com.capitolone.cua.service.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.capitolone.cua.service.request.Args;
import com.capitolone.cua.service.request.ServiceRequest;
import com.capitolone.cua.service.response.ServiceResponse;


@Component
public class COServiceClient extends AServiceClient{

	@Value("${end.point}")
	String END_POINT;
	@Value("${all.transactions}")
	String RESOURCE;

	//	@Inject
	//	Args args;
	//	@Inject
	//	ServiceRequest body;

	private ServiceResponse callService(String END_POINT, String url, Class<? extends ServiceResponse> responseClass){
		ServiceResponse response = null;
		try{
			//String body = "{\"args\": {\"uid\": 1110590645, \"token\": \"4B94994902CC4675544C3901289C3FDA\", \"api-token\": \"AppTokenForInterview\"}}";
			System.out.println("Body :: " + setRequestBody().toString());
			HttpEntity<Object> entityRequest = new HttpEntity<Object>(setRequestBody().toString(), setHeaders());

			System.out.println("Entity Request :: " + entityRequest.getBody());
			ResponseEntity<ServiceResponse> responseString = serviceClient.exchange (url,HttpMethod.POST, entityRequest, ServiceResponse.class);
			System.out.println(responseString.getBody());
			response = responseString.getBody();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		return response;
	}

	public ServiceRequest setRequestBody(){
		Args args = new Args();
		args.setUid("1110590645");
		args.setToken("4B94994902CC4675544C3901289C3FDA");
		args.setApi_token("AppTokenForInterview");
		ServiceRequest body = new ServiceRequest();
		body.setArgs(args);
		return body;
	}

	public ServiceResponse getTransactions(Class<? extends ServiceResponse> responseClass){
		return callService(END_POINT,getUrl(END_POINT, RESOURCE), responseClass);
	}
}
