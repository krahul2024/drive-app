import React from 'react';
import { FiDownload, FiTrash2, FiEdit, FiCopy, FiFolder, FiShare2, FiFileText } from 'react-icons/fi';
import { IconType } from 'react-icons';

interface OptionProps {
  icon: IconType;
  label: string;
  onClick: () => void;
}

const OptionItem: React.FC<OptionProps> = ({ icon: Icon, label, onClick }) => (
  <div
    className="px-4 py-2 text-sm text-gray-300 hover:bg-gray-700 cursor-pointer flex items-center justify-start rounded-md"
    onClick={onClick}
  >
    <Icon size={20} className="mr-2 text-gray-300" />
    {label}
  </div>
);

export const Options: React.FC = () => {
  const optionsList: OptionProps[] = [
    { icon: FiDownload, label: 'Download', onClick: () => console.log('Download clicked') },
    { icon: FiTrash2, label: 'Delete', onClick: () => console.log('Delete clicked') },
    { icon: FiEdit, label: 'Rename', onClick: () => console.log('Rename clicked') },
    { icon: FiCopy, label: 'Copy', onClick: () => console.log('Copy clicked') },
    { icon: FiFolder, label: 'Move', onClick: () => console.log('Move clicked') },
    { icon: FiShare2, label: 'Share', onClick: () => console.log('Share clicked') },
    { icon: FiFileText, label: 'Properties', onClick: () => console.log('Properties clicked') },
  ];

  return (
    <div className="absolute right-0 mt-2 w-48 bg-gray-900 rounded-xl shadow-lg z-10">
      {optionsList.map((option, index) => (
        <OptionItem key={index} {...option} />
      ))}
    </div>
  );
}