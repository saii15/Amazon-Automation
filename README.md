For UI Automation, I have used Selenium tool with JAVA Language.

Used TestNG Framework in this project

Report:
Extent Report is used to see the execution

Logs:
Log4j is used to generate the log files

TestScripts:
src/test/java/E2EProject
1.HomePage.java 

  This class contains below steps:
    1. Launch the browser.
    2. Open URL - http://www.google.com
    3. Enter the keyword "amazon" in the search bar
    4. print all the search results 
    
    
    
    

![Screenshot (157)](https://user-images.githubusercontent.com/17718690/201033437-630c1735-6fd6-4683-a165-0cd7b6b05efc.png)

2.LandingPageTest.java

  This class contains below steps:
    5. Click on the link which takes you to the amazon login page.
    6. login to https://www.amazon.in/
    7. click on all buttons on search & select Electronics.
    8. search for dell computers
    9. apply the filter of range Rs 20000 to 30000
    
    
    
    
   ![Screenshot (156)](https://user-images.githubusercontent.com/17718690/201033474-bf72fc5c-e4fa-4a12-a025-5139a41a996d.png)


    ![Screenshot (154)](https://user-images.githubusercontent.com/17718690/201012978-31d2d47d-af8b-4c6c-830f-42697df812f2.png)
    
    
3.Validation.java
  This class contains below steps:
  
  10. Validate all the products on the first 2 pages are shown in the range of Rs 30000 to 50000
  
  
  
  
  ![Screenshot (155)](https://user-images.githubusercontent.com/17718690/201033822-a09ce5b7-9adc-4a52-9fda-c591073655d7.png)

  

4.listeners

  Listeners is used to see the execution flow and for the reporting.
  
  
  Utilities:
  src/test/java/resources
  1. XLUtil.java 
  2. base
  3. ExtentReport
  4. data.properties 
  5. log4j2
  
  Amazon/
  
  dataFiles/Data.xlsx
  logs/print.logs
  
  
  
[prints.log](https://github.com/saii15/Amazon-Automation/files/9978626/prints.log)

  reports/index.html
  
  ![Screenshot (158)](https://user-images.githubusercontent.com/17718690/201034221-e7dd6ab2-642d-40ed-b4b0-0eaadcd8f1ea.png)

  
  
