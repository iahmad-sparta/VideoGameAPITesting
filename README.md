# VideoGameAPITesting

## Description

## Using Git

### Our branches

## Features
List of features:
- RestAssured
- Hamcrest
- CucumberScripts

## Prerequisites
To run this project, the following technologies are required:
 - Java (Version 23)
 - Maven
 - RestAssured (Version 5.3.1)
 - Junit (Version 3.8.1)
 - Cucumber (Version 7.18.0)
 - Hamcrest (Version 2.2)
   
## How to Contribute

Clone the repository:
```
git clone https://github.com/robert-h25/VideoGameAPITesting.git
```

### Create a new branch:
```
git checkout -b feature/your-feature-name
 ```

### Commit your changes:
```
git commit -m "Add your message here"
 ```

### Push to the branch:
```
git push origin feature/your-feature-name
 ```

### Open a pull request.

   
## Project Structure
```
VideoGameAPITesting  
    │   pom.xml  
    ├─src  
    │  └─test  
    │     ├─java  
    │     │   └─com  
    │     │     └─sparta  
    │     │         │   AppTest.java  
    │     │         │   GetVideoGameWithIdTest.java  
    │     │         │   PostVideoGameRequestBody.java  
    │     │         │   PostVideoGameToDatabaseTest.java  
    │     │         │   TestAuthentification.java  
    |     │         │   TestDELETECommandsWithFirstController.java  
    │     │         │   TestDELETECommandsWithSecondController.java  
    │     │         │   TestPUTCommandsWithFirstController.java  
    │     │         │   TestPUTCommandsWithSecondController.java  
    │     │         │   Utils.java  
    │     │         └─stepdefs  
    │     │             GetVideoGameIDStepDefs.java  
    │     │             VideoGameListStepdefs.java  
    │     └─resources  
    │             GetVideoGamesList.feature  
    │             GetvVideoGamesListV2.feature  
    │             VerifyVideoGameResponseData.feature  
    ├─.gitignore  
    └─README.md  
```
## What was Tested?
In this project we found an number of testing areas (Epics) which we derived user stories from. The user Epics identified were:
### Authentication

ES-1
As a user, I want to be able to POST with a password and username  and get a status code 200 or 400 for invalid input.
 
### Api-video-games-controller
 
ES-2 
As a user, I would like to be able to GET a list of all the videogames on the website with the first controller
 
ES-3 
As a user, I would like to POST a video game
 
ES-4
As a user, I would like to GET a videogame based on id with the first controller
 
ES-5
As a user, I would like to PUT a video game with the first controller
 
ES-6
As a user, I would like to DELETE a video game with the first controller
 
### Api-video-games-controller-v-2
 
ES-7
As a user, I would like to be able to GET a list of all the videogames on the website with the second controller
 
ES-8 
As a user, I would like to POST a video game with the second controller
 
ES-9
As a user, I would like to GET a videogame based on id with the second controller
 
ES-10
As a user, I would like to PUT a video game with the second controller
 
 
ES-11
As a user, I would like to DELETE a video game with the second controller

The breakdown of these epics into user stories was done on the [project board](https://github.com/users/robert-h25/projects/2).
## Test Metrics

## Defects
We located 2 defects

## Acknowledgements
This project was created by:
- tcalabangiu
- iahmad-sparta
- ik1g19
- makduffy
- Spartan0201
