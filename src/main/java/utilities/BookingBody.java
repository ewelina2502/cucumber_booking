package utilities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
//@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingBody {
        @Builder.Default
        private String firstname = Faker.getFistname();
        @Builder.Default
        private String lastname = Faker.getLastname();
        @Builder.Default
        private String totalprice = String.valueOf(Faker.getRandomPrice());
        @Builder.Default
        private String depositpaid = "true";
        private BookingDatesBody bookingdates;
        @Builder.Default
        private String additionalneeds = Faker.getRandomAdditinalNeeds();

//        @Override
//        public String toString() {
//                return Helper.serializeToJson(this);
//        }
}

