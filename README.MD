I used
--------------------------
**Serenity + Cucumber + Maven**

To Run
----------------------------
**mvn clean verify** or just **mvn verify**


Cross browser
--------------
I created the **serenity.conf** file, and there I registered the settings for different browsers.
With the command: **mvn clean verify -Dwebdriver.driver=nameOfBrowser(for example firefox)**  We can run tests in different browsers

Basic authentication
----------------------------
I added environments to serenity.conf file, and I can switch url with command:
**mvn clean verify -Denvironment=base -Dcucumber.options="--tags @baseurl"**,

Continuous Integration
------------------------------

I created maven project in **Jenkins**. Resources directory has jenkins folder with screenshots

Running tests in multiple threads
-----------------------------------
For parallel test execution I used "parallel" parameter in maven-failsafe-plugin 


Disablement of saving screenshots
------------------------------------
Screenshots Disabled in serenity.properties file