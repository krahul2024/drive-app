import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import profile from '../../assets/profile-pic.webp';
import { RootState } from '../../store';
import { SET_USER, User } from '../../types/user';
import { useDispatch, useSelector } from 'react-redux';
import axios from 'axios';
import { Search } from '../content/search';
import driveLogo from '../../../public/drive-logo.png';

const Navbar: React.FC = () => {
  const user: User | null = useSelector((state: RootState) => state.user.user);
  const loggedIn: boolean = useSelector((state: RootState) => state.user.loggedIn);
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const [isMenuOpen, setIsMenuOpen] = useState(false);

  const handleMenuClick = () => {
    setIsMenuOpen(!isMenuOpen);

    setTimeout(() => {
      if (isMenuOpen) setIsMenuOpen(false);
    }, 3000);
  };

  const logout = async (event: React.MouseEvent<HTMLButtonElement>) => {
    event.preventDefault();
    try {
      const response = await axios.get('/auth/logout', { withCredentials: true });
      if (response) {
        dispatch({ type: SET_USER, payload: { user: null, loggedIn: false } });
        navigate('/auth');
      }
    } catch (error: any) {
      console.log(error.response);
    }
  };

  return (
    <nav className="fixed top-0 w-full">
      <div className="md:mx-4 lg:mx-8 2xl:mx-12">
        <div className="flex justify-between items-center">
          <Link to="/" className="flex items-center justify-center">
            <img src={driveLogo} alt="Cloud Drive Logo" className="h-14 mt-1" />
            <div className="text-xl font-bold">Cloud Drive</div>
          </Link>
          <div className='px-4'>
              <Search />
            </div>


          <div className="flex items-center">
            <div className="relative">
              <button
                onClick={handleMenuClick}
                className="flex items-center focus:outline-none"
              >
                <div className="flex items-center space-x-2">
                  <div>
                    <p className="text-md">{user?.name[0]}</p>
                  </div>
                  <div className="h-10 w-10 border-2 border-indigo-900 rounded-full overflow-hidden">
                    <img
                      src={profile}
                      alt="Profile"
                      className="h-full w-full object-cover"
                    />
                  </div>
                </div>
              </button>
              {isMenuOpen && (
                <div className="absolute right-0 mt-4 w-48 bg-secondary border border-gray-800 rounded-md">
                  {loggedIn ? (
                    <>
                      <Link to="/profile" className="block px-4 py-1.5 rounded-sm hover:bg-gray-800">Profile</Link>
                      <Link to="/settings" className="block px-4 py-1.5 rounded-sm hover:bg-gray-800">Settings</Link>
                      <button onClick={logout} className="w-full flex justify-start px-4 py-1.5 rounded-sm hover:bg-gray-800">Logout</button>
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
