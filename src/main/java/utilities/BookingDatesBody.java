package utilities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookingDatesBody {
    @Builder.Default
//        @JsonFormat(pattern = "yyyy-MM-dd")
    private String checkin = Faker.getTodaysDate();
    @Builder.Default
    private String checkout = Faker.getTomorrowDate();
}
