package com.example.demo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BranchDTO {

	private String name;
	private String nameCode;
	private Boolean status;
	private String logo;
	private Date createdDate;
	private Date modifiedDate;


}
