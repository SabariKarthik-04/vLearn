import React, { useContext, useState } from 'react';
import Select from 'react-select';
import CreatableSelect from 'react-select/creatable';
import { LoginRegisterContext } from './context/LoginRegisterProvider';
import { useNavigate } from 'react-router-dom';
const ExtraUserDetails = () => {
  const {user} = useContext(LoginRegisterContext);
  const nav = useNavigate();
  const [loading, setLoading] = useState(false)
  const [error, setError] = useState('')
  const [success, setSuccess] = useState(false)
  const [about, setAbout] = useState('');
  const [skills_known, setSkills_known] = useState([]);
  const [skills_like_to_learn, setSkills_like_to_learn] = useState([]);
  const [free_days_willing_to_teach, setFree_days_willing_to_teach] = useState([]);
  const [free_days_willing_to_learn, setFree_days_willing_to_learn] = useState([]);

  const detectedTimezone = Intl.DateTimeFormat().resolvedOptions().timeZone;

  const skillList = [
    { value: 'react', label: 'React' },
    { value: 'nodejs', label: 'Node.js' },
    { value: 'python', label: 'Python' },
    { value: 'java', label: 'Java' },
    { value: 'flutter', label: 'Flutter' },
  ];

  const dayList = [
    { value: 'monday', label: 'Monday' },
    { value: 'tuesday', label: 'Tuesday' },
    { value: 'wednesday', label: 'Wednesday' },
    { value: 'thursday', label: 'Thursday' },
    { value: 'friday', label: 'Friday' },
    { value: 'saturday', label: 'Saturday' },
    { value: 'sunday', label: 'Sunday' },
  ];

  async function formSubmit(e) {
    e.preventDefault()
    setLoading(true)
    setError('')
    setSuccess(false)
    const finalData={
        timestamp:new Date().toISOString(),
        userId:user.id,
        about,
        timezone:detectedTimezone,
        skills_known:skills_known.map(s=>s.value),
        skills_like_to_learn:skills_like_to_learn.map(s=>s.value),
        free_days_willing_to_teach: free_days_willing_to_teach.map(s => s.value),
        free_days_willing_to_learn: free_days_willing_to_learn.map(s => s.value),
        meetingIdsToTeach:null,
        meetingIdsToLearn:null,
        ratings_for_this_user:null,
        ratings_by_this_user:null,
    }
    console.log(finalData);
    try {
      const response = await fetch('http://localhost:8080/user/post-user-details', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(finalData),
      })
      if (response.status!=202) {
        throw new Error('Invalid credentials')
      }
      const data = await response.text();
      setSuccess(true)
      nav('/login');
    } catch (err) {
      setError(err.message)
    } finally {
      setLoading(false)
    }
  }

  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-gradient-to-br from-white via-blue-50 to-blue-100 px-2">
      <div className="bg-white shadow-xl rounded-2xl p-4 sm:p-6 md:p-8 w-full max-w-xs sm:max-w-md md:max-w-lg transition-all relative z-10">
        <h3 className="text-blue-400 font-bold text-center mb-4 text-base sm:text-lg">
          Help us get to know you better
        </h3>
        <form onSubmit={formSubmit} className='space-y-4 sm:space-y-6'>
        <div className="mb-4">
          <label className="block text-gray-700 mb-1 font-medium">About</label>
          <input
            type="text"
            className="w-full px-3 py-2 border border-blue-200 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400 transition text-sm sm:text-base"
            value={about}
            onChange={(e) => setAbout(e.target.value)}
            required
          />
        </div>
        <div className="mb-4 z-20">
          <label className="block text-gray-700 mb-1 font-medium">Skills Known</label>
          <CreatableSelect
            isMulti
            options={skillList}
            value={skills_known}
            onChange={(e) => setSkills_known(e)}
            placeholder="Select or add skills..."
            className="text-sm"
            menuPortalTarget={document.body}
            menuPosition="fixed"
            styles={{
              menuPortal: base => ({ ...base, zIndex: 9999 }),
            }}
          />
        </div>
        <div className="mb-4 z-20">
          <label className="block text-gray-700 mb-1 font-medium">Skills Like to Learn</label>
          <CreatableSelect
            isMulti
            options={skillList}
            value={skills_like_to_learn}
            onChange={(e) => setSkills_like_to_learn(e)}
            placeholder="Select or add skills..."
            className="text-sm"
            menuPortalTarget={document.body}
            menuPosition="fixed"
            styles={{
              menuPortal: base => ({ ...base, zIndex: 9999 }),
            }}
          />
        </div>
        <div className="mb-4 z-20">
          <label className="block text-gray-700 mb-1 font-medium">Free Days Willing to Teach</label>
          <Select
            isMulti
            options={dayList}
            value={free_days_willing_to_teach}
            onChange={(e) => setFree_days_willing_to_teach(e)}
            placeholder="Select or add days..."
            className="text-sm"
            menuPortalTarget={document.body}
            menuPosition="fixed"
            styles={{
              menuPortal: base => ({ ...base, zIndex: 9999 }),
            }}
          />
        </div>
        <div className="mb-4 z-20">
          <label className="block text-gray-700 mb-1 font-medium">Free Days Willing to Learn</label>
          <Select
            isMulti
            options={dayList}
            value={free_days_willing_to_learn}
            onChange={(e) => setFree_days_willing_to_learn(e)}
            placeholder="Select or add days..."
            className="text-sm"
            menuPortalTarget={document.body}
            menuPosition="fixed"
            styles={{
              menuPortal: base => ({ ...base, zIndex: 9999 }),
            }}
          />
        </div>
          {error && <div className="text-red-500 text-sm text-center">{error}</div>}
          {success && <div className="text-green-600 text-sm text-center">Login successful!</div>}
          <button
            type="submit"
            className="w-full bg-blue-600 hover:bg-blue-700 text-white font-semibold py-2 rounded-lg shadow transition disabled:opacity-60"
            disabled={loading}
          >
            {loading ? 'Verifying...' : 'Save'}
          </button>
        </form>
      </div>
    </div>
  );
};

export default ExtraUserDetails;
