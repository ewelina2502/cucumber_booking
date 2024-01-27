Feature: Validate Booking tests

  Scenario: Delete post booking and then post booking
    Given Add body with random parameters
    When Post booking with RANDOM_BODY
    Then Status code: 200

    And Get EXIST id from booking
    Then Status code: 200

    And Delete RANDOM booking
    Then Status code: 405