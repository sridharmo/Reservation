package com.example.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Reservation")
public class Reservation {

		@Id
		@GeneratedValue(strategy=GenerationType.SEQUENCE)
		@Column
		private int reservationId;
		@NotNull(message="Should not be null")
		private String firstName;
		private String lastName;
		private Date date;
		private String origin;
		private String destination;
		public int getReservationId() {
			return reservationId;
		}
		public void setReservationId(int reservationId) {
			this.reservationId = reservationId;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public String getOrigin() {
			return origin;
		}
		public void setOrigin(String origin) {
			this.origin = origin;
		}
		public String getDestination() {
			return destination;
		}
		public void setDestination(String destination) {
			this.destination = destination;
		}
		public Reservation(int reservationId, String firstName, String lastName, Date date, String origin,
				String destination) {
			super();
			this.reservationId = reservationId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.date = date;
			this.origin = origin;
			this.destination = destination;
		}
		public Reservation() {}
		@Override
		public String toString() {
			return "ReservationDTO [reservationId=" + reservationId + ", firstName=" + firstName + ", lastName="
					+ lastName + ", date=" + date + ", origin=" + origin + ", destination=" + destination + "]";
		}
		
		
		
}
