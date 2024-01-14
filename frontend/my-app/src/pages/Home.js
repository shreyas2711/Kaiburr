import React, { useEffect, useState } from 'react';
import './Home.css';
import SearchBar from '../components/SearchBar';

export default function Home() {
    const [searchResults, setSearchResults] = useState([]);
    const [data, setData] = useState([]);
  
    useEffect(() => {                                                              // Trigger GET tasks
      fetch('http://localhost:9091/tasks')
        .then((response) => response.json())
        .then((data) => setData(data))
        .catch((error) => console.error('Error fetching the data!', error));
    }, []);
  
    const handleDelete = (taskId) => {
      fetch(`http://localhost:9091/tasks/delete/${taskId}`, {                    // Trigger DELETE tasks
        method: 'DELETE',
        headers: { Accept: 'application/json', 'Content-Type': 'application/json' },
      })
        .then((response) => response.json())
        .then((data) => {
          console.log('Task deleted successfully!', data);
          setData((prevData) => prevData.filter((task) => task.id !== taskId));
        })
        .catch((error) => {
          console.error('Error deleting the task:', error);
        });
    };
  
    console.log(data);
    // console.log('Search results:', searchResults);

  
    return (
         /* Show tasks based on results*/
      <div className="container">
        <SearchBar setSearchResults={setSearchResults} />
        <div className="task-post">
          {searchResults && searchResults.tasks && searchResults.tasks.length > 0 ? (
            searchResults.tasks.map((task) => (
              <div className="post-elements" key={task.id}>
                <div className="posts">
                <p>Candidate Name: {task.candidateName}</p>                 
                  <p>Task name: {task.name}</p>
                  <p>Task id: {task.id}</p>
                  <p>Assignee: {task.assignee}</p>
                  <p>Task project: {task.project}</p>
                  <p>StartTime: {task.startTime}</p>
                  {/* Uncomment and handle Property Name as needed */}
                  {/* <p>Property Name: {task.can}</p> */}
                  <button onClick={() => handleDelete(task.id)}>&#128465;</button>
                </div>
              </div>
            ))
               /* Else show all tasks */
          ) : (
            data.map((task) => (
              <div className="post-elements" key={task.id}>
                <div className="posts">
                <p>Candidate Name: {task.candidateName}</p>
                  <p>Task name: {task.name}</p>
                  <p>Task id: {task.id}</p>
                  <p>Assignee: {task.assignee}</p>
                  <p>Task project: {task.project}</p>
                  <p>StartTime: {task.startTime}</p>
  
                  <button onClick={() => handleDelete(task.id)}>&#128465;</button>
                </div>
              </div>
            ))
          )}
        </div>
      </div>
    );
  }