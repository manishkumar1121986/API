package com.api.common.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class BaseException extends RuntimeException{


	private static final long serialVersionUID = -8209179604319309999L;

	private Throwable cause = null;
	private List<Exception> exceptions = new ArrayList<Exception>();
    private String messageKey= null;
    private Object[] messageArgs = null;
    private String strExceptionNumber;

	public BaseException(){
		super("Error occurred in application.");
		setStrExceptionNumber();
	}

	public BaseException(String errorDescription){
		super(errorDescription);
		setStrExceptionNumber();
	}

    public BaseException(Throwable cause)  {
    	super("Error occurred in application.");
    	setStrExceptionNumber();
        this.cause = cause;
    }

    public BaseException(String errorDescription, Throwable cause)  {
        super(errorDescription);
        this.cause = cause;
    }

    public List<Exception> getExceptions() {
		   return exceptions;
	   }

	   public void addException(BaseException ex) {
		   exceptions.add(ex);
	   }

	   public void setMessageKey(String key) {
		   this.messageKey = key;
	   }

	   public String getMessageKey() {
		   return messageKey;
	   }
	   
	   public void setMessageArgs(Object[] args) {
           if(args != null){
                  this.messageArgs = Arrays.copyOf(args, args.length);
           }
	   }

	   public Object[] getMessageArgs() {
		   return messageArgs;
	   }

	   public void setCause(Throwable anException) {
		   cause = anException;
	   }

	   public Throwable getCause() {
	   	   return cause;
	   }

	   public void printStackTrace() {
		   printStackTrace(System.err);
	   }

	   public void printStackTrace(PrintStream outStream) {
        printStackTrace(new PrintWriter(outStream));
	   }

	   public void printStackTrace(PrintWriter writer) {
		   super.printStackTrace(writer);

		   if (getCause() != null) {
			   getCause().printStackTrace(writer);
		   }
		   writer.flush();
	   }

	   public String generateExceptionNumber() {
	          Calendar calender=Calendar.getInstance();
	          String strExceptionNumber=calender.get(Calendar.MONTH)+1+"-"+calender.get(Calendar.DATE)+"-"+calender.get(Calendar.YEAR)+":"+
	        		  calender.get(Calendar.HOUR_OF_DAY)+"-"+calender.get(Calendar.MINUTE)+"-"+calender.get(Calendar.SECOND)+":"+new Random().nextInt(10000);
	      return strExceptionNumber;
	    }

		  public String toString(){
			  return getClass().getName()+": "+this.getMessage()+" Exception No : "+this.getStrExceptionNumber();
		  }

		public String getStrExceptionNumber() {
			return strExceptionNumber;
		}

		private void setStrExceptionNumber() {
			this.strExceptionNumber = generateExceptionNumber();
		}





}
