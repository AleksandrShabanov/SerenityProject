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
I need help here. I added environments to serenity.conf file and I can switch url with command:
**mvn clean verify -Denvironment=base**,
but I don't know how run single test.

Continuous Integration
------------------------------

I created maven project in **Jenkins**. Resources directory has jenkins folder with screenshots

Running tests in multiple threads
-----------------------------------
If we use Serenity + Jbehave, parallel tests don't work.  
I read about it on the official serenity forum, it's all about a bug on the Jbehave side.

Running tests in multiple threads in Cucumber
---------------------------------------------
I decicded use Jbehave, because I have already used Cucumber in my practice program.
There we can use parallel tests, it's simple. We just need to added configuration to
failsafe\surefire plugin:

                <configuration>
                    <forkCount>6</forkCount>
                    <reuseForks>true</reuseForks>
                </configuration>

Disablement of saving screenshots
------------------------------------
Screenshots Disabled in serenity.properties file