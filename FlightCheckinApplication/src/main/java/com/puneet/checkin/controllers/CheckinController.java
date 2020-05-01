package com.puneet.checkin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.puneet.checkin.integration.ReservationRESTClient;
import com.puneet.checkin.integration.dto.Reservation;
import com.puneet.checkin.integration.dto.ReservationUpdateRequest;

@Controller
public class CheckinController {
	
	@Autowired
	ReservationRESTClient reservationRESTClient;
	
	@RequestMapping("/showStartCheckin")
	public String showStartCheckIn () {
		return "startCheckIn";
	}
	
	@RequestMapping("/startCheckIn")
	public String startCheckIn(@RequestParam("reservationId") Long reservationId, ModelMap ModelMap) {
		Reservation reservation = reservationRESTClient.findReservation(reservationId);
		ModelMap.addAttribute("reservation" , reservation);
		return "displayReservationDetails";
	}
	
	@RequestMapping("/completeCheckIn")
	public String completeCheckIn(@RequestParam("reservationId") Long reservationId , @RequestParam("numberOfBags") int numberOfBags ) {
		ReservationUpdateRequest reservationUpdateRequest = new ReservationUpdateRequest();
		reservationUpdateRequest.setId(reservationId);
		reservationUpdateRequest.setCheckedIn(true);
		reservationUpdateRequest.setNumberOfags(numberOfBags);
		reservationRESTClient.updateReservation(reservationUpdateRequest);
		return "checkInConfirmation"; 
		
	}
	

}
