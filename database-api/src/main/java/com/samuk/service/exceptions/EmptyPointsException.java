package com.samuk.service.exceptions;

/**
 * Empty points exception is thrown when user tries to 
 * persist user commitment with no points
 */
public class EmptyPointsException extends Exception {

	private static final long serialVersionUID = 1L;
	private Long memberId;

	public EmptyPointsException(Long memberId){
		this.memberId = memberId;
	}

	public void printError(){
		System.out.println("member with id: " + memberId + " has no points");
	}
}
