package com.hostfully.booking.entities;

import com.hostfully.framework.entitybase.Identity;
import com.hostfully.modules.booking.domain.entity.Booking;
import com.hostfully.modules.booking.domain.enums.BookingState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor()
@Table(name = "bookings")
@NoArgsConstructor
@Getter
public class BookingEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column private LocalDate startDate;

  @Column private LocalDate endDate;

  @Enumerated(EnumType.STRING)
  private BookingState state;

  @Column private Long propertyId;

  @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "guest_id")
  private GuestEntity guest;

  public static BookingEntity from(Booking booking) {
    return new BookingEntity(
        IdentityMapper.mapId(booking.getId()),
        booking.getStartDate(),
        booking.getEndDate(),
        booking.getState(),
        booking.getPropertyId(),
        GuestEntity.from(booking.getGuest()));
  }

  public Booking fromThis() {
    return Booking.builder()
        .id(new Identity(id))
        .startDate(startDate)
        .endDate(endDate)
        .state(state)
        .propertyId(propertyId)
        .guest(guest.fromThis())
        .build();
  }
}
