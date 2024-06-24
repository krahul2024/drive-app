import React, { useState, useRef, useEffect } from 'react';
import { FiChevronDown } from 'react-icons/fi';

interface FilterOption {
  label: string;
  options: { value: string; label: string }[];
}

export const Filter: React.FC = () => {
  const [filters, setFilters] = useState({
    type: 'all',
    view: 'modified',
    location: 'home'
  });

  const [activeFilter, setActiveFilter] = useState<string | null>(null);
  const dropdownRef = useRef<HTMLDivElement>(null);

  const filterOptions: FilterOption[] = [
    {
      label: 'Type',
      options: [
        { value: 'all', label: 'All' },
        { value: 'file', label: 'File' },
        { value: 'folder', label: 'Folder' }
      ]
    },
    {
      label: 'View',
      options: [
        { value: 'modified', label: 'Modified Date' },
        { value: 'name', label: 'Name' },
        { value: 'size', label: 'Size' }
      ]
    },
    {
      label: 'Location',
      options: [
        { value: 'home', label: 'Home' },
        { value: 'bin', label: 'Bin' },
        { value: 'starred', label: 'Starred' }
      ]
    }
  ];

  useEffect(() => {
    function handleClickOutside(event: MouseEvent) {
      if (dropdownRef.current && !dropdownRef.current.contains(event.target as Node)) {
        setActiveFilter(null);
      }
    }

    document.addEventListener('mousedown', handleClickOutside);
    return () => {
      document.removeEventListener('mousedown', handleClickOutside);
    };
  }, []);

  const handleFilterChange = (filterName: string, value: string) => {
    setFilters(prevFilters => ({
      ...prevFilters,
      [filterName]: value
    }));
    setActiveFilter(null);
  };

  const toggleFilter = (filterName: string) => {
    setActiveFilter(activeFilter === filterName ? null : filterName);
  };

  const renderDropdown = ({ label, options }: FilterOption) => {
    const filterName = label.toLowerCase();
    return (
      <div key={filterName} className="relative px-4">
        <button
          onClick={() => toggleFilter(filterName)}
          className="flex items-center justify-end space-x-1 text-sm font-medium text-gray-300 focus:outline-none"
        >
          <span>{label}</span>
          <FiChevronDown className={`transition-transform mt-1 ${activeFilter === filterName ? 'rotate-180' : ''}`} />
        </button>
        {activeFilter === filterName && (
          <div className="absolute mt-2 w-48 bg-gray-800 rounded-lg shadow-lg z-10">
            {options.map(option => (
              <button
                key={option.value}
                className={`flex w-full text-left px-4 py-2 text-sm rounded-md ${
                  filters[filterName as keyof typeof filters] === option.value
                    ? 'hover:bg-gray-700 text-gray-300'
                    : 'text-gray-300 hover:bg-gray-700'
                }`}
                onClick={() => handleFilterChange(filterName, option.value)}
              >
                {option.label}
              </button>
            ))}
          </div>
        )}
      </div>
    );
  };

  return (
    <div className="p-4 shadow rounded-lg" ref={dropdownRef}>
      <div className="flex flex-row space-x-8">
        {filterOptions.map(renderDropdown)}
      </div>
    </div>
  );
}