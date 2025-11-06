import React, { use } from 'react';
import userImg from '../utils/download.png';

const ProfileCard = ({ user }) => {
  return (
    <div className="backdrop-blur-lg bg-[#D3D3D3]/30 rounded-2xl p-5 w-60 h-80 shadow-md hover:shadow-xl transition-all duration-300">
      <div className="flex flex-col justify-center items-center h-full">
        {/* Profile Image */}
        <img
          src={userImg}
          alt={`${user.firstName}'s profile`}
          className="w-24 h-24 rounded-full object-cover border-2 border-transparent hover:border-[#87CEEB] transition-all duration-200"
        />

        {/* User Info */}
        <div className="flex flex-col justify-center items-center text-center mt-6">
          <h4 className="text-lg font-semibold text-gray-800">{`${user.firstName} ${user.middleName} ${user.lastName}`}</h4>
          <p className="text-sm text-gray-600 mt-1 line-clamp-2">
            {user.bio || "No bio available."}
          </p>

          {/* Skills Section */}
          <div className="mt-4 flex flex-wrap justify-center gap-2">
            {user.skills && user.skills.length > 0 ? (
              user.skills.map((skill, index) => (
                <span
                  key={index}
                  className="text-xs bg-blue-100 text-blue-700 px-2 py-1 rounded-full hover:bg-blue-200 transition-all"
                >
                  {skill.name}
                </span>
              ))
            ) : (
              <p className="text-xs text-gray-500">No skills listed</p>
            )}
          </div>
        </div>
      </div>
    </div>
  );
};

export default ProfileCard;
