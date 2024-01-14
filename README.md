# Working project video:

I made a video on the working of our project. Here is the link:

<br>


 ## [Click here to watch video of working project](https://youtu.be/kZoc7jls01Y)
<br>
<br>



# Task 1: Java REST API

This task involves implementing a Java application providing a REST API for managing "task" objects. Each task object includes specific properties, and a unique property based on the candidate's name.


## Implementation

- GET /tasks: Returns all tasks if no parameters are passed. If a task ID is provided as a parameter, it returns a single task or 404 if not found.
- PUT /tasks: Adds a new task. The task object is passed as a JSON-encoded message body.
- DELETE/tasks/{id}: Deletes a task based on the provided task ID.
- GET /tasks/findByName/{name}: Finds tasks by name. Returns one or more tasks containing the specified string in the name or 404 if nothing is found.

## MongoDB Setup

Use MongoDB atlas to connect your JAVA API with atlas cluster. Use mongo uri string provided by atlas and include them in your application.properties file with the correct user credentials.


## Screenshots
1. Create a task (POST Request).

<img src="./Images/1.JPG">

<br>
<br>

2. Show tasks (GET Request).

<img src="./Images/2.JPG">

<br>


3. Get tasks by id (GET Request).

<img src="./Images/3.JPG">

<br>

4. Get tasks by wrong id(id doesn't exist in database).

<img src="./Images/4.JPG">
<br>

<p align="center">Here the task with wrong task id API request gave 404 error.</p>

<br>




5. Get tasks by taskname (GET Request).

<img src="./Images/6.JPG">

<br>

<img src="./Images/8.JPG">
<p align="center">Here we send GET request to an endpoint based on taskname which doesn't exist.Hence it gives 404 error.</p>

<br>



6.Delete tasks by id (DELETE Request).
<br>

<img src="./Images/7.JPG">

<br>
<br>


7.Update tasks by id (PUT Request).
<br>

<img src="./Images/5.JPG">

<br>
<br>
<br>

## How to run

1. Clone the repository.
```bash
  git clone https://github.com/shreyas2711/Kaiburr.git
```
<br>

2. Configure MongoDB connection (in our project we used MongoDB atlas).

<br>


3. Build the application (we used Maven).

<br>

4. Run the application.

<br>
<br>


# Task 2: Kubernetes

Deploy JAVA application(Spring boot application) to Kubernetes.

1. Dockerize your app:
```bash
  docker build -t your-username/my-spring-backend:<tagname> .
```

Here, replace "your-username" with your actual Dockerhub username.

<br>

2. Create Kubernetes manifests(Deployment and Service) and run this command after creating them.

```bash
  kubectl apply -f backend-deployment.yaml
```
<br>


3. In this projct I did not create seperate cluster for MongoDb since I used atlas and atlas manages clusters on its own.

<br>

4. Verify whether your application is deployed on kubernetes.

```bash
  kubectl get pods
  kubectl get services
```

<br>

5. Run your application on Kubernetes.

```bash
kubectl port-forward <your-pod-name> 31185:9090
```
<br>

6. Navigate to the application on the browser: http://localhost:31185/tasks.



## Screenshots

1. Get pods:

<img src="./Images/33.JPG">

<br>
<br>

2. Get services:

<img src="./Images/32.JPG">

<br>
<br>


3. curl command to retrieve data from the server.

<img src="./Images/39.JPG">

<br>
<br>



# Task 3: Web UI Forms

1. Frontend was built using React.js

<img src="./Images/40.JPG">

<br>
<br>

2. Show data based on "taskname" 

<img src="./Images/41.JPG">

<br>
<br>


3. Create a task form page to create tasks from the frontend.

<img src="./Images/42.JPG">

<br>

<img src="./Images/43.JPG">

<br>
<br>


4. You can also delete a task from the UI.

<img src="./Images/12.jpeg">

<br>
<br>


## How to run:

1. Navigate to cloned-project-folder/frontend/my-app.

```bash
  cd/frontend/my-app
```

<br>


2. Run the app on your localhost using:

```bash
  npm start
```

<br>
<br>



# Task 4: CI-CD Pipeline

This task involves creating CI/CD pipeline for for the backend server.


1. Create workflow file for your pipeline(backend-ci-cd.yml).

2. Include DOCKERHUB_USERNAME and DOCKERHUB_PASSWORD in workflow file.

3. Use Github secret for the repository to store DOCKERHUB_USERNAME and DOCKERHUB_PASSWORD so that while running your workflow using Github actions, Github can directly access the protected credentials of your Docker hub.


4. After pushing changes to your project,go to Github actions in your repository. You can see the workflow of the project in jobs section.

<br>


 ## Screenshots

<img src="./Images/50.JPG">

<br>

<img src="./Images/51.JPG">

<br>
<br>
<br>


## Author: 
- ## [Shreyas Kamath](https://github.com/shreyas2711)



