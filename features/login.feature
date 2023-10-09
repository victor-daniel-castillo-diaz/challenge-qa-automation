@login
Feature: Login

@IS-001
Scenario: IS-001 Login with valid username and password
  Given the user go to page
  | https://www.saucedemo.com/ |
  When log in
  | standard_user |
  | secret_sauce |
  Then verify products screen
  | Productos |

@IS-002
Scenario: IS-002 Trying to log in with a blocked user's data
  Given the user go to page
  | https://www.saucedemo.com/ |
  When log in
  | locked_out_user |
  | secret_sauce |
  Then verify user blocked login
  | Epic sadface: Sorry, this user has been locked out. |
