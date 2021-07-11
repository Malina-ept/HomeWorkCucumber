Feature: Checking the site otus.ru


  @home
  Scenario: Checking the page title otus.ru
    Given Page otus.ru
    When The page is open otus.ru
    Then The page has the expected title

  @home
  Scenario: Checking address in Contacts
    Given Page otus.ru/contacts
    When Сhecking the contacts
    Then The address does not match the expected one

  @home
  Scenario: Checking text in FAQ
    Given FAQ on page otus.ru
    When Checking text in FAQ
    Then The FAQ text corresponds to the expected


