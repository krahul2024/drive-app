import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import profile from '../../assets/profile-pic.webp';
import { RootState } from '../../store';
import { User } from '../../types/user';
import { useSelector } from 'react-redux';

const Navbar: React.FC = () => {
  const user: User | null = useSelector((state: RootState) => state.user.user);
  const loggedIn : boolean = useSelector((state: RootState) => state.user.loggedIn);
  console.log({ user })
  const [isMenuOpen, setIsMenuOpen] = useState(false);

  console.log({ loggedIn })
  const handleMenuClick = () => {
    setIsMenuOpen(!isMenuOpen);

    setTimeout(() => {
      if (isMenuOpen) setIsMenuOpen(false);
    }, 3000)
  };
  return (
    <nav className="bg-gray-900 p-3 fixed top-0 w-full">
      <div className="md:mx-4 lg:mx-8 2xl:mx-12">
        <div className="flex justify-between items-center">
          <div className="flex items-center">
            <Link to="/" className="text-xl font-bold">Cloud Drive</Link>
          </div>
          <div className="flex items-center">
            <div className="relative">
              <button
                onClick={handleMenuClick}
                className="flex items-center focus:outline-none"
              >
                <div className="flex items-center space-x-2">
                  <div>
                    <p className="text-md">{user?.name}</p>
                  </div>
                  <div className="h-12 w-12 border-2 border-indigo-900 rounded-full overflow-hidden">
                    <img
                      src={profile}
                      alt="Profile"
                      className="h-full w-full object-cover"
                    />
                  </div>
                </div>
              </button>
              {isMenuOpen && (
                <div className="absolute right-0 mt-4 w-48 bg-gray-900 border border-gray-700 rounded-md">
                  {loggedIn ? (
                    <>
                      <Link to="/profile" className="block px-4 py-1.5 rounded-sm hover:bg-gray-800">Profile</Link>
                      <Link to="/settings" className="block px-4 py-1.5 rounded-sm hover:bg-gray-800">Settings</Link>
                      <Link to="/logout" className="block px-4 py-1.5 rounded-sm hover:bg-gray-800">Logout</Link>
                    </>
                  ) : (
                    <>
                      <Link to="/auth" className="block px-4 py-1.5 rounded-sm hover:bg-gray-800">Login/Register</Link>
                      <Link to="/about" className="block px-4 py-1.5 rounded-sm hover:bg-gray-800">Know More</Link>
                    </>
                  )}
                </div>
              )}
            </div>
          </div>
        </div>
      </div>
    </nav>
  );
  
  
};

export default Navbar;
