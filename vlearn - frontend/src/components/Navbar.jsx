import React, { useContext, useState } from 'react';
import { VlearnContext } from '../context/VlearnProvider';

const Navbar = () => {
  const { userData } = useContext(VlearnContext);
  const [searchQuery, setSearchQuery] = useState('');

  const handleSearch = (e) => {
    e.preventDefault();
    console.log('Searching for:', searchQuery);
  };

  return (
    <nav className="m-0 border-0 bg-white md:h-[10vh] h-[6vh] w-full flex flex-col justify-center shadow-sm">
      <div className="ml-5 mr-5 flex flex-row justify-between items-center h-full">
        
        {/* Logo */}
        <div className="flex items-center">
          {/* <div className="bg-sky-300 text-white px-3 py-1 rounded-lg font-semibold text-lg tracking-wide shadow-sm"> */}
            VLearn
          {/* </div> */}
        </div>

        {/* Navigation Links */}
        <div className="hidden md:flex items-center space-x-6">
          <button className="hover:text-sky-600 transition-colors font-medium text-gray-700">
            Home
          </button>
          <button className="hover:text-sky-600 transition-colors font-medium relative text-gray-700">
            Messages
            <span className="absolute -top-2 -right-2 bg-red-400 text-white text-xs rounded-full h-5 w-5 flex items-center justify-center">
              3
            </span>
          </button>
          <button className="hover:text-sky-600 transition-colors font-medium relative text-gray-700">
            Notifications
            <span className="absolute -top-2 -right-2 bg-red-400 text-white text-xs rounded-full h-5 w-5 flex items-center justify-center">
              2
            </span>
          </button>
        </div>

        {/* Search */}
        <div className="flex items-center">
          <form onKeyDown={(e)=>{if(e.key=="Enter"){ e.preventDefault();handleSearch();}}} className="relative">
            <input
              type="text"
              placeholder="Search people..."
              value={searchQuery}
              onChange={(e) => setSearchQuery(e.target.value)}
              className="px-3 py-1 rounded-lg border border-gray-300 focus:outline-none focus:ring-2 focus:ring-sky-400 focus:border-transparent text-sm w-32 md:w-48 bg-gray-50"
            />
          </form>
        </div>

        {/* Profile */}
        <div className="flex items-center space-x-2">
          <div className="bg-sky-400 text-white w-8 h-8 rounded-full flex items-center justify-center text-sm font-semibold shadow-sm">
            {userData?.name ? userData.name.charAt(0).toUpperCase() : 'G'}
          </div>
          <span className="hidden md:block font-medium text-gray-700">
            {userData?.name || 'Guest'}
          </span>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
