# **Event Management System Project (BNTA COHORT 7)**

### ***Collaborators*** ⭐
- Rimm Deres (GitHub: [RimmDeres](https://github.com/rimmderes))
- Rebecca Solomon (GitHub: [RebeccaSolomon](https://github.com/rebeccasolomon446))
- Harry Masini (GitHub: [HarryMasini](https://github.com/harry101101))
- Khalil Hersi (GitHub: [KhalilHersi](https://github.com/Crossreference16))

### ***Project Overview*** 🚀

- Our team had taken interest in apps and websites, such as EventBrite and Fatsoma, which present events for people to attend. This led to a demonstration of a many-to-many relationship between users and event, allowing us to utilise the two entities together.

Our API was coded in Java. We utilsed Git to commit our changes and contain our code in GitHub with our UML and ERD diagrams. We also used SpringBoot to implement the Spring framework, JPA to convert JSON and Java, alongside postman to test our functions.

### ***Project Timeline*** 💡

- Friday 09/12/2022 - Met with team to discuss ideas and started UML and ERD diagrams.
- Monday 12/12/2022 - Completed our set MVP using IntelliJ and Git.
- Tuesday 13/12/2022 - Began to complete extension tasks, getting event by id and date. Also debugging.
- Wednesday 14/12/2022 - Completed functions for the days until the event and setting a capacity.
- Thursday 15/12/2022 - Fixing errors and preparing presentation.
- Friday 16/12/2022 - Presentation.

<img src = ./diagrams1/project_overview.png>

### ***The API*** 💎

- We have a many-to-many relationship between our Users and Events.
- We included a DTO class to isolate our userId.

#### ***Class Diagram (UML)***
<img src= ./diagrams1/UML.png>


#### ***Entity Relationship Diagram (ERD)***

<img src= ./diagrams1/ERD.png>

### ***Dependencies*** 🫡

- JPA Spring Data JPA
- Spring Web
- SpringBoot DevTools
- PostgresSQL Driver

### ***Our Commands***

1. GET (SHOW) USERS

| COMMAND | URL link
| :---: |
| GET all users | localhost:8080/users|
| GET user by id: | localhost:8080/users/1 |  

2. POST new user

| USERS |
| :---:
| POST new user: |
| localhost:8080/users |  

1. GET (SHOW) EVENTS

| EVENTS |
| :---:   
| GET all events: |
| localhost:8080/events |
| GET event by event id: |
| localhost:8080/events/1 |
| GET event by date: |
| localhost:8080/events?date=2023-01-06 |
| GET days until event with id = 2|
| localhost:8080/events/days-until/2 |

2. POST EVENTS

| EVENTS |
|  :---: 
| Post a new event: |
| localhost:8080/events |






### ***Instructions*** 
