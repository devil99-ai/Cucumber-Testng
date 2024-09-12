Feature: Validating Flyaway Workflow
@SignUp
  Scenario: SignUp scenario
    Given user is in flyaway home page
    Then user clicks on login/signup
    And user clicks on register
    Then user fill details and click on signup
    Then user gets successfully registered page
@Login
  Scenario: Login success and failure scenario
    Then user navigates to login page
    When user provide wrong email and password
    And user clicks on login
    Then user gets login failed
    When user provide vaild email and password
    Then user able to successfully login
@booking
  Scenario: flight booking scenario with payment
    When user in on home page
    Then user clicks on book flight
    And user navigate to payment gateway page
    When user clicks on complete booking
    Then user gets confirmation of flight booking
@viewBooking
  Scenario: View Bookings scenario
    Then user is on fflyaway home page
    When user clicks on your bookings
    Then user able to see bookings
@search
  Scenario: From and To flight search scenario
    Then user click on from dropdown and select place
    And user click on to dropdown and select place
    When user click on submit
    Then user able to see flight in provided src to dest path
@search2
  Scenario: From and To - no flight search scenario
    And user select place from FROM dropdown
    Then user select place from TO dropdown
    And user clicks on submit
    But user see empty list
@editProfile
  Scenario: Edit profile scenario
    Then user clicks on edit profile option
    And user navigated to edit profile page
    Then user change details
    And user provided passwords
    Then user clicks on update
    And user successfully edited profile
