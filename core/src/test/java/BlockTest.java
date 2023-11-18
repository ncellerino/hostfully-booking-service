import com.hostfully.modules.booking.domain.entity.Block;
import com.hostfully.modules.booking.domain.exceptions.InvalidDateRangeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class BlockTest {
  @Test
  public void oldDateThrowsInvalidDateRangeException() {

    LocalDate oldDate = LocalDate.of(2003, 4, 1);

    Assertions.assertThrows(
        InvalidDateRangeException.class,
        () -> {
          Block.newInstance(oldDate, LocalDate.now(), 1L, 1L);
        });
  }

  @Test
  public void endDateBeforeStartDateThrowsInvalidDateRangeException() {

    LocalDate startDate = LocalDate.of(2003, 4, 1);
    LocalDate endDate = LocalDate.of(2003, 3, 1);

    Assertions.assertThrows(
        InvalidDateRangeException.class,
        () -> {
          Block.newInstance(startDate, endDate, 1L, 1L);
        });
  }
}
