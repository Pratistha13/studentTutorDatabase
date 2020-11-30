package com.example.studentTutorDatabase.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ContactController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping("/contact")
	public String showContactForm() {
		
		return "contact_form";
	}
	
	@PostMapping("/contact")
	public String submitContact(HttpServletRequest request,
			@RequestParam("attachment") MultipartFile multipartFile
			) throws MessagingException, UnsupportedEncodingException {
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message,true);
		
		String mailSubject = fullname + " has sent a message";
		String mailContent = "<p><b>Sender Name: </b>"+ fullname + "</p>";
		mailContent += "<p><b>Sender E-mail: </b>"+ email + "</p>";
		mailContent += "<p><b>Subject: </b>"+ subject + "</p>";
		mailContent += "<p><b>Content: <b>"+ content + "</p>";
		
		helper.setFrom("contact@studenttutor.com", "Student Tutor Org");
		helper.setTo("student.tutordatabase@gmail.com");
				
		helper.setSubject(mailSubject);
		helper.setText(mailContent, true);
		
		if(!multipartFile.isEmpty()) {
			String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
			
			InputStreamSource source = new InputStreamSource() {
				
				@Override
				public InputStream getInputStream() throws IOException{
					
					return multipartFile.getInputStream();
				}
				
			};
			
			 helper.addAttachment(fileName, source);
		}
		
		
		mailSender.send(message);
		
		
		return "message";
	}

}
