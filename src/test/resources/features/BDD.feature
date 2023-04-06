Feature: Mailchimpo signup

  Scenario Outline: create user - successfully
    Given user start a "<browser>"
    And user navigate to "<website>"
    When user types in a email "<hotmail>"
    When user types in a username <username>"
    When user types in a password <password>"
    Then user can "<sign up>"
    Examples:
      | browser |  | website                            | hotmail             | username                                                                                       | password       | sign up |
      | chrome  |  | http://login.mailchimp.com/signup/ | hej                 | dfgdfghfdghcvb                                                                                 | 3!Akmasdnfasdf | yes     |
      | edge    |  | http://login.mailchimp.com/signup/ | hej                   | dfgdfghfdghcvb                                                                                 | 3!Akmasdnfasdf | yes     |
      | chrome  |  | http://login.mailchimp.com/signup/ | kladdkaka@gmail.com | EEEEEEEEElektrifieradeDrakensFlammaSprakarHogtOchBelyserMorkretrSomEnMajestatiskFyrverkeriShow | 3!Akmasdnfasdf | no      |
      | edge    |  | http://login.mailchimp.com/signup/ | kladdkaka@gmail.com | EEEEEEEEElektrifieradeDrakensFlammaSprakarHogtOchBelyserMorkretrSomEnMajestatiskFyrverkeriShow | 3!Akmasdnfasdf | no      |
      | chrome  |  | http://login.mailchimp.com/signup/ | kladdkaka@gmail.com | jkadjkajsjdkajsh                                                                               | 3!Akmasdnfasdf | fail    |
      | edge    |  | http://login.mailchimp.com/signup/ | kladdkaka@gmail.com | jkadjkajsjdkajsh                                                                               | 3!Akmasdnfasdf | fail    |
      | chrome  |  | http://login.mailchimp.com/signup/ |                     | jkadjkajsdkfdgajs                                                                              | 3!Akmasdnfasdf | nej     |
      | edge    |  | http://login.mailchimp.com/signup/ |                     | jkadjkajsdkfdgajs                                                                              | 3!Akmasdnfasdf | nej     |

