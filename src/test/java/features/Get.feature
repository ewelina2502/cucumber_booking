Feature:
  Scenario: getBookings
    Given Get booking
    When I use get in request
    Then I will get bookings

  Scenario Outline: postBooking
    Given Add dates
    When Add <firstname> and <lastname> and <totalprice> and <depositpaid> and <checkin> and <checkout> and <additionalneeds>
    Then Booking is added
    Examples:
    | firstname | lastname | totalprice | depositpaid |checkin    | checkout   | additionalneeds |
    | Adam      | Nowak    | 123        | True        |2022-01-14 | 2022-01-15 | Breakfast       |



