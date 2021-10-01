Feature: Remove information from CV
  I want to remove information from my CV, if they are outdated

  Background:
  	Given An empty CV
  	And CV contains certificate "Java SE 8 OCA" with date 2016-06-23
  	And CV contains certificate "Java SE 8 OCP" with date 2018-03-12
  	And CV contains the following employments:
  		| employer     | from       | to         |
		| "Dev Inc."   | 2015-12-01 | 2017-07-31 |
		| "Test Inc."  | 2017-08-01 | 2021-01-31 |
		| "Ops Inc."   | 2021-02-01 |   today    |
  
  
  Scenario: Removing a certificate from the CV decreases number of certificates by one
  	When I remove the certificate "Java SE 8 OCP"
  	Then My CV contains 1 certificate