package com.example.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.Reservation;
public interface ReservationRepository extends JpaRepository<Reservation,Object>{
	
	@Query("select reservation from Reservation reservation where reservation.reservationId =:reservationId")
	public Reservation getOne(@Param("reservationId")Integer reservationId);

	public List<Reservation> getByFirstName(String firstName);
	
	@Modifying
	@Query("update Reservation R set R.firstName =:firstName,R.lastName=:lastName where R.reservationId=:reservationId")
	public int update(@Param("firstName")String firstName,@Param("lastName")String lastName,@Param("reservationId")Integer reservationId);
}
