📘 Number Guessing Game — Spring Boot Web Application

A simple but polished web-based Number Guessing Game, built with Spring Boot, Thymeleaf, MySQL, and responsive UI featuring automatic Light/Dark mode, animations, and result history storage.

🚀 Features
🎮 Gameplay

The system generates a random number between 1 and 100.

The player tries to guess it in as few attempts as possible.

Feedback is provided after each guess:

Very Low

Low

High

Very High

Correct

When the player wins, the result is saved in the database.

💾 Persistent Game History

Stores every completed game in MySQL.

Saves:

Player name

Attempts

Target number

Date played

Results are displayed in a clean, styled table.

🎨 Modern UI

Fully redesigned interface with:

Glassmorphism-inspired cards

Smooth hover effects

Clean fonts & spacing

Stylish buttons

Automatic Light/Dark mode toggle with persistent preference.

🛠️ Technologies Used

Java 22

Spring Boot 3

Thymeleaf

Spring MVC

Spring Data JPA

MySQL Database

HTML5 / CSS3

JavaScript (for theme toggle)

📦 Project Structure
src/main/java/com.nikoliadis.swe6002.numberguessinggame
 ├── controller
 │     └── GameController.java
 ├── service
 │     └── GameService.java
 ├── repository
 │     └── GameResultRepository.java
 ├── model
 │     └── GameResult.java
 └── NumberguessinggameApplication.java

src/main/resources
 ├── templates
 │     ├── index.html
 │     ├── game.html
 │     └── result.html
 └── application.properties

🗄️ Database Configuration

The application requires a MySQL database.

Create a database:

CREATE DATABASE numberguessing;


Application configuration (located in application.properties):

spring.datasource.url=jdbc:mysql://localhost:3306/numberguessing
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


Make sure MySQL is running (XAMPP / Workbench / Docker).

▶️ How to Run

Clone the repository:

git clone https://github.com/YOUR_USERNAME/YOUR_REPO.git


Open the project in IntelliJ IDEA.

Ensure MySQL is running.

Run:

NumberguessinggameApplication


Open the application:

http://localhost:8080

📝 Screenshots
Home Page

(Enter player name, select mode)

Gameplay

(Guess the number with dynamic feedback)

Result View

(Shows previous games with stored results)

🧩 Future Improvements

Optional ideas you can implement later:

Leaderboard for best scores

Difficulty modes (easy/medium/hard)

REST API endpoints

Player profiles

👨‍💻 Author

Nikolaos Nikoliadis

📄 License

This project is released for academic purposes as part of
SWE-6002 Enterprise Systems Development.
