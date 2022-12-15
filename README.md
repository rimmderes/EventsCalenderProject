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
| GET all events : | localhost:8080/events   |
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
| PATCH an event: | localhost:8080/events/1  |

4. DELETE EVENTS

| COMMAND | URL    |
| :---:   | :---: | 
| DELETE an event (i.e. id = 3): | localhost:8080/events/3  |


### ***Instructions*** 📝 

1. Create a database in your desired location using terminal: 'createdb *insert desired name*'.
<br />

2. Run the API in the EventCalenderApplication class. 
<br />

3. Open Postico to view Users and Events table with inputted information from the DataLoader
<br />
<br />

4. Open [Postman](https://www.postman.com/) to use GET, POST, PATCH and DELETE commands.
<br />
<br />
5. To use GET USERS functions:
- Select GET mapping and enter the URL for commands 'GET all users' / 'GET user by id' listed in the users command table above to get all users or individual users via id.
<br />
6. To use POST USERS function:
- Select POST mapping and enter the URL for command 'POST new user' listed in the users command table above to add a user to the user list. An id to the user will be provided and the user will now appear on the GET all users mapping when 'sending' the function again.

    -   However, if the events capacity has been reached, the user will not be added to the event accompained with a response declaring the event is full.

<br />
<br />
7. To use GET EVENTS function:
- Select GET mapping and enter the URL for commands 'GET all events'/'GET event by id' listed in the events command table above to get all events or individual events via id.
<br />
- Select GET mapping and enter the URL for command 'GET event by date' listed in the events command table above to get an to find events on a particular date. The example date in the command table refers to the 'Paint N Sip' event, which appears upon sending the request.
<br />
- Select GET mapping and enter the URL for command 'GET days until event' listed in the events command table above to get the years/months/days until the event begins. Enter the id of the desired event to recieve the response. The example above refers to event 'Pizza Making' (id = 2).
<br />
8. To use POST EVENTS function:
- Select POST mapping and enter the URL for command 'POST a new event' listed in the events command table above to add an event to the events list. An id to the event will be provided and the event will now appear on the GET all events mapping when 'sending' the function again.
<br />
9. To use PATCH EVENTS function:

- Select PATCH mapping and enter the URL for command 'PATCH an event' listed in the events command table above to update an event with a new user.

     - For example: the PATCH events table command is showing an update event id 1 (Paint N Sip). However, to update the event with a new user, the new users id must be entered in the body.  
    - > body:
<br /> 
{ <br />
        “userId”: 7         
}
    - Once the userID is sent, the user will be added to the event if the event has not reached its capacity.
    - The user can now be found in the event's list of users, and the event in the user's list of events.


<br />
10. To use DELETE EVENTS function:

- Select DELETE mapping and enter the URL for command 'DELETE an event' listed in the events command table above to remove an event from the events list using an events id. 

    - The command table example shows event id = 3 (LDN Motor Show) being deleted. Once deleted, a response declaring the event hs been successully deleted will return.
