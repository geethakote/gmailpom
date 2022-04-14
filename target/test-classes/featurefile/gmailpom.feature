Feature: Gmail compose

  Scenario: 
    Given open "chrome" browser
    And launch site using "http://www.gmail.com"
    When do login using "geethakarekallu" and "geetha1984@" credentials
    Then compose is displayed
    When click on compose ,fill fildes ,send mail and check responce
      | to                   | subject | body           | attachment                         |
      | geethakote@gmail.com | hi      | hi\n how r you | C:\\Photos\\Goa 2021\\IMG_3737.JPG |
      | dhanu.test@gmail.com | hello   | hi\n how r you | C:\\Photos\\Goa 2021\\IMG_3738.JPG |
      | dhanu.test@gmail.com | hi dear | hi\n how r you | C:\\Photos\\Goa 2021\\IMG_3741.JPG |
      When do logout
      Then login page should be redisplayed
      When close site
