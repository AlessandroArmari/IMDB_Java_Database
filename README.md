This is a simple Java Project to simulate interaction with a DataBase
I am using MySQL

TO DO BEFORE EVERYTHING:

---> Put The .jar file in the libray folder (the 'mysql-connector-j-8.0.31.jar' file is
the driver "to allow the link between Java and SQL")

---> Manually Create the schema "imdb" in MySQL

+++REAL THING STARTING FROM HERE+++

I ALWAYS RECOMEND starting from "model" folder. Creating the main "classes" (Actor.java, Movie.java)

1. We create constructors (2 of them), getter and setters
   (TRICK: right click on the background--->Source Action--->Generate Getters And Setters)

![Alt text](screen\screen1.png?raw=true "Optional Title")

2. ActorDAO and MovieDAO are two interfaces--->they contain methods we will use in 'ActorDAOImpl.java' and 'MovieDAOImpl.java'

![Alt text](screen\screen2.png?raw=true "Optional Title")

3. Now create the folder "util" and the class ConnectionManager.java. It creates the "connection between" the project and MySQL database.

+++REMEMBER TO USE YOUR MySQL USER and PASSWORD+++

![Alt text](screen\screen3.png?raw=true "Optional Title")

4. In SqlQueryStorage.java we literally write down the MySQL queries we want to launch in Database.
   Where you can see "?" we will put some values in the next point.

![Alt text](screen\screen4.png.png?raw=true "Optional Title")

5. Finally we do the "core classes".
   The DAOimpl classes implent DAO classes ('public class ActorDAOImpl implements ActorDAO')
   Using the class Connection we throw a connection with DB
   Then we use a Prepared Statement using method of SqlQueryStorage
   Then we "fill" the ? with parameteres taken by getters (actor.getName())

![Alt text](screen\screen5.png.png?raw=true "Optional Title")

6. In DatabaseManager we create methods to cast the queries to create and erase tables in SQL

![Alt text](screen\screen6.png.png?raw=true "Optional Title")

7. +++REMEMBER to create IMDB.java (business logic)+++
   In App.java we finally create movies ande actors using Java classes and methods.
   But we actually are working using Database queries. (Open your DB and inspect IMDB tables to see the rows filled)
   When you are ready launch the app.java by click on the arrow on the top-right of the screen!

![Alt text](screen\screen7.png?raw=true "Optional Title")
