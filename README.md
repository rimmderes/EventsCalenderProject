# **Event Booking System Project (BNTA COHORT 7)**

## **SAWS Code Team**

### ***Collaborators*** ⭐
- Rimm Deres (GitHub: [RimmDeres](https://github.com/rimmderes))
- Rebecca Solomon (GitHub: [RebeccaSolomon](https://github.com/rebeccasolomon446))
- Harry Masini (GitHub: [HarryMasini](https://github.com/harry101101))
- Khalil Hersi (GitHub: [KhalilHersi](https://github.com/Crossreference16))

### ***Project Overview*** 🚀

 Our team had taken interest in apps and websites, such as EventBrite and Fatsoma, which present events for people to attend. We originally wanted to produce an individual calendar for users, however, we decided we wanted our API to encompass a ranges of events, not limited to work meetings, networking events or personal affairs, but all. Thus, we chose to create an events booking system to include all of these.
 <br />

 Our team name, *SAWS code*, relates to the seasons of the year (Summer 🌞,Autumn 🍁, Winter ❄️, Spring 🌺 ) to signify different periods of the calendar year. Additionally, as we have used Spring Boot, we believed it was appropriate that it too is included in our name.


#### ***Technologies*** 🔌

 - Our API was coded in Java. We utilsed Git to commit our changes and contain our code in GitHub with our UML and ERD diagrams. The platform was extremely useful to track any changes we have made and roll back on any code. 
<br />

-  SpringIntializr was imperative for us to use as we were able to implement dependencies which allowed us to utilise particular functions and commands. For instance, we utilised SpringBoot to implement the Spring framework, JPA to convert JSON and Java, and SQL to manage our relational databases and perform various operations on the data in them. Finally, we used postman to test our functions. These platforms allowed us to test our code and import a variety of functions to create our tables and extend our beans (Examples: @JPARepositories, @Component etc).


#### ***Drawbacks*** 💔
Whilst completing the project, we faced a number of difficulties. 
- One of our major issues was our git branch and merge errors as they were time consuming and deleted some code. We researched how to resolve the issue and soon completely understood and were able to effectively execute branch merges and commits.
- Additionally, creating multiple route endpoints became an issue. We were unsure how to create the method and execute the function. Although we done research and were provided help which allowed us to create two different endpoints, 
 we were unsure how to continue adding more.

#### ***Future*** 🔑
If granted more time, we would like to develop more functions to create a more realistic working app which is complemented by the front-end. These include:

- Event Tags = categorising events to allow users to find events they would like to attend through the use of enums and algorithms to recommend common interests to users.
- Automation = remove events when the date of the event has passed. As we have not learned how to yet do this, this would require more research.
- More properties = include features such as price and its corresponding endpoint.


<br />



## **TABLE OF CONTENTS** 📖
> 1. Project Timeline
> 2. The API
> 3. Dependencies
> 4. Commands
> 5. Instructions

### ***1. Project Timeline*** 💡

- Friday 09/12/2022 - Met with the team to discuss ideas and started UML and ERD diagrams.
- Monday 12/12/2022 - Completed our set MVP using IntelliJ and Git.
- Tuesday 13/12/2022 - Began to complete extension tasks, getting event by id and date. Also debugging.
- Wednesday 14/12/2022 - Completed functions for the days until the event and setting a capacity.
- Thursday 15/12/2022 - Fixing errors and preparing presentation.
- Friday 16/12/2022 - Presentation.


<img src = ./diagrams1/project_overview.png>

 ### ***2. The API*** 💎

- We have a many-to-many relationship between our Users and Events.
- We included a DTO class to isolate our userId.
<br />

#### ***Class Diagram (UML)***
<img src= ./diagrams1/UML.png>
<br />


#### ***Entity Relationship Diagram (ERD)***

<img src= ./diagrams1/ERD.png>
<br />

3. ### ***Dependencies*** ⚓

- JPA Spring Data JPA
- Spring Web
- SpringBoot DevTools
- PostgresSQL Driver
<br />

 ### ***4. Commands*** 🫡

## ***USERS***

1. **GET** (SHOW) USERS

| Request Type | HTTP path | Description |
| :---:   | :---: | :---: | 
| GET | .../users   | Find all users |
| GET | .../users/1  | Find user via id (i.e.: id = 1) |

2. **POST** new user

| Request Type | HTTP path | Description |
| :---:   | :---: | :---: | 
| POST | .../users | Add a new user | 

## ***EVENTS***

1. **GET** (SHOW) EVENTS

| Request Type | HTTP path | Description | 
| :---:   | :---: | :---: | 
| GET | .../events | Display all events|
| GET | .../events/1   | Find event by event id (i.e.: 1)|
| GET | .../events?date=2023-01-06   | Find event by date (example:one of our event dates) |
| GET | .../events/days-until/2   | Find days until the event (i.e. event id = 2) |

2. **POST** EVENTS

| Request Type | HTTP path  | Description |
| :---:   | :---: | :---: | 
| POST | .../events  | Add a new event | 

3. **PATCH** Event

| Request Type | HTTP path | Description |
| :---:   | :---: | :---: | 
| PATCH  | .../events/1  | Update an event (i.e.: id = 1) | 

4. **DELETE** EVENTS

| Request Type | HTTP path | Description |
| :---:   | :---: | :---: | 
| DELETE | .../events/3  | Delete an event (i.e.: id = 3) | 
<br />


### ***5. Instructions*** 📝 

**1. Install postgres via the [postgres website](https://www.postgresql.org/download/) or via [home brew](https://brew.sh/).**

**2. Create a database in your desired location using terminal: 'createdb events_db'.**
<br />

**3. Run the API in the EventCalenderApplication class.** 
<br />

**4. Open Postico to view Users and Events table with inputted information from the DataLoader.**
<br />

**5. Open [Postman](https://www.postman.com/) to use GET, POST, PATCH and DELETE commands.**
<br />
<br />

 ### ***USERS*** 💃

**6. To use `GET` USERS functions:**
- Select **GET** mapping and enter the URL for commands 'GET (find) all users' / 'GET (find) user by user id' listed in the users command table above to get all users or individual users via id.
<img src= ./example_code/getallusers.png>
<br />

**7. To use `POST` USERS function:**
- Select **POST** mapping and enter the URL for command 'POST (add) new user' listed in the users command table above to add a user to the user list using the body. 
    - To access the body, select 'body' under the URL, then select raw and finally press the 'text' drop down menu and select JSON.
        - Within the body, fill in the properties of the new user as demonstrated in the image below.
    -  An id to the user will be provided and the user will now appear on the GET all users mapping when 'sending' the function again.
<img src= ./example_code/adduser.png>

<br />
<br />

### ***EVENTS*** 🎉

**8. To use `GET` EVENTS function:**
- Select **GET** mapping and enter the URL for commands 'GET (find) all events'/'GET (find) event by id' listed in the events command table above to get all events or individual events via id.
<img src= ./example_code/eventbyid.png>
<br />

- Select **GET** mapping and enter the URL for command 'GET (find) event by date' listed in the events command table above to get an to find events on a particular date. The example date in the command table refers to the 'Paint N Sip' event, which appears upon sending the request.
<img src= ./example_code/eventbydate.png>
<br />

- Select **GET** mapping and enter the URL for command 'GET (find) days until event' listed in the events command table above to get the years/months/days until the event begins. Enter the id of the desired event to recieve the response. The example above refers to event 'Pizza Making' (id = 2).
<img src= ./example_code/daysuntil.png>
<br />

**9. To use `POST` EVENTS function:**
- Select **POST** mapping and enter the URL for command 'POST (add) a new event' listed in the events command table above to add an event to the events list using the body as shown in the image below. Fill in the properties relating to the event and press send.
    - An id to the event will be provided and the event will now appear on the GET all events mapping when 'sending' the function again.

<img src= ./example_code/postevent.png>
<br />

**10. To use `PATCH` EVENTS function:**

- Select **PATCH** mapping and enter the URL for command 'PATCH (update) an event' listed in the events command table above to update an event with a new user.

     - For example: the **PATCH** events table command is showing an update event id 1 (Paint N Sip). However, to update the event with a new user, the new users id must be entered in the body. 
     <br />

    - > body: { “userId”: 9 }
    - Once the userID is sent, the user will be added to the event.
    - The user can now be found in the event's list of users, and the event in the user's list of events.
    - However, if the events capacity has been reached, the user will not be added to the event accompained with a response declaring the event is full.
<img src= ./example_code/capacity_reached.png>
<br />


**11. To use `DELETE` EVENTS function:**

- Select DELETE mapping and enter the URL for command 'DELETE an event' listed in the events command table above to remove an event from the events list using an events id. 

    - The command table example shows event id = 3 (LDN Motor Show) being deleted. Once deleted, a response declaring the event hs been successully deleted will return.
<img src= ./example_code/deleteevent.png>

<br />
<br />
<br />

# **WE HOPE YOU ENJOY USING OUR API**! 👾 