Feature: Add information to CV
	I want to add information, such as certificates and employments to my CV

  Scenario: An employee adds a certificate to the CV
    Given An empty CV
    When I add the certificate "Java SE 8 OCP" that I received on 2018-03-12 to my CV
    Then My CV contains the certificate "Java SE 8 OCP"

  Scenario: Adding a certificate to the CV increases number of certificates by one
    Given An empty CV
    And CV contains certificate "Java SE 8 OCA" with date 2016-06-23
    When I add the certificate "Java SE 8 OCP" that I received on 2018-03-12 to my CV
    Then My CV contains 2 certificates

  Scenario Outline: Duration of employments is calculated correctly
    Given An empty CV
    When I add an employment at <employer> starting on <from> until <to>
    Then The period of the employment at <wantedEmployer> is <nrOfYears> years and <nrOfMonths> months

    Scenarios: 
      | employer     | from       | to         | wantedEmployer | nrOfYears | nrOfMonths |
      | "First Inc." | 2013-04-15 | 2015-11-13 | "First Inc."   |         2 |          8 |
      | "Dev Inc."   | 2015-12-01 | 2017-07-31 | "Dev Inc."     |         1 |          8 |
      | "Test Inc."  | 2017-08-01 | 2021-01-31 | "Test Inc."    |         3 |          6 |
      | "Ops Inc."   | 2021-02-01 |   today    | "Ops Inc."     |         0 |          9 |
