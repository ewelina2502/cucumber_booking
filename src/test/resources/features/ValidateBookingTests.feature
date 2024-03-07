Feature: Validate Booking tests

  Scenario: Delete post booking and then post booking
    Given Add body with RANDOM_BODY to booking
    When I post booking
    Then Status code: 200

    And Get EXIST id from booking
    Then Status code: 200

    And Delete RANDOM booking
    Then Status code: 405
