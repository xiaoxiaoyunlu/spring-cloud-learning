package com.test1.demo.web;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test1.demo.exception.MyRestException;
import com.test1.demo.exception.MyWebException;

/**
 * controller 增强器
 *
 * @author sam
 * @since 2017/7/17
 */
@ControllerAdvice
public class MyControllerAdvice {
	
	
	public static final String DEFAULT_ERROR_VIEW = "error";
	 @ExceptionHandler(value =MyRestException .class)
	 @ResponseBody
	 public ResponseEntity defaultErrorHandler(HttpServletRequest req, MyRestException e) throws Exception {
	  return ResponseEntity.ok("ok");
	 }
	 @ExceptionHandler(value = Exception.class)
	 public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e,HttpServletResponse resp) throws Exception {
	  ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);
	  mav.addObject("status", resp.getStatus());
	  mav.addObject("message", e.getMessage());
	  mav.addObject("error", e.toString());
	  mav.addObject("url", req.getRequestURL());
	  mav.addObject("timestamp", System.currentTimeMillis());
	  return mav;
	 }

}