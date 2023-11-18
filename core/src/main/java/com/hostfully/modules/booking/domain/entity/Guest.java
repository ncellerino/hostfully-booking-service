package com.hostfully.modules.booking.domain.entity;

import com.hostfully.framework.entitybase.Identity;
import lombok.Builder;
import lombok.Value;
import org.apache.commons.lang3.StringUtils;

@Value
@Builder
public class Guest {
  private final Identity id;
  private final String firstName;
  private final String lastName;
  private final String phone;
  private final String email;

  public Guest update(String newFirstName, String newLastName, String newPhone) {
    GuestBuilder builder =
        Guest.builder().id(id).firstName(firstName).lastName(lastName).phone(phone).email(email);
    if (StringUtils.isNotBlank(newFirstName)) {
      builder.firstName(newFirstName);
    }

    if (StringUtils.isNotBlank(newLastName)) {
      builder.lastName(newLastName);
    }

    if (StringUtils.isNotBlank(newPhone)) {
      builder.phone(newPhone);
    }

    return builder.build();
  }
}
