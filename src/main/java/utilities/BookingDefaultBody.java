package utilities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookingDefaultBody {
    @Builder.Default
    private String firstname = "DefaultFirstName";
    @Builder.Default
    private String lastname = "DefaultLastName";
    @Builder.Default
    private String totalprice = String.valueOf(Faker.getRandomPrice());
    @Builder.Default
    private String depositpaid = "true";
    private BookingDatesBody bookingdates;
    @Builder.Default
    private String additionalneeds = "DefaultAdditionalneeds";
}
