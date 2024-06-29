
### Introduction 
A cloud storage web application that allows users to securely store, manage, and share their files and folders online.

**Features**
* User login and signup
* Upload, download, delete files and folders
* Create and navigate folders
* Share files and folders
* Various storage plans supported
* Search files and folders

#### Getting Started 
  *Since this project is not deployed yet as I am still working on it, please follow the steps to run this project*
**Requirements**
* Java version 17 or later.
* Maven
* Node version 18 or later.


### Setup
**Clone the repository**

   ```bash
   git clone https://github.com/yourusername/drive-app.git
   ```
**Front-end Setup**

```bash
  cd /client # Navigate to client directory
  npm install # Install the dependencies
  npm run dev # Start the frontend 
```
*The front-end will be running at URL `http://localhost:5173`.*


**Back-end Setup**
```bash
  cd /server # Navigate to the server directory
  mvn clean install # Build the project
  mvn spring-boot:run # Start the server
```
    
*The server should run by default at `http://localhost:8080` unless the port is not changed in application.properties file.*

#### Miscellaneous
I am still working on the project, so any suggestions are welcome.
Feel free to fork the project and use it. 
