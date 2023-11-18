package com.hostfully.modules.booking.features.booking;

import com.hostfully.modules.booking.domain.enums.BookingState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class BookingDTO {

    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private BookingState state;
    private Long propertyId;
    private GuestDTO guest;
}
