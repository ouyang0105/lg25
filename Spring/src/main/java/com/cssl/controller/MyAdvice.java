package com.cssl.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;

import com.cssl.vo.UsersVo;

/**
 * 切面业余类
 * @author TYM
 *
 */
@ControllerAdvice
public class MyAdvice {
	
	/*@InitBinder
	public void convert(DataBinder binder) {
		System.out.println("@InitBinder");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf,true));
	}*/
	
	/**
	 * 异常增强：只针对控制器
	 * @param e
	 * @return
	 */
	/*@ExceptionHandler(Exception.class)
	public String doException(Exception e) {
		System.out.println("全局 Exception:"+e.getMessage());
		return "error";
	}*/
	
	//@ModelAttribute
	public UsersVo getModel(UsersVo uvo) {
		System.out.println("getModel:"+uvo);
		uvo.setUsername("匿名用户");
		return uvo;
	}

}
