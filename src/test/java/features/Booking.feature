Feature:
  Scenario: getBookings
    Given Get booking
    When I use get in request
    Then I will get bookings

    Scenario: postBookingHash
      Given Add parameters
      Then I have booking

  Scenario Outline: postBookingWithDatas
    Given Add dates
    When Add "<firstname>" "<lastname>" "<totalprice>" "<depositpaid>" "<checkin>" "<checkout>" "<additionalneeds>"
    Then Booking is added
    Examples:
    | firstname | lastname | totalprice | depositpaid |checkin    | checkout   | additionalneeds |
    | Adam      | Nowak    | 123        | True        |2021-01-21 | 2022-01-23 | Breakfast       |

