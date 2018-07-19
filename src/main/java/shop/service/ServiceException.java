package shop.service;

public class ServiceException extends RuntimeException{

	public ServiceException(String message){
		super(message);
	}
	
	public ServiceException(String message,Exception ex){
		super(message,ex);
	}
}
