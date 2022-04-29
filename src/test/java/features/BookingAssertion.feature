Feature: Assertions
  Scenario Outline: postBookingWithAssertionOfFirstname
    Given Add path and post request
    And Add new parameters "<firstname>" "<lastname>" "<totalprice>" "<depositpaid>" "<checkin>" "<checkout>" "<additionalneeds>"
    When Check new booking ids
    Then Search assertions
    Examples:
      | firstname | lastname | totalprice | depositpaid  |checkin    | checkout   | additionalneeds |
      | Maciej    | Pajak    | 199        | true         |2026-01-21 | 2026-01-23 | Breakfast       |


  Scenario Outline: postBookingWithAssertionOfLastname
    Given Add path, post request
    And Add parameters "<firstname>" "<lastname>" "<totalprice>" "<depositpaid>" "<checkin>" "<checkout>" "<additionalneeds>"
    When Check of booking ids
    Then Search new assertion
    Examples:
      | firstname | lastname | totalprice | depositpaid  |checkin    | checkout   | additionalneeds |
      | Zuzia     | Pajak    | 199        | true         |2026-01-21 | 2026-01-23 | Breakfast       |


  Scenario Outline: postBookingWithAssertionOfAdditionalneeds
    Given Add path, post request
    And Add parameters "<firstname>" "<lastname>" "<totalprice>" "<depositpaid>" "<checkin>" "<checkout>" "<additionalneeds>"
    When Check of booking ids
    Then Search new assertion of additionalneeds
    Examples:
      | firstname | lastname | totalprice | depositpaid  |checkin    | checkout   | additionalneeds |
      | Bartosz   | Pajak    | 199        | true         |2026-01-21 | 2026-01-23 | Breakfast       |

  Scenario Outline: postBookingWithAssertionOfTotalprice
    Given Add path, post request
    And Add parameters "<firstname>" "<lastname>" "<totalprice>" "<depositpaid>" "<checkin>" "<checkout>" "<additionalneeds>"
    When Check of booking ids
    Then Search new assertion of totalprice
    Examples:
      | firstname | lastname | totalprice | depositpaid  |checkin    | checkout   | additionalneeds |
      | Bartosz   | Pajak    | 199        | true         |2026-01-21 | 2026-01-23 | Breakfast       |

  Scenario Outline: postBookingWithAssertionOfDepositpaid
    Given Add path, post request
    And Add parameters "<firstname>" "<lastname>" "<totalprice>" "<depositpaid>" "<checkin>" "<checkout>" "<additionalneeds>"
    When Check of booking ids
    Then Search new assertion of depositpaid
    Examples:
      | firstname | lastname | totalprice | depositpaid  |checkin    | checkout   | additionalneeds |
      | Bartosz   | Pajak    | 199        | true         |2026-01-21 | 2026-01-23 | Breakfast       |

  Scenario Outline: postBookingWithAssertionOfCheckin
    Given Add path, post request
    And Add parameters "<firstname>" "<lastname>" "<totalprice>" "<depositpaid>" "<checkin>" "<checkout>" "<additionalneeds>"
    When Check of booking ids
    Then Search new assertion of checkin
    Examples:
      | firstname | lastname | totalprice | depositpaid  |checkin    | checkout   | additionalneeds |
      | Bartosz   | Pajak    | 199        | true         |2026-01-21 | 2026-01-23 | Breakfast       |

  Scenario Outline: postBookingWithAssertionOfCheckout
    Given Add path, post request
    And Add parameters "<firstname>" "<lastname>" "<totalprice>" "<depositpaid>" "<checkin>" "<checkout>" "<additionalneeds>"
    When Check of booking ids
    Then Search new assertion of checkout
    Examples:
      | firstname | lastname | totalprice | depositpaid  |checkin    | checkout   | additionalneeds |
      | Bartosz   | Pajak    | 199        | true         |2026-01-21 | 2026-01-23 | Breakfast       |
