package com.api.common.exceptions;

public class ServiceRequestException extends BaseException{


	/**
	 *
	 */
	private static final long serialVersionUID = -4705480510633180689L;

	public ServiceRequestException(){
		super();
	}

	public ServiceRequestException(String errorDescription){
		super(errorDescription);
	}

   public ServiceRequestException(String errorDescription, Throwable cause)  {
        super(errorDescription,cause);

    }
   public ServiceRequestException(Exception e){
		super(e);
	}
}
