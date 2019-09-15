package com.example.demo.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="Bundles")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, name = "Product_ID")
	private int pid;
	
	@NotEmpty(message = "Name may not be empty")
	@Size(min = 1, max = 100, message = "Name must be between 1 and 100 characters long") 
	@Column(name = "Product_Name")
	private String pname;
	
	@Column(nullable = false, name = "Product_Price")
	@Range(min=0,message = "Price may not be empty")
	private BigDecimal pprice;

	@NotNull(message = "Product code may not be empty")
	@Column(name = "Product_Code")
	private Integer pcode;
	

	@Column(name = "Product_Expiration_Date")
	private Date expdate;
	
	@NotNull(message = "Availability date may not be empty")
	@Column(name = "Product_Availability_Date")
	private Date availdate;

	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public BigDecimal getPprice() {
		return pprice;
	}

	public void setPprice(BigDecimal pprice) {
		this.pprice = pprice;
	}

	public Integer getPcode() {
		return pcode;
	}

	public void setPcode(Integer pcode) {
		this.pcode = pcode;
	}

	public Date getExpdate() {
		return expdate;
	}

	public void setExpdate(Date expdate) {
		this.expdate = expdate;
	}

	public Date getAvaildate() {
		return availdate;
	}

	public void setAvaildate(Date availdate) {
		this.availdate = availdate;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pprice=" + pprice + ", pcode=" + pcode + ", expdate="
				+ expdate + ", availdate=" + availdate + "]";
	}

	
	
	
}
