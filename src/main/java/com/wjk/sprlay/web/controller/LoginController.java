package com.wjk.sprlay.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wjk.sprlay.web.model.User;
import com.wjk.sprlay.web.vo.ResultData;

/**
 * 
 * @ClassName:  LoginController   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: WangJKui
 * @date:   2019年1月18日 上午9:46:46   
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	private static Logger logger = LoggerFactory.getLogger(LoginController.class); 

	/**
	 * 
	 * @Title: toLogin   
	 * @Description: 登录页   
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	@RequestMapping("/tologin")
	public String toLogin() {
		return "views/login/login";
	}

	/**
	 * @Title: login   
	 * @Description: 登录操作 
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public Object login(@RequestBody User user) {

		logger.debug(user.toString());;

		Subject subject = SecurityUtils.getSubject();
		// 此处的密码应该是按照后台的加密规则加密过的，不应该传输明文密码
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());

		try {
			subject.login(token);
		} catch (UnknownAccountException e) {
			logger.error(e.getMessage());
			return new ResultData(1,"用户名或密码错误!");
		} catch (IncorrectCredentialsException e) {
			logger.error(e.getMessage());	
			return new ResultData(1,"用户名或密码错误!");
		} catch (AuthenticationException e) {
			//其他错误，比如锁定，如果想单独处理请单独catch处理
			logger.error("其他错误");
			logger.error(e.getMessage());
			return new ResultData(1,"其他错误!，请重新登录");
		}catch (Exception e) {
			logger.error(e.getMessage());
			return new ResultData(1,"系统错误!，请重新登录");
		}
		return new ResultData();
	}


	/**
	 * 
	 * @Title: logout   
	 * @Description: 登出
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	@RequestMapping("/logout")
	public String logout() {

		Subject subject = SecurityUtils.getSubject();

		subject.logout();

		return "views/login/login";
	}
}
