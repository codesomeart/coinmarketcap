# Insructions:

Packages

### Recources Folder
1. Update the **ApplicationConfig.properties** file for changing the project credentials
2. All Features files.

### Com.cucumber.tests Package
1.update tags in **RunCukesTest** for executing particular feature file.
**@backend** - This tag is for all backend cases
**2frontend** - This tag is for all frontend cases

### General Package
1. General functions are defined in **GeneralFunctions** class
2. WebDriver related functions defined in **WebDriverFactory** class

### stepdefs Package
1. defined step definition for cucumber steps in **stepdefs** Packages

# Setup Code

Pre-requisites:
- Java JDK 8+ should be installed
- JAVA_HOME environment variable should be set

Steps to setup:
- Clone repository
- Open project on IntelliJ through pom.xml file
- Checkout develop branch
    - Git checkout -f develop

Steps to execute script:
- Right click TestRunner file and Run it
- Wait for full execution

Setup of Jenkins Locally:
Jenkins setup:
* Tutorial link: https://www.guru99.com/download-install-jenkins.html
- Click on Manage Jenkins
- Click on Global Tool Configuration
- Under Maven, add Name (“mvnLatest”) and check Install automatically
- Click on Apply and then Save

