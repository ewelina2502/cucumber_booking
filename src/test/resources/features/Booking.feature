Feature: Booking tests

  @CreateBooking
  Scenario: Get all bookings
    Given Get booking
    Then Status code: 200

  @CreateBooking
  @DeleteBooking
  Scenario: Post booking with random body
    Given Add body with random parameters
    When Post booking with RANDOM_BODY
    Then Status code: 200

  Scenario Outline: Post three bookings with datas from outline
    Given Add firstname: "<firstname>", lastname: "<lastname>", totalprice: <totalprice>, depositpaid: "<depositpaid>", checkin: <checkin>, checkout: <checkout>, additionalneeds: <additionalneeds>
    When Post booking
    Then Status code: 200
    Examples:
      | firstname | lastname | totalprice | depositpaid | checkin | checkout | additionalneeds |
      | RANDOM    | RANDOM   | RANDOM     | false       | TODAY   | TOMORROW | RANDOM          |
      | RANDOM    | RANDOM   | RANDOM     | true        | RANDOM  | RANDOM   | RANDOM          |
      | RANDOM    | RANDOM   | RANDOM     | false       | RANDOM  | TODAY    | RANDOM          |

  @CreateBooking
  Scenario: Delete post booking
    And Get EXIST from booking
    And Delete booking
    Then Status code: 201

  @CreateBooking
  @DeleteBooking
  Scenario: Put existing booking
    And Booking with random parameters firstname: "RandomFristName", lastname: "RandomFristName"
    When Put EXIST booking
    Then Status code: 200

  @CreateBooking
  @DeleteBooking
  Scenario: Patch existing booking
    And Booking with random parameters firstname: "RandomFristName", lastname: "RandomFristName"
    When Patch EXIST booking
    Then Status code: 200
