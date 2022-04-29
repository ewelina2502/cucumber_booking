Feature: Assertions
Scenario Outline: postBookingWithExamples
  Given Add path and post request
  And Add new parameters "<firstname>" "<lastname>" "<totalprice>" "<depositpaid>" "<checkin>" "<checkout>" "<additionalneeds>"
  When Check new booking ids
  Then Search assertions
Examples:
| firstname | lastname | totalprice | depositpaid  |checkin    | checkout   | additionalneeds |
| Maciej    | Pajak    | 199        | true         |2026-01-21 | 2026-01-23 | Breakfast       |

