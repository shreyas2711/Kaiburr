import React, { useState } from 'react'
import './CreateTask.css'
const CreateTask=() => {

const [formData, setFormData] = useState({
    candidateName:'',
    name:'',
    assignee:'',
    project:'',
    startTime:'',
    
});

const handleInputChange=(e)=>{
    const {name,value} = e.target;
    setFormData((prevData) => ({...prevData,[name]:value}));
}

const handleSubmit=(e)=>{
    e.preventDefault();

    fetch('http://localhost:9091/tasks/create',{
        method:'POST',
        headers:{
            'Content-type':'application/json',
        },
        body:JSON.stringify(formData),
    })
    .then((response)=>response.json())
    .then((data)=>{
        console.log('Task created successfully',data);
    })
    .catch((error)=>{
        console.error('Error creating task:',error);
    });
}

  return (
  
      <div className="create-task-body">
      <form onSubmit={handleSubmit}>
      <div>
          <label htmlFor="candidateName">Candidate Name:</label>
          <input style={{marginLeft:'1rem'}} className='enter-input' type="text" id="candidateName" name="candidateName" value={formData.candidateName} onChange={handleInputChange} />
        </div>
      <div>
          <label htmlFor="name">Task Name:</label>
          <input style={{marginLeft:'58px'}} className='enter-input'  type="text" id="name" name="name" value={formData.name} onChange={handleInputChange} />
        </div>
      <div>
          <label htmlFor="assignee">Assignee:</label>
          <input style={{marginLeft:'71px'}} className='enter-input'  type="text" id="assignee" name="assignee"   value={formData.assignee} onChange={handleInputChange} />
        </div>
      <div>
          <label htmlFor="project">Project:</label>
          <input style={{marginLeft:'85px'}} className='enter-input'  type="text" id="project" name="project" value={formData.project} onChange={handleInputChange} />
        </div>
      <div>
          <label htmlFor="startTime">Start Time:</label>
          <input style={{marginLeft:'63px'}} className='enter-input'  type="text" id="startTime" name="startTime" value={formData.startTime} onChange={handleInputChange} />
        </div>
        <button className='submit-class' type="submit" onClick={handleSubmit}>Submit</button>
        </form>

      </div>
      
  )
}
export default CreateTask;