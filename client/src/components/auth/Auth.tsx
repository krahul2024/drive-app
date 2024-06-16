import { useState } from 'react';
import axios from 'axios';
import {SET_USER, User}from '../../types/user'; 
import { AppDispatch } from '../../store';
import { useDispatch } from 'react-redux';
import { useNavigate } from 'react-router-dom';

const AuthPage: React.FC = () => {
    const navigate = useNavigate(); 
    const [isLogin, setIsLogin] = useState(true);
    const [formData, setFormData] = useState({
        name: '', email: '', password: ''
    });
    const dispatch : AppDispatch = useDispatch(); 

    const toggleMode = () => {
        setIsLogin(prevState => !prevState);
    };

    const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = event.target;
        setFormData((prevState => ({
            ...prevState, [name]: value
        })));
    };

    const handleFormSubmit = async (event: React.MouseEvent<HTMLButtonElement>) => {
        event.preventDefault();
        console.log({formData}); 
        if (isLogin) {  // Handle login form submission 
            try {
                const response = await axios.post('/auth/login', formData);
                const user : User = response?.data?.user; 
                dispatch({type : SET_USER, payload : {user : user, loggedIn : true}}); 

                if(user) navigate('/'); 
            } catch (error) {
                console.log((error as any).response.data);
            }
            
        }
        else {  // Handle registration form submission 
            try {
                const response = await axios.post('/auth/register', formData);
                console.log(response);
            } catch (error) {
                console.log(error);
            }

        }
    }; 


    return (
        <div className={`flex items-center justify-center h-screen bg-gray-900 md:space-x-[8%]`}>
            <div className="flex flex-col justify-center items-center">
                <div className="max-w-md p-6">
                    {isLogin ? (
                        <>
                            <div className="mb-10 text-center">
                                <h2 className="text-4xl font-bold mb-2">Welcome Back!</h2>
                                <p className="text-lg">Login to your account.</p>
                            </div>
                            <button onClick={toggleMode} className="text-lg text-blue-300 hover:text-blue-400 mb-4 block mx-auto">
                                Create New Account
                            </button>
                        </>
                    ) : (
                        <>
                            <div className="mb-10 text-center">
                                <h2 className="text-4xl font-bold mb-2">Create Account</h2>
                                <p className="text-lg">Sign up for a new account.</p>
                            </div>
                            <button onClick={toggleMode} className="text-lg text-blue-300 hover:text-blue-400 mb-4 block mx-auto">
                                Back to Login
                            </button>
                        </>
                    )}
                </div>
            </div>
            <div className={`flex justify-center items-center ${isLogin ? 'mb-24' : 'mb-16'}`}>
                <div className="max-w-md p-2 shadow-md rounded-lg">
                    <h1 className="text-3xl font-bold mb-8 text-center">{isLogin ? 'Login' : 'Register'}</h1>
                    <form className="space-y-4">
                        <input type="email" placeholder="Email" name="email" value={formData.email} onChange={handleChange}
                            className="w-full outline-none bg-slate-700 p-2 border border-gray-800 rounded-md"
                        />
                        {!isLogin && (
                            <input type="text" placeholder="Name" name="name" value={formData.name} onChange={handleChange}
                                className="w-full outline-none bg-slate-700 p-2 border border-gray-800 rounded-md"
                            />
                        )}
                        <input type="password" placeholder="Password" name="password" value={formData.password} onChange={handleChange}
                            className="w-full outline-none bg-slate-700 p-2 border border-gray-800 rounded-md"
                        />

                        <div className="flex justify-start">
                            <button className="bg-blue-500 hover:bg-blue-600 py-1 px-4 w-full rounded-xl"
                                onClick={handleFormSubmit}
                            >
                                {isLogin ? 'Login' : 'Register'}
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
};

export default AuthPage;
