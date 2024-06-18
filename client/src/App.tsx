import { BrowserRouter as Router, Route, Routes, } from 'react-router-dom';
import Auth from './components/auth/Auth';
import Error from './Error';
import Nav from './components/nav/Nav';
import { useEffect } from 'react';
import axios from 'axios';
import { SET_USER } from './types/user';
import { useDispatch, useSelector } from 'react-redux';
import { RootState } from './reducers';
import SideBar from './components/nav/SideBar';
import Main from './components/content/main';

const App: React.FC = () => {
  const dispatch = useDispatch();
  const loggedIn = useSelector((state: RootState) => state.user.loggedIn);

  const getUser = async () => {
    try {
      const response = await axios.get('/user', {
        withCredentials: true
      });
      console.log(response.data);
      dispatch({ type: SET_USER, payload: { user: response.data.user, loggedIn: true } });
    } catch (error: any) {
      console.log('Error fetching user:', error.response.data);
      dispatch({ type: SET_USER, payload: { user: null, loggedIn: false } });
    }
  };

  useEffect(() => {
    getUser();
  }, []);


  return (
    <Router>
      <div>
        <div className="flex flex-col">
          <div className="w-full">
            <Nav />
          </div>
          {loggedIn && (
          <div className="flex">
            <div className="w-[220px] md:w-[250px] lg:w-[280px]">
              <SideBar />
            </div>
            <div className="flex-grow mt-[72px]">
              <Main />
            </div>
          </div>
          )}
        </div>

        <div>
          <Routes>
            {!loggedIn ? (
              <Route path="*" element={<Auth />} />
            ) : (<>
              <Route path="/"></Route>
              <Route path="/auth" element={<div><h1>Home Page</h1></div>} />
              <Route path="*" element={<Error />} />
            </>)}
          </Routes>
        </div>
      </div>
    </Router>
  );
};

export default App;
