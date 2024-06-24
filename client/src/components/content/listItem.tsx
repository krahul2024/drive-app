import { IconType } from "react-icons";
import icons from "../../assets/icons";
import { useEffect, useRef, useState } from "react";
import { BsThreeDotsVertical } from "react-icons/bs";
import { Options } from "./options";

interface ListItemProps {
    title?: string;
    type?: string;
    ext: string;
    iconSize?: number;
}



export const ListItem: React.FC<ListItemProps> = ({ title, type, ext, iconSize = 24 }) => {
    const [showOptions, setShowOptions] = useState(false);
    const IconComponent: IconType = icons[ext] || icons['default'];
    const optionsRef = useRef<HTMLDivElement>(null);

    useEffect(() => {
        const handleClickOutside = (event: MouseEvent) => {
            if (optionsRef.current && !optionsRef.current.contains(event.target as Node)) {
                setShowOptions(false);
            }
        };

        document.addEventListener('mousedown', handleClickOutside);
        return () => {
            document.removeEventListener('mousedown', handleClickOutside);
        };
    }, []);

    const handleOptionsClick = (e: React.MouseEvent) => {
        e.stopPropagation();
        setShowOptions(!showOptions);
    };

    return (
        <div className="flex items-center justify-between px-4 py-2 hover:bg-gray-800 border border-gray-700 rounded-lg cursor-pointer">
            <div className="flex gap-4 items-center">
                <IconComponent size={iconSize} className="text-slate-400" />
                <div className="font-medium">{title}</div>
            </div>
            <div className="relative" ref={optionsRef}>
                <BsThreeDotsVertical
                    size={20}
                    className="text-gray-500 cursor-pointer"
                    onClick={handleOptionsClick}
                />
                {showOptions && <Options/>}
            </div>
        </div>
    );
};