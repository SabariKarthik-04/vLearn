// components/SkillCategoryGrid.jsx
import React from 'react';

const SkillCategoryGrid = () => {
  const skills = [
    { name: "Web Development", icon: "💻", learners: 234, teachers: 156 },
    { name: "Photography", icon: "📸", learners: 189, teachers: 98 },
    { name: "AI & ML", icon: "🤖", learners: 345, teachers: 67 },
    { name: "Public Speaking", icon: "🎤", learners: 276, teachers: 89 },
    { name: "Guitar", icon: "🎸", learners: 167, teachers: 124 },
    { name: "Design", icon: "🎨", learners: 298, teachers: 145 }
  ];

  return (
    <section className="py-20">
      <div className="max-w-7xl mx-auto px-6 lg:px-8">
        <h2 className="text-3xl md:text-4xl font-bold text-center text-slate-800 mb-16">
          Featured Skills & Interests
        </h2>
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8">
          {skills.map((skill) => (
            <div 
              key={skill.name} 
              className="bg-white p-6 rounded-2xl shadow-lg hover:shadow-xl transition-all duration-300 hover:-translate-y-1 border border-slate-200"
            >
              <div className="text-5xl mb-4 text-center">{skill.icon}</div>
              <h3 className="text-xl font-semibold text-center text-slate-800 mb-4">
                {skill.name}
              </h3>
              <div className="flex justify-between text-sm text-slate-600 mb-6">
                <span>👥 {skill.learners} learning</span>
                <span>🧑‍🏫 {skill.teachers} teaching</span>
              </div>
              <button className="w-full bg-indigo-600 hover:bg-indigo-700 text-white py-2 px-4 rounded-lg font-medium transition-colors duration-300">
                Explore Learners / Teachers
              </button>
            </div>
          ))}
        </div>
      </div>
    </section>
  );
};

export default SkillCategoryGrid;
