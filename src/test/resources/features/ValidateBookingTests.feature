Feature: Validate Booking tests

  Scenario: Delete post booking
    Given Add body with random parameters
    When Post booking
    Then Status code: 200

#    And Get NULL from booking
#    And Delete booking
#    Then Status code: 201