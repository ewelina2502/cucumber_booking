Feature:
  Scenario: getBookings
    Given Get booking
    When I use get in request
    Then I will get bookings

  Scenario: postBookingWithJson
    Given Add parameters
    Then I have booking


  Scenario Outline: postBookingWithDatas
    Given Add dates
    When Add "<firstname>" "<lastname>" "<totalprice>" "<depositpaid>" "<checkin>" "<checkout>" "<additionalneeds>"
    Then Booking is added
    Examples:
    | firstname | lastname | totalprice | depositpaid  |checkin    | checkout   | additionalneeds |
    | Adam      | Nowak    | 123        | true         |2021-01-21 | 2022-01-23 | Breakfast       |
    | Ada       | Nowa     | 124        | false        |2022-01-21 | 2022-01-23 | Lunch           |
    | Magda     | Kowal    | 125        | false        |2023-03-23 | 2024-04-24 | Lunch           |

