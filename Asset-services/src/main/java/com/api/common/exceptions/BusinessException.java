package com.api.common.exceptions;

public class BusinessException extends BaseException{

	/**
	 *
	 */
	private static final long serialVersionUID = 5777739128355815491L;

	public BusinessException(){
		super();
	}

	public BusinessException(String errorDescription){
		super(errorDescription);
	}

   public BusinessException(String errorDescription, Throwable cause)  {
        super(errorDescription,cause);

    }
   
   public BusinessException(Exception e){
		super(e);
	}
}
