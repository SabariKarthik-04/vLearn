// components/HowItWorks.jsx
import React from 'react';

const HowItWorks = () => {
  const steps = [
    {
      step: 1,
      title: "Create Your Skill Profile",
      description: "Add what you can teach & what you want to learn.",
      icon: "👤"
    },
    {
      step: 2,
      title: "Discover People",
      description: "Match with users based on skills & interests.",
      icon: "🔍"
    },
    {
      step: 3,
      title: "Plan a 1:1 Session",
      description: "Teach, learn, and grow together.",
      icon: "🤝"
    }
  ];

  return (
    <section className="py-20 bg-slate-50">
      <div className="max-w-7xl mx-auto px-6 lg:px-8">
        <h2 className="text-3xl md:text-4xl font-bold text-center text-slate-800 mb-16">
          How It Works
        </h2>
        <div className="grid grid-cols-1 md:grid-cols-3 gap-8">
          {steps.map((step) => (
            <div 
              key={step.step} 
              className="bg-white p-8 rounded-2xl shadow-lg hover:shadow-xl transition-all duration-300 hover:-translate-y-2 relative text-center"
            >
              <div className="absolute -top-4 -right-4 bg-indigo-600 text-white w-10 h-10 rounded-full flex items-center justify-center font-bold">
                {step.step}
              </div>
              <div className="text-5xl mb-6">{step.icon}</div>
              <h3 className="text-xl font-semibold text-slate-800 mb-4">
                {step.title}
              </h3>
              <p className="text-slate-600">{step.description}</p>
            </div>
          ))}
        </div>
      </div>
    </section>
  );
};

export default HowItWorks;
