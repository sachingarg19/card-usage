package com.capitolone.cua.service.request;


public class ServiceRequest {
	
	private Args args;

	/**
	 * @return the args
	 */
	public Args getArgs() {
		return args;
	}

	/**
	 * @param args the args to set
	 */
	public void setArgs(Args args) {
		this.args = args;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return args.toString();
	}
	
	
}
