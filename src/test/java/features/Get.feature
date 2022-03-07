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
    | Adam      | Nowak    | 123        | 1234        |2021-01-21 | 2022-01-23 | Breakfast       |

