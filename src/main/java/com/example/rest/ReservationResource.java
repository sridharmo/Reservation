package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Reservation;
import com.example.service.ReservationService;

@RestController
public class ReservationResource {
	
	@Autowired
	ReservationService reservationService;
	//create new reservation
	@RequestMapping(value="/reservation",method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservationDTO){
		Reservation reservation =null;
		reservation = reservationService.createReservation(reservationDTO);
		return new ResponseEntity<Reservation>(reservation,HttpStatus.CREATED);
		
	}
	
	/*@RequestMapping(value="/reservation/{firstName}",method=RequestMethod.GET,produces =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Reservation>> getReservationByFirstName(@PathVariable("firstName") String firstName ){
		List<Reservation> reservation = reservationService.getReservationById(firstName);
		if(reservation.size()>0)
			return new ResponseEntity<List<Reservation>>(reservation,HttpStatus.OK);
		else
			return new ResponseEntity<List<Reservation>>(reservation,HttpStatus.BAD_REQUEST);
	}*/
	
	
	@RequestMapping(value="/reservation/byreservationid/{reservationId}",method=RequestMethod.GET,produces =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Reservation> getReservationByFirstName(@PathVariable("reservationId") Integer reservationId ){
		Reservation reservation = reservationService.getReservationById(reservationId);
		if(reservation!=null)
			return new ResponseEntity<Reservation>(reservation,HttpStatus.OK);
		else
			return new ResponseEntity<Reservation>(reservation,HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/reservation/getall",method=RequestMethod.GET,produces =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Reservation>> getAllReservations(){
		List<Reservation> reservation = reservationService.getAllReservations();
		if(reservation!=null)
			return new ResponseEntity<List<Reservation>>(reservation,HttpStatus.OK);
		else
			return new ResponseEntity<List<Reservation>>(reservation,HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/reservation/update/{reservationId}",method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Reservation> updateReservation(@PathVariable("reservationId") Integer reservationId,@RequestBody Reservation reservationDTO){
		Reservation reservation =null;
		reservation = reservationService.updateReservation(reservationId,reservationDTO);
		if(reservation!=null)
			return new ResponseEntity<Reservation>(reservation,HttpStatus.OK);
		else
			return new ResponseEntity<Reservation>(reservation,HttpStatus.NOT_FOUND);		
	}
	//delete
	
}
