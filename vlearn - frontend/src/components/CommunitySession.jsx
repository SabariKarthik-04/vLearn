// components/CommunitySession.jsx
import React from 'react';
import SessionCard from './SessionCard';

const CommunitySession = () => {
  const sessions = [
    {
      id: 1,
      title: "Introduction to React Hooks",
      host: "Sarah Chen",
      date: "Aug 15, 2025",
      time: "7:00 PM IST",
      participants: 12,
      maxParticipants: 20,
      skill: "React",
      level: "Beginner"
    },
    {
      id: 2,
      title: "Photography Composition Workshop",
      host: "Miguel Rodriguez",
      date: "Aug 18, 2025",
      time: "6:00 PM CET",
      participants: 8,
      maxParticipants: 15,
      skill: "Photography",
      level: "Intermediate"
    },
    {
      id: 3,
      title: "Python for Data Science",
      host: "Aisha Patel",
      date: "Aug 20, 2025",
      time: "8:00 PM IST",
      participants: 15,
      maxParticipants: 25,
      skill: "Python",
      level: "Beginner"
    }
  ];

  return (
    <section className="py-20">
      <div className="max-w-7xl mx-auto px-6 lg:px-8">
        <div className="text-center mb-12">
          <h2 className="text-3xl md:text-4xl font-bold text-slate-800 mb-4">
            Upcoming Community Sessions
          </h2>
          <p className="text-lg text-slate-600">
            Join open sessions or create your own!
          </p>
        </div>
        
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8 mb-12">
          {sessions.map(session => (
            <SessionCard key={session.id} session={session} />
          ))}
        </div>

        <div className="flex flex-col sm:flex-row gap-4 justify-center">
          <button className="bg-indigo-600 hover:bg-indigo-700 text-white px-8 py-3 rounded-lg font-semibold transition-colors duration-300">
            Host a Knowledge Session
          </button>
          <button className="bg-green-600 hover:bg-green-700 text-white px-8 py-3 rounded-lg font-semibold transition-colors duration-300">
            Join a Skill Exchange
          </button>
        </div>
      </div>
    </section>
  );
};

export default CommunitySession;
