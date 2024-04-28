package com.api.common.exceptions;

public class DAOException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4537941529005839436L;

	public DAOException(){
		super();
	}

	public DAOException(String errorDescription){
		super(errorDescription);
	}

   public DAOException(String errorDescription, Throwable cause)  {
        super(errorDescription,cause);

    }
   
   public DAOException(Exception e){
		super(e);
	}

   
}
