// components/SessionCard.jsx
import React from 'react';

const SessionCard = ({ session }) => {
  const spotsLeft = session.maxParticipants - session.participants;

  return (
    <div className="bg-white rounded-2xl p-6 shadow-lg border border-slate-200 hover:shadow-xl transition-all duration-300">
      {/* Header Badges */}
      <div className="flex justify-between items-center mb-4">
        <span className="bg-indigo-600 text-white px-3 py-1 rounded-full text-xs font-medium">
          {session.skill}
        </span>
        <span className="bg-slate-100 text-slate-700 px-3 py-1 rounded-full text-xs font-medium">
          {session.level}
        </span>
      </div>
      
      <h3 className="text-lg font-semibold text-slate-800 mb-2">
        {session.title}
      </h3>
      <p className="text-slate-600 mb-4">👤 Hosted by {session.host}</p>
      
      <div className="space-y-2 mb-6 text-sm text-slate-600">
        <div>📅 {session.date} at {session.time}</div>
        <div>👥 {session.participants}/{session.maxParticipants} joined</div>
        {spotsLeft > 0 && (
          <div className="text-green-600 font-medium">
            ⚡ {spotsLeft} spots left
          </div>
        )}
      </div>

      <button className={`w-full py-3 px-4 rounded-lg font-medium transition-colors duration-300 ${
        spotsLeft > 0 
          ? 'bg-indigo-600 hover:bg-indigo-700 text-white' 
          : 'bg-slate-200 text-slate-700 hover:bg-slate-300'
      }`}>
        {spotsLeft > 0 ? 'Join Session' : 'Join Waitlist'}
      </button>
    </div>
  );
};

export default SessionCard;
