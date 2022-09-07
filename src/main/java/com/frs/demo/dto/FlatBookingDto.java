package com.frs.demo.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
@Table(name="flat_tbl")
public class FlatBookingDto {

	@Id
	@Column(name="bookingNo")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int	bookingNo;
	
	@Column(name="fromdate")
	@NotNull
	@JsonFormat(pattern = "MM/dd/yyyy")
	 private LocalDate bookingFromDate;
	
	@Column(name="todate")
	@NotNull
	@JsonFormat(pattern = "MM/dd/yyyy")
	 private LocalDate bookingToDate;
	
	public FlatBookingDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FlatBookingDto(int bookingNo, LocalDate bookingFromDate, LocalDate bookingToDate) {
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
