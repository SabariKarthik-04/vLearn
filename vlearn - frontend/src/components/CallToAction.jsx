// components/CallToAction.jsx
import React from 'react';

const CallToAction = () => {
  return (
    <section className="py-24 bg-gradient-to-br from-slate-800 via-slate-700 to-slate-900 text-white">
      <div className="max-w-4xl mx-auto px-6 lg:px-8 text-center">
        <h2 className="text-3xl md:text-5xl font-bold mb-6">
          Ready to Start Learning and Teaching?
        </h2>
        <p className="text-xl mb-12 opacity-90">
          Join thousands of learners and teachers sharing knowledge every day.
        </p>
        
        <div className="grid grid-cols-1 md:grid-cols-3 gap-8 mb-12">
          <div className="text-center">
            <div className="text-3xl md:text-4xl font-bold text-green-400 mb-2">
              2,500+
            </div>
            <div className="text-lg opacity-80">Active Users</div>
          </div>
          <div className="text-center">
            <div className="text-3xl md:text-4xl font-bold text-green-400 mb-2">
              150+
            </div>
            <div className="text-lg opacity-80">Skills Available</div>
          </div>
          <div className="text-center">
            <div className="text-3xl md:text-4xl font-bold text-green-400 mb-2">
              5,000+
            </div>
            <div className="text-lg opacity-80">Sessions Completed</div>
          </div>
        </div>

        <div className="flex flex-col sm:flex-row gap-4 justify-center">
          <button className="bg-indigo-600 hover:bg-indigo-700 text-white px-8 py-4 rounded-lg font-semibold text-lg transition-all duration-300 transform hover:-translate-y-1">
            Get Started - It's Free
          </button>
          <button className="border-2 border-white text-white hover:bg-white hover:text-slate-800 px-8 py-4 rounded-lg font-semibold text-lg transition-all duration-300">
            Browse Skills
          </button>
        </div>
      </div>
    </section>
  );
};

export default CallToAction;
