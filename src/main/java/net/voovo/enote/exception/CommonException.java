package net.voovo.enote.exception;

/**
 */
public class CommonException extends BusinessException {
	private static final long serialVersionUID = -5977333208013131624L;

	private int code = 702;
	
	
	public CommonException(String msg, Throwable cause)  {
		super(msg,cause);
	}
	

	public CommonException(CommonExceptionEnum exceptionEnum){
		super(exceptionEnum.getMessage());
		this.code = exceptionEnum.getCode();
	}
	public CommonException(UpmsExceptionEnum exceptionEnum){
		super(exceptionEnum.getMessage());
		this.code = exceptionEnum.getCode();
	}
	

	@Override
	public Integer getCode() {
		return this.code;
	}

}
