Feature: Add information to CV

  Scenario: An employee adds a certificate to the CV
    Given An empty CV
    When I add the certificate "Java SE 8 OCP" that I received on 12.03.2018 to my CV
    Then My CV contains the certificate "Java SE 8 OCP"

    
  Scenario: Adding a certificate to the CV increases number of certificates by one
    Given An empty CV
    And CV contains certificate "Java SE 8 OCA" with date 23.06.2016
    When I add the certificate "Java SE 8 OCP" that I received on 12.03.2018 to my CV
    Then My CV contains 2 certificates