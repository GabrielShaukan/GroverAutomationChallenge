# Grover Web Automation Challenge

This is my solution for the Grover Web Automation Challenge.

**Task**:  
create a small UI test automation suite, for the popular website imdb.com.
The Suite Consists of 2 test cases.
1. Testing if the page "Top 250 Movies" returns at least one movie from the list with all sorting options
2. Testing if the page "Top Western Movies" returns at least one movie from the list with all sorting options

**Tools Used**:   
 -Java (v. 1.8.0_171)  
 -Junit (v. 4.13.2)  
 -Selenium (v. 4.0.0-rc-2)  
 -Maven    

**Solution**:  
I used Selenium as the test automation framework with the unit testing framework Junit. Java was chosen as the programming language with Maven for dependency injection. 
Commits have been made as granular as possible, logging every significant changes made.  
The tests are designed with the Page Object Model and Page Factory in mind. 
Leveraging this design pattern allows for more modular and dynamic automated tests hench the support for a growing number of test cases in the future.
The test suite currently supports three of the most popular web browsers in use today (Chrome, Firefox, MS Edge). Which browser is used for testing can be changed in the config file located at /src/test/resources/test.conf.

Webdriver versions used:  
Chrome: ChromeDriver 94.0.4606.61  
Firefox: geckodriver 0.30.0  
Edge: MSEdgeDriver 94.0.992.37  
