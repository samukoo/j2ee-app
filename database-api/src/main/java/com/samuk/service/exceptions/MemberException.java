package com.samuk.service.exceptions;

public class MemberException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String firstname=null;
	private String lastname=null;
	
	
	public MemberException(String firstname, String lastname){
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public String errorMsg(){
		return error(defineError(this.firstname, this.lastname));
	}
	
	private String error(String cause){
		return cause + " should not be null, please define " + cause;
	}
	
	private String defineError(String f, String l){
		if(l==null){
			return "lastname";
		}else{
			return "firstname";
		}
	}
}
