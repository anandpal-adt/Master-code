package com.amazin.nayra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazin.nayra.model.EmailDetails;
import com.amazin.nayra.service.EmailService;


@RestController
public class EmailController {

	@Autowired
	EmailService emailService;

	@PostMapping("/sendMail")
	public ResponseEntity<String> sendMail(@RequestBody EmailDetails emailDetails) {

		return new ResponseEntity<>(emailService.sendSimpleMail(emailDetails), HttpStatus.OK);
	}

}
