import React from 'react'
import Navbar from './components/Navbar'
import ProfileCard from './components/ProfileCard'

const ProfilesView = () => {
    const users = [
  {
    "id": "USR001",
    "firstName": "Aarav",
    "middleName": "Kumar",
    "lastName": "Sharma",
    "email": "aarav.sharma@example.com",
    "phoneNumber": "+91-9876543210",
    "dateOfBirth": "2002-05-15",
    "bio": "Passionate full-stack developer with a love for clean code and design.",
    "skills": [
      { "name": "Java", "level": "Intermediate" },
      { "name": "Spring Boot", "level": "Beginner" },
      { "name": "React", "level": "Intermediate" }
    ]
  },
  {
    "id": "USR002",
    "firstName": "Diya",
    "middleName": "Raj",
    "lastName": "Patel",
    "email": "diya.patel@example.com",
    "phoneNumber": "+91-9823475612",
    "dateOfBirth": "2001-11-09",
    "bio": "UI/UX enthusiast and front-end developer skilled in modern frameworks.",
    "skills": [
      { "name": "HTML", "level": "Expert" },
      { "name": "CSS", "level": "Expert" },
      { "name": "JavaScript", "level": "Intermediate" }
    ]
  },
  {
    "id": "USR003",
    "firstName": "Vikram",
    "middleName": "Singh",
    "lastName": "Rathore",
    "email": "vikram.rathore@example.com",
    "phoneNumber": "+91-9638527410",
    "dateOfBirth": "2000-08-21",
    "bio": "Backend engineer focused on building scalable APIs and cloud systems.",
    "skills": [
      { "name": "Node.js", "level": "Intermediate" },
      { "name": "MongoDB", "level": "Intermediate" },
      { "name": "Docker", "level": "Beginner" }
    ]
  },
  {
    "id": "USR004",
    "firstName": "Ananya",
    "middleName": "Suresh",
    "lastName": "Iyer",
    "email": "ananya.iyer@example.com",
    "phoneNumber": "+91-9988776655",
    "dateOfBirth": "2003-02-03",
    "bio": "AI/ML researcher interested in data-driven problem-solving.",
    "skills": [
      { "name": "Python", "level": "Advanced" },
      { "name": "TensorFlow", "level": "Intermediate" },
      { "name": "Keras", "level": "Intermediate" }
    ]
  },
  {
    "id": "USR005",
    "firstName": "Rohan",
    "middleName": "Dev",
    "lastName": "Menon",
    "email": "rohan.menon@example.com",
    "phoneNumber": "+91-9123456780",
    "dateOfBirth": "2002-12-27",
    "bio": "Mobile app developer passionate about Flutter and clean architecture.",
    "skills": [
      { "name": "Flutter", "level": "Advanced" },
      { "name": "Dart", "level": "Advanced" },
      { "name": "Firebase", "level": "Intermediate" }
    ]
  }
]

  return (
    <>
        <Navbar />
        <div className='mt-8 ml-10'>
            <div className='flex gap-10'>
                {users.map(u=>(<ProfileCard user={u}/>))}
                
            </div>
        </div>
    </>
  )
}

export default ProfilesView