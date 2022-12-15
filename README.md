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

### ***Dependencies*** ⚓

- JPA Spring Data JPA
- Spring Web
- SpringBoot DevTools
- PostgresSQL Driver

### ***Our Commands*** 🫡

#### USERS

1. GET (SHOW) USERS

| COMMAND | URL    |
| :---:   | :---: | 
| GET all users | localhost:8080/users   |
| GET user by id: | localhost:8080/users/1  |

2. POST new user

| COMMAND | URL    |
| :---:   | :---: | 
| POST new user | localhost:8080/users   |

#### EVENTS

1. GET (SHOW) EVENTS

| COMMAND | URL    |
| :---:   | :---: | 
| GET event by event id: | localhost:8080/events/1   |
| GET event by date: | localhost:8080/events?date=2023-01-06   |
| GET days until event (with event id = 2): | localhost:8080/events/days-until/2   |

2. POST EVENTS

| COMMAND | URL    |
| :---:   | :---: | 
| POST a new event: | localhost:8080/events  |

3. PATCH Event

| COMMAND | URL    |
| :---:   | :---: | 
| PATCH user 9 into event 1: | localhost:8080/events/1  |

4. DELETE EVENTS

| COMMAND | URL    |
| :---:   | :---: | 
| DELETE a new event (i.e. id = 5): | localhost:8080/events/5  |


### ***Instructions*** 📝 

1. Create a database in your desired location using terminal: 'createdb *insert desired name*'.
2. Run the API in the EventCalenderApplication class.
3. Open Postico to view Users and Events table with inputted information from the DataLoader
4. Open [Postman](https://www.postman.com/) to use GET, POST, PATCH and DELETE commands.
5. To use GET USERS functions:
- Select GET mapping and enter the commands listed in the table above to get all users or individual users via id.
6. To use POST USERS function:
- Select POST mapping and enter the command listed in the table above to add a user to the user list. An id to the user will be provided and the user will now appear on the get mapping when 'sending' the function again.
7. To use GET EVENTS function:
- 
