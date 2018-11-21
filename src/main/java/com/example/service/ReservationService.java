package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Reservation;
import com.example.repository.ReservationRepository;

@Service
public class ReservationService {
	@Autowired
	ReservationRepository reservationRepository;

	public Reservation createReservation(Reservation reservation) {
		Reservation reservationDTO = null;
		if (reservation != null)
			reservationDTO = reservationRepository.save(reservation);
		return reservationDTO;
	}

	public Reservation getReservationById(Integer reservationId) {

		return reservationRepository.getOne(reservationId);

	}

	public List<Reservation> getAllReservations() {
		List<Reservation> reservationDTO = null;

		reservationDTO = reservationRepository.findAll();
		return reservationDTO;
	}
	
	public Reservation updateReservation(Integer reservationId,Reservation reservationDTO) {
		Reservation reservation = reservationRepository.getOne(reservationId);
		if(reservation == null)
			return reservation;
		else {
			/*reservationDTO = reservationRepository.save(reservationDTO);*/
			reservationRepository.update(reservationDTO.getFirstName(), reservationDTO.getLastName(), reservationId);
		}			
		return reservationDTO;		
	}

}
