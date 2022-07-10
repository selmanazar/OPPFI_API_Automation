Feature: Loan Application

  @API @loan
  Scenario Outline: loan application offer has been accepted
    When Application or endUser calls loanoffer with ssn "<socialSecurityNumber>"
    Then API responds with status code of "200"
    Then check if offer is accepted
    Then check if status is approved
    Then check if offer have loan details
    Then check if ssn is populated as "<socialSecurityNumber>" in the loan response
    Then check if leadOfferId is populated as "<leadOfferId>" in the loan response
    Then check if emailId is populated as "<email>" in the loan response
    Then check if stateCode is populated as "<stateCode>" in the loan response
    Then check if requestedLoanAmount is populated as <requestedLoanAmount> in the loan response
    Then check if grossMonthlyIncome is populated as <grossMonthlyIncome> in the loan response
    Then check if code is populated as <code> in the loan response

    Examples: 
      | socialSecurityNumber | leadOfferId                                   | email                   | stateCode | requestedLoanAmount | grossMonthlyIncome | code |
      |            123456780 | 20160912-21EC2020-3AEA-4069-A2DD-08002B30309D | test_customer@gmail.com | FL        |                1500 |               2800 |  201 |

  @API @loan
  Scenario Outline: loan application offer has been declined
    When Application or endUser calls loanoffer with ssn "<socialSecurityNumber>"
    Then API responds with status code of "200"
    Then check if offer is declined
    Then check if status is declined
    Then check if offer does have any loan details
    Then check if ssn is populated as "<socialSecurityNumber>" in the loan response
    Then check if leadOfferId is populated as "<leadOfferId>" in the loan response
    Then check if emailId is populated as "<email>" in the loan response
    Then check if stateCode is populated as "<stateCode>" in the loan response
    Then check if requestedLoanAmount is populated as <requestedLoanAmount> in the loan response
    Then check if grossMonthlyIncome is populated as <grossMonthlyIncome> in the loan response
    Then check if code is populated as <code> in the loan response

    Examples: 
      | socialSecurityNumber | leadOfferId                                   | email                   | stateCode | requestedLoanAmount | grossMonthlyIncome | code |
      |            123450000 | 20160912-21EC2020-3AEA-4069-A2DD-08002B30309D | test_customer@gmail.com | FL        |                1500 |               2800 |  315 |

  #@API @loan
  #Scenario Outline: loan application offer has been not declined or accepted
    #When Application or endUser calls loanoffer with ssn "<socialSecurityNumber>"
    #Then API responds with status code of "400"
#
    #Examples: 
      #| socialSecurityNumber | leadOfferId | email                      | stateCode | requestedLoanAmount | grossMonthlyIncome |
      #|            867530900 | kgj25sdd2   | test@example.com@gmail.com | IL        |                4000 |               2800 |
