package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_coupon")
public class CouponCode extends BaseEntity {

	private String maCode;
	@DateTimeFormat(pattern = "dd-MM-yyyy hh:mm:ss")
	private Date ngayBatDau;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy hh:mm:ss")
	private Date ngayKetThuc;
	
	private String phanTram;
}
