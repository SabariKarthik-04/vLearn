// components/SmartSuggestions.jsx
import React from 'react';

const SmartSuggestions = () => {
  const suggestions = {
    matchingUsers: [
      { name: "Emma Wilson", skill: "React", avatar: "👩‍💻" },
      { name: "John Doe", skill: "Photography", avatar: "👨‍🎨" }
    ],
    suggestedSessions: [
      { title: "Advanced CSS Grid", date: "Tomorrow 7 PM" },
      { title: "Guitar Basics", date: "Friday 6 PM" }
    ],
    newMatches: [
      { name: "Lisa Park", skill: "Python", matchType: "wants to learn what you teach" }
    ]
  };

  return (
    <section className="py-20 bg-slate-50">
      <div className="max-w-7xl mx-auto px-6 lg:px-8">
        <h2 className="text-3xl md:text-4xl font-bold text-center text-slate-800 mb-12">
          Personalized for You
        </h2>
        
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8">
          {/* Matching Users */}
          <div className="bg-white rounded-2xl p-6 shadow-lg">
            <h3 className="text-lg font-semibold text-slate-800 mb-4">
              🧑‍🤝‍🧑 Users who match your skills
            </h3>
            <div className="space-y-4">
              {suggestions.matchingUsers.map((user, index) => (
                <div key={index} className="flex items-center gap-3 p-3 bg-slate-50 rounded-lg">
                  <span className="text-2xl">{user.avatar}</span>
                  <div className="flex-1">
                    <div className="font-medium text-slate-800">{user.name}</div>
                    <div className="text-sm text-slate-600">Wants to learn {user.skill}</div>
                  </div>
                  <button className="bg-indigo-600 hover:bg-indigo-700 text-white px-3 py-1 rounded text-sm font-medium transition-colors duration-300">
                    Connect
                  </button>
                </div>
              ))}
            </div>
          </div>

          {/* Suggested Sessions */}
          <div className="bg-white rounded-2xl p-6 shadow-lg">
            <h3 className="text-lg font-semibold text-slate-800 mb-4">
              📅 Suggested sessions this week
            </h3>
            <div className="space-y-4">
              {suggestions.suggestedSessions.map((session, index) => (
                <div key={index} className="p-3 bg-slate-50 rounded-lg">
                  <div className="font-medium text-slate-800 mb-1">{session.title}</div>
                  <div className="text-sm text-slate-600 mb-3">{session.date}</div>
                  <button className="bg-indigo-600 hover:bg-indigo-700 text-white px-3 py-1 rounded text-sm font-medium transition-colors duration-300">
                    Join
                  </button>
                </div>
              ))}
            </div>
          </div>

          {/* New Matches */}
          <div className="bg-white rounded-2xl p-6 shadow-lg">
            <h3 className="text-lg font-semibold text-slate-800 mb-4">
              🔔 New matches for your learning interests
            </h3>
            <div className="space-y-4">
              {suggestions.newMatches.map((match, index) => (
                <div key={index} className="p-3 bg-slate-50 rounded-lg">
                  <div className="font-medium text-slate-800 mb-1">{match.name}</div>
                  <div className="text-sm text-slate-600 mb-3">
                    Teaches {match.skill} - {match.matchType}
                  </div>
                  <button className="bg-indigo-600 hover:bg-indigo-700 text-white px-3 py-1 rounded text-sm font-medium transition-colors duration-300">
                    View
                  </button>
                </div>
              ))}
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};

export default SmartSuggestions;
