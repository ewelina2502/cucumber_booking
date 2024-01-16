Feature: Booking tests

  @CreateBooking
  Scenario: Get all bookings
    Given Get booking
    Then Status code: 200

  @CreateBooking
  @DeleteBooking
  Scenario: Post booking
    Given Add body with random parameters
    When Post booking with RANDOM_BODY
    Then Status code: 200

  Scenario Outline: Post booking with datas
    Given Add firstname: "<firstname>", lastname: "<lastname>", totalprice: "<totalprice>", depositpaid: "<depositpaid>", checkin: <checkin>, checkout: <checkout>, additionalneeds: "<additionalneeds>"
    When Post booking
    Then Status code: 200
    Examples:
      | firstname | lastname | totalprice | depositpaid | checkin | checkout | additionalneeds |
      | Adam      | Nowak    | 123        | true        | RANDOM  | TOMORROW | Breakfast       |
      | Ada       | Nowa     | 124        | false       | TODAY   | TOMORROW | Lunch           |
      | Magda     | Kowal    | 125        | false       | RANDOM  | RANDOM   | Lunch           |

  @CreateBooking
  Scenario: Delete post booking
    And Get EXIST from booking
    And Delete booking
    Then Status code: 201

  @CreateBooking
  @DeleteBooking
  Scenario: Put booking
    And Booking with random parameters firstname: "RandomFristName", lastname: "RandomFristName"
    When Put EXIST booking
    Then Status code: 200

  @CreateBooking
  @DeleteBooking
  Scenario: Patch booking
    And Booking with random parameters firstname: "RandomFristName", lastname: "RandomFristName"
    When Patch EXIST booking
    Then Status code: 200
