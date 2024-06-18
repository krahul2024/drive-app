import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import profile from '../../assets/profile-pic.webp';
import { RootState } from '../../store';
import { SET_USER, User } from '../../types/user';
import { useDispatch, useSelector } from 'react-redux';
import axios from 'axios';

const Navbar: React.FC = () => {
  const user: User | null = useSelector((state: RootState) => state.user.user);
  const loggedIn : boolean = useSelector((state: RootState) => state.user.loggedIn);
  const dispatch = useDispatch();
  const navigate = useNavigate(); 
  const [isMenuOpen, setIsMenuOpen] = useState(false);

  console.log({ loggedIn })
  const handleMenuClick = () => {
    setIsMenuOpen(!isMenuOpen);

    setTimeout(() => {
      if (isMenuOpen) setIsMenuOpen(false);
    }, 3000)
  };


  const logout = async(event : React.MouseEvent<HTMLButtonElement>) => {
      event.preventDefault(); 
      try{
        const response = await axios.get('/auth/logout', { withCredentials : true }); 
        if(response){
          dispatch({type : SET_USER, payload : {user : null, loggedIn : false}}); 
          navigate('/auth'); 
        }
      } catch(error : any){
        console.log(error.response); 
      }
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
