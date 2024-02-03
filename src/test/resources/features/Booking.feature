Feature: Booking tests

  @Cleaning
  @CreateBooking
  Scenario: Get all bookings
    Given Get bookings
    Then Status code: 200

  @DeleteBooking
  Scenario: Post booking with random body
    Given Add body with random parameters
    When Post booking with RANDOM_BODY to booking
    Then Status code: 200

    And Get EXIST id from booking
    Then Status code: 200

  @DeleteBooking
  Scenario: Post booking with default body
    Given Add body with default parameters
    When Post booking with DEFAULT_BODY to booking
    Then Status code: 200

    And Get EXIST id from booking
    Then Status code: 200

  @CreateBooking
  @DeleteBooking
  Scenario: Post booking from before scenario
    And Get EXIST id from booking
    Then Status code: 200

  Scenario Outline: Post three bookings with datas from outline
    Given Add firstname: "<firstname>", lastname: "<lastname>", totalprice: <totalprice>, depositpaid: "<depositpaid>", checkin: <checkin>, checkout: <checkout>, additionalneeds: <additionalneeds>
    When Post booking
    Then Status code: 200

    And Get EXIST id from booking
    Then Status code: 200
    Examples:
      | firstname | lastname | totalprice | depositpaid | checkin | checkout | additionalneeds |
      | RANDOM    | RANDOM   | RANDOM     | false       | TODAY   | TOMORROW | RANDOM          |
      | RANDOM    | RANDOM   | RANDOM     | true        | RANDOM  | RANDOM   | RANDOM          |
      | RANDOM    | RANDOM   | RANDOM     | false       | RANDOM  | TODAY    | RANDOM          |

  @CreateBooking
  Scenario: Delete post booking from before scenario
    And Get EXIST id from booking
    Then Status code: 200

    And Delete EXIST booking
    Then Status code: 201

  Scenario: Delete post booking and then post booking
    Given Add body with random parameters
    When Post booking with RANDOM_BODY to booking

    Then Status code: 200

    And Get EXIST id from booking
    Then Status code: 200

    And Delete EXIST booking
    Then Status code: 201

    And EXIST booking after created
    And Get information for no EXIST booking
    Then Status code: 404

  @CreateBooking
  @DeleteBooking
  Scenario: Put existing booking
    And Get EXIST id from booking
    Then Status code: 200

    And Booking with random parameters firstname: "UpdatedFristName", lastname: "UpdatedLastName"
    When Put EXIST booking
    Then Status code: 200

    And EXIST booking after created
    And Get information for no EXIST booking

  @CreateBooking
  @DeleteBooking
  Scenario: Patch existing booking
    And Get EXIST id from booking
    Then Status code: 200

    And Booking with random parameters firstname: "UpdatedFristName", lastname: "UpdatedLastName"
    When Patch EXIST booking
    Then Status code: 200

    And EXIST booking after created
    And Get information for no EXIST booking
