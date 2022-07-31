# AutomationExercise
#clone and configure in local
1)clone the project; convert project to maven and then convert to cucumber project
2)From eclipse market install cucumber plugin to view testcases into feature file in correct format and navigate to step definition.

#Tools and Technology  stack used
java programming
serenity cucumber
Maven build tool

#How to run the project
1)run via Maven-M Maven install..
2)Run  via testrunner which is in runner package

Maven will call testrunner which has step definitions and cucumber feature file path, then it will run scenarios which resides in feature folder and step defintions will be executed. Page Object model is used so locators are saved and organized as per the Screen. 
As a reporter plugin serenity report have been configured in POM.xml.

Serenity.properties contains all application and project level information. 


