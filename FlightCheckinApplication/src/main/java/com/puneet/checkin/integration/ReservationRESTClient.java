package com.puneet.checkin.integration;

import com.puneet.checkin.integration.dto.Reservation;
import com.puneet.checkin.integration.dto.ReservationUpdateRequest;

public interface ReservationRESTClient {
	
	public Reservation findReservation(Long id);
	
	public Reservation updateReservation(ReservationUpdateRequest request);
	

}
