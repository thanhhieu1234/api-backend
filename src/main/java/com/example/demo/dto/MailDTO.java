package com.example.demo.dto;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailDTO {

	private String to;
	private String subject;
	private String content;
	private Map<String, Object> gross = new HashMap<>(); 

}
