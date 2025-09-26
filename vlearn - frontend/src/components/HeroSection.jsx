// components/HeroSection.jsx
import React from 'react';

const HeroSection = () => {
  return (
    <section className="bg-gradient-to-br from-indigo-500 via-purple-600 to-purple-700 text-white py-24 relative overflow-hidden">
      <div className="max-w-7xl mx-auto px-6 lg:px-8">
        <div className="grid grid-cols-1 lg:grid-cols-2 gap-16 items-center">
          <div className="text-center lg:text-left">
            <h1 className="text-4xl md:text-5xl lg:text-6xl font-bold leading-tight mb-6">
              Everyone's a Teacher. Everyone's a Learner.
            </h1>
            <p className="text-xl md:text-2xl mb-10 opacity-90 leading-relaxed">
              Share what you know. Learn what you don't. Plan skill-sharing sessions with others like you.
            </p>
            <div className="flex flex-col sm:flex-row gap-4 justify-center lg:justify-start">
              <button className="bg-blue-600 hover:bg-blue-700 text-white px-8 py-4 rounded-lg font-semibold transition-all duration-300 transform hover:-translate-y-1 hover:shadow-lg">
                🔵 Find People to Learn With
              </button>
              <button className="bg-green-600 hover:bg-green-700 text-white px-8 py-4 rounded-lg font-semibold transition-all duration-300 transform hover:-translate-y-1 hover:shadow-lg">
                🟢 Share a Skill
              </button>
            </div>
          </div>
          <div className="flex justify-center">
            <div className="grid grid-cols-2 gap-8">
              <span className="text-6xl animate-bounce delay-0">💻</span>
              <span className="text-6xl animate-bounce delay-300">📸</span>
              <span className="text-6xl animate-bounce delay-700">🎸</span>
              <span className="text-6xl animate-bounce delay-1000">🎯</span>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};

export default HeroSection;
