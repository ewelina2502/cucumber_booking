Feature: Booking tests

  Scenario: Get all bookings
    Given Get booking
    Then Status code: 200

  Scenario: Post booking
    Given Add body with random parameters
    When Post booking
    Then Status code: 200

  Scenario Outline: Post booking with datas
    Given Add firstname: "<firstname>", lastname: "<lastname>", totalprice: "<totalprice>", depositpaid: "<depositpaid>", checkin: "<checkin>", checkout: "<checkout>", additionalneeds: "<additionalneeds>"
    When Post booking
    Then Status code: 200
    Examples:
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Adam      | Nowak    | 123        | true        | 2021-01-21 | 2022-01-23 | Breakfast       |
      | Ada       | Nowa     | 124        | false       | 2022-01-21 | 2022-01-23 | Lunch           |
      | Magda     | Kowal    | 125        | false       | 2023-03-23 | 2024-04-24 | Lunch           |

  Scenario: Delete post booking
    Given Add body with random parameters
    When Post booking
    Then Status code: 200

    And Get EXIST from booking
    And Delete booking
    Then Status code: 201

  Scenario: Put booking
    Given Add body with random parameters
    When Post booking
    Then Status code: 200

    And Put booking with random parameters firstname: "RandomFristName", lastname: "RandomFristName"
    When Put EXIST booking
    Then Status code: 200
