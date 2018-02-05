package com.test1.demo.exception;
/**
 * @author sam
 * @since 2017/7/17
 */
public class MyRestException extends RuntimeException {

    public MyRestException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

    
}