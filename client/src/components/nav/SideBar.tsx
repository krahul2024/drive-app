import React from 'react';
import { Link } from 'react-router-dom';


const SideBar: React.FC = () => {
    const totalStorage = 100, usedStorage = 27;
    const usedPercentage = (usedStorage / totalStorage) * 100;
    const freePercentage = 100 - usedPercentage;

    return (
        <div className="p-1 flex flex-col w-[220px] md:w-[250px] lg:w-[280px] mt-[60px] fixed">
            <div className="flex items-center justify-start ml-4 mb-4 w-full cursor-pointer">
                <div className="flex flex-col items-center justify-center w-[55%] px-6 py-3 bg-slate-800 rounded-lg">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 24" strokeWidth={2.1} stroke="#e3e3e3" className="size-7">
                        <path strokeLinecap="round" strokeLinejoin="round" d="M12 4.5v15m7.5-7.5h-15" />
                    </svg>
                </div>
            </div>
            <div className="flex flex-col items-center justify-center py-2 px-2 w-full ml-2">
                <div className="flex py-2 px-4 gap-2 w-full rounded-lg hover:bg-slate-800 items-center">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor" className="size-5">
                        <path strokeLinecap="round" strokeLinejoin="round" d="m2.25 12 8.954-8.955c.44-.439 1.152-.439 1.591 0L21.75 12M4.5 9.75v10.125c0 .621.504 1.125 1.125 1.125H9.75v-4.875c0-.621.504-1.125 1.125-1.125h2.25c.621 0 1.125.504 1.125 1.125V21h4.125c.621 0 1.125-.504 1.125-1.125V9.75M8.25 21h8.25" />
                    </svg>
                    Home
                </div>
                <div className="flex py-2 px-4 gap-2 w-full rounded-lg hover:bg-slate-800 items-center">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor" className="size-5">
                        <path strokeLinecap="round" strokeLinejoin="round" d="M12 6v6h4.5m4.5 0a9 9 0 1 1-18 0 9 9 0 0 1 18 0Z" />
                    </svg>
                    Recent
                </div>
                <div className="flex py-2 px-4 gap-2 w-full rounded-lg hover:bg-slate-800 items-center">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor" className="size-5">
                        <path strokeLinecap="round" strokeLinejoin="round" d="M11.48 3.499a.562.562 0 0 1 1.04 0l2.125 5.111a.563.563 0 0 0 .475.345l5.518.442c.499.04.701.663.321.988l-4.204 3.602a.563.563 0 0 0-.182.557l1.285 5.385a.562.562 0 0 1-.84.61l-4.725-2.885a.562.562 0 0 0-.586 0L6.982 20.54a.562.562 0 0 1-.84-.61l1.285-5.386a.562.562 0 0 0-.182-.557l-4.204-3.602a.562.562 0 0 1 .321-.988l5.518-.442a.563.563 0 0 0 .475-.345L11.48 3.5Z" />
                    </svg>
                    Starred
                </div>
                <div className="flex py-2 px-4 gap-2 w-full rounded-lg hover:bg-slate-800 items-center">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor" className="size-5">
                        <path strokeLinecap="round" strokeLinejoin="round" d="m14.74 9-.346 9m-4.788 0L9.26 9m9.968-3.21c.342.052.682.107 1.022.166m-1.022-.165L18.16 19.673a2.25 2.25 0 0 1-2.244 2.077H8.084a2.25 2.25 0 0 1-2.244-2.077L4.772 5.79m14.456 0a48.108 48.108 0 0 0-3.478-.397m-12 .562c.34-.059.68-.114 1.022-.165m0 0a48.11 48.11 0 0 1 3.478-.397m7.5 0v-.916c0-1.18-.91-2.164-2.09-2.201a51.964 51.964 0 0 0-3.32 0c-1.18.037-2.09 1.022-2.09 2.201v.916m7.5 0a48.667 48.667 0 0 0-7.5 0" />
                    </svg>
                    Trash
                </div>
                <div className="flex py-2 px-4 gap-2 w-full rounded-lg hover:bg-slate-800 items-center">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor" className="size-5">
                        <path strokeLinecap="round" strokeLinejoin="round" d="M2.25 15a4.5 4.5 0 0 0 4.5 4.5H18a3.75 3.75 0 0 0 1.332-7.257 3 3 0 0 0-3.758-3.848 5.25 5.25 0 0 0-10.233 2.33A4.502 4.502 0 0 0 2.25 15Z" />
                    </svg>
                    Storage
                </div>
                <div className="py-2 w-[76%] text-xs items-start justify-start mr-2">
                    <div className="relative w-full h-[5px] rounded-xl">
                        <div
                            className="absolute top-0 left-0 h-full bg-indigo-600 rounded-lg"
                            style={{ width: `${usedPercentage}%` }}
                        ></div>
                        <div
                            className="absolute top-0 right-0 h-full bg-neutral-600 rounded-r-lg"
                            style={{ width: `${freePercentage}%` }}
                        ></div>
                    </div>
                    <div className="text-left mt-2">
                        {`${usedStorage*10} MB(${usedPercentage.toFixed(2)}%)  used of ${totalStorage/100} GB`}
                    </div>
                </div>

                <div className='flex items-start justify-start border border-gray-500 mt-2 mr-8 py-2 px-4 rounded-full text-sm hover:font-bold hover:bg-gray-800'>
                    <Link to="/plans"
                        className='text-gray-200 font-semibold'
                        >Get more storage</Link>
                </div>
            </div>
        </div>
    );
};

export default SideBar;
