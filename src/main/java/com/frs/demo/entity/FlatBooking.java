package com.frs.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity

@Table(name="flatbooking_TBL")

public abstract class FlatBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bookingNo")
	private int	bookingNo;
	
	@Column(name="bookingFromDate")
    private LocalDate bookingFromDate;
	
	@Column(name="bookingToDate")
	private LocalDate bookingToDate;
	
	@OneToOne
	@JoinColumn(name= "tenant_id",referencedColumnName="tenantid")
	private Tenant tenantid;
	
	
	public FlatBooking(Tenant tenantid) {
		super();
		this.tenantid = tenantid;
	}
	public Tenant getTenantid() {
		return tenantid;
	}
	public void setTenantid(Tenant tenantid) {
		this.tenantid = tenantid;
	}
	public FlatBooking() {
		
		// TODO Auto-generated constructor stub
	}
	public FlatBooking(int bookingNo, LocalDate bookingFromDate, LocalDate bookingToDate) {
		super();
		this.bookingNo = bookingNo;
		this.bookingFromDate = bookingFromDate;
		this.bookingToDate = bookingToDate;
	}
	public int getBookingNo() {
		return bookingNo;
	}
	public void setBookingNo(int bookingNo) {
		this.bookingNo = bookingNo;
	}
	public LocalDate getBookingFromDate() {
		return bookingFromDate;
	}
	public void setBookingFromDate(LocalDate bookingFromDate) {
		this.bookingFromDate = bookingFromDate;
	}
	public LocalDate getBookingToDate() {
		return bookingToDate;
	}
	public void setBookingToDate(LocalDate bookingToDate) {
		this.bookingToDate = bookingToDate;
	}
}