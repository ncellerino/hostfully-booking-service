package com.hostfully.booking.entities;

import com.hostfully.framework.entitybase.Identity;
import com.hostfully.modules.booking.domain.entity.Guest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor()
@Table(name = "guests")
@NoArgsConstructor
@Getter
public class GuestEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column private String firstName;
  @Column private String lastName;
  @Column private String phone;
  @Column private String email;

  public static GuestEntity from(Guest guest) {
    return new GuestEntity(
        IdentityMapper.mapId(guest.getId()),
        guest.getFirstName(),
        guest.getLastName(),
        guest.getPhone(),
        guest.getEmail());
  }

  public Guest fromThis() {
    return Guest.builder()
        .id(new Identity(id))
        .firstName(firstName)
        .lastName(lastName)
        .phone(phone)
        .email(email)
        .build();
  }
}
