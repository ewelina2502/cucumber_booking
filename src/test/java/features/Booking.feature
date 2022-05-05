Feature:
  Scenario: getBookings
    Given Get booking
    When I use get in request
#    Then I will get bookings
  Then Booking is added

  Scenario: postBookingWithJson
    Given Add parameters
    Then Booking is exist

  Scenario Outline: postBookingWithDatas
    Given Add dates
    When Add "<firstname>" "<lastname>" "<totalprice>" "<depositpaid>" "<checkin>" "<checkout>" "<additionalneeds>"
    Then Booking is added
    Examples:
    | firstname | lastname | totalprice | depositpaid  |checkin    | checkout   | additionalneeds |
    | Adam      | Nowak    | 123        | true         |2021-01-21 | 2022-01-23 | Breakfast       |
    | Ada       | Nowa     | 124        | false        |2022-01-21 | 2022-01-23 | Lunch           |
    | Magda     | Kowal    | 125        | false        |2023-03-23 | 2024-04-24 | Lunch           |

  Scenario: usedBadUrl
    Given Add bad url
    Then I have response bad request

  Scenario: postAndPutBooking
    Given Add parameters
    And Booking is exist
    When I put firstname and add cookies and authorization
    Then Booking has a new firstname

  Scenario: postPutAndDeleteBooking
    Given Add parameters
    And Booking is exist
    When I find Booking and Delete
    Then I have response not found Booking
