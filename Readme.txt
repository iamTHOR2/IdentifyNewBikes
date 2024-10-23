Detailed Description: 
====================

Identify New Bikes

Step-1
=======
Display "Upcoming" bikes details like bike name, price and expected launch date in India, for manufacturer 'Honda' & Bike price should be less than 4Lac

Step-2
=======
 For Used cars in Chennai, extract all the popular models in a List; Display the same

Step-3
=======
Try to 'Login' with google, give invalid account details & capture the error message	
(Suggested site: zigwheels.com however you are free to use any legitimate site)


Key Automation Scope:
====================
1.)Handling windows & frames
2.)Filling simple form, Capture warning message
3.)Extract menu items from frames & store in collections
4.)Navigating back to home page

Note: Take all necessary screenshots for all the testcases and print all the data in the console.

Frame Works Used:
=================
1.)Testng
2.)Maven
3.)Cucumber

Dependencies:
==========

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>HackProject</groupId>
  <artifactId>HackProject</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <build>
  <pluginManagement>
  <plugins>
  <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.13.0</version>
        </plugin>
        <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>3.2.5</version>
          <configuration>
          <suiteXmlFiles>
          <suiteXmlFile>testng.xml</suiteXmlFile>
          
          </suiteXmlFiles>
          
          </configuration>
        </plugin>
  </plugins>
  </pluginManagement>
  </build>
 
  <dependencies>
  <!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
<dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>2.15.1</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.apache.commons/commons-lang3 -->
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-lang3</artifactId>
    <version>3.14.0</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.18.1</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.testng/testng -->
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.9.0</version>
    <scope>test</scope>
</dependency>

<!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi</artifactId>
    <version>5.2.5</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>5.2.5</version>
</dependency>
<!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
<dependency>
    <groupId>com.aventstack</groupId>
    <artifactId>extentreports</artifactId>
    <version>5.1.1</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api -->
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-api</artifactId>
    <version>3.0.0-beta2</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core -->
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>3.0.0-beta2</version>
</dependency>
<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-java -->
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-java</artifactId>
    <version>7.16.1</version>
</dependency>
<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-junit -->
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-junit</artifactId>
    <version>7.16.1</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-testng</artifactId>
    <version>7.16.1</version>
    <scope>test</scope>
</dependency>
<!-- https://mvnrepository.com/artifact/com.aventstack/extentreports-cucumber4-adapter -->
	<dependency>
	    <groupId>tech.grasshopper</groupId>
	    <artifactId>extentreports-cucumber7-adapter</artifactId>
	    <version>1.14.0</version>
	</dependency>
</dependencies>
</project>


Output-:
==========

Upcoming Bikes:-
[Honda PCX160, Rs. 1.20 Lakh, Expected Launch : Jun 2024]
[Honda Activa Electric, Rs. 1.10 Lakh, Expected Launch : Jun 2024]
[Honda Activa 7G, Rs. 79,000, Expected Launch : Oct 2024]
[Honda CB350 Cruiser, Rs. 2.30 Lakh, Expected Launch : Nov 2024]
[Honda Forza 350, Rs. 3.70 Lakh, Expected Launch : Unrevealed]
[Honda CBR150R, Rs. 1.70 Lakh, Expected Launch : Unrevealed]
[Honda Rebel 300, Rs. 2.30 Lakh, Expected Launch : Unrevealed]
[Honda CRF300L, Rs. 3.30 Lakh, Expected Launch Date : 31 Dec 2050]


Popular cars:-
Maruti 800
Maruti Swift Dzire
Maruti Swift
Hyundai I10
Hyundai Santro Xing
Honda City
Toyota Innova
Toyota Fortuner
Mahindra XUV500
  

Invalid login details:-
SipLc@gmail.com
Couldn’t find your Google Account
fWSOJ@xyz
Enter a valid email or phone number

Enter an email or phone number
 


===============================================
Suite
Total tests run: 3, Passes: 3, Failures: 0, Skips: 0
===============================================


