package com.swift.example.action;

import java.util.Date;
import java.util.Map;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.inject.Inject;
import com.swift.example.dto.Email;
import com.swift.example.mailer.Mailer;
import com.swift.example.model.User;
import com.swift.example.service.UserService;

public class LoginAction extends ActionSupport implements ModelDriven<User>, SessionAware {
	
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(LoginAction.class.getName());
	
	@Inject("users")
	private UserService userService;
	@Inject("mailer")
	private Mailer mailer;
	private User user = new User();
	private Map<String, Object> session;
	private String email;
	
	// Instance Variables for form submission
	private String user_name;
	private String pass_word;
	private String rePassword;
	private String recaptcha_challenge_field;
	private String recaptcha_response_field;
	
	public String login() {
		if(userService.verifyUser(user)) {
			this.session.put("loggedInUser", user.getUsername());
			return SUCCESS;
		}
		addFieldError("username", "Invalid Username and Password...");
		return LOGIN;
	}
	
	public String logout() {
		log.info("Logged out successfully...");
		this.session.remove("loggedInUser");
		return SUCCESS;
	}
	
	public String forgotPassword() {
		return SUCCESS;
	}
	
	public String sendPassword() {
		log.info("Sending Password....");
		User user = userService.getUser(this.getEmail().trim());
		if(user == null) {
			addActionError("User not found with given email address.");
			return ERROR;
		}
		Email email = new Email();
		email.setTo(this.getEmail());
		email.setSubject("Forgot Password...");
		email.setMessage("Your Password: <strong>" + user.getPassword() + "</strong>");
		mailer.sendMail(email);
		addActionMessage("Your Password has been sent to your email address now.");
		return SUCCESS;
	}
	
	public String signUp() {
		return SUCCESS;
	}
	
	public String registerUser() {
		String remoteAddr = ServletActionContext.getRequest().getRemoteAddr();
		ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
		reCaptcha.setPrivateKey("6LfAiuMSAAAAAM3s9whwil_kWlbYywhth3o2P1H7");
		ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, recaptcha_challenge_field, recaptcha_response_field);
		boolean valid = reCaptchaResponse.isValid();
		log.info("Username: " + this.getUser_name());
		log.info("Password: " + this.getPass_word());
		log.info("Re-Password: " + this.getRePassword());
		
		// Check User for unique username.
		if(checkUser(this.getUser_name().toLowerCase().trim())) {
			addActionError("You have already been registered with this ID.");
			return ERROR;
		}
		
		// Check both password and re-password for verification.
		if(!checkPassword(this.getPass_word(), this.getRePassword())) {
			addActionError("Password and re-type password doesn't match to each other.");
			return ERROR;
		}
		if(valid) {
			user.setUsername(this.getUser_name().toLowerCase().trim());
			user.setPassword(this.getPass_word().trim());
			user.setCreated_on(new Date());
			userService.addUser(user);
			addActionMessage("Congratulations! you have been successfully registered.");
			return SUCCESS;
		} else {
			addActionError("Captcha Mismatched! Try Again");
			return ERROR;
		}
	}
	
	private boolean checkPassword(String p1, String p2) {
		if(p1.equals(p2)) {
			return true;
		}
		return false;
	}
	
	private boolean checkUser(String u1) {
		log.info("Username: " + u1);
		User user = userService.getUser(u1);
		if(user != null) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public User getModel() {
		return user;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public Map<String, Object> getSession() {
		return session;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPass_word() {
		return pass_word;
	}

	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public String getRecaptcha_challenge_field() {
		return recaptcha_challenge_field;
	}

	public void setRecaptcha_challenge_field(String recaptcha_challenge_field) {
		this.recaptcha_challenge_field = recaptcha_challenge_field;
	}

	public String getRecaptcha_response_field() {
		return recaptcha_response_field;
	}

	public void setRecaptcha_response_field(String recaptcha_response_field) {
		this.recaptcha_response_field = recaptcha_response_field;
	}
}
