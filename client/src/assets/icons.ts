import { IconType } from "react-icons";
import { BsThreeDotsVertical } from "react-icons/bs";
import { FaFilePdf, FaFileWord, FaFilePowerpoint, FaFileCsv, FaFileAlt, FaFileExcel, FaFileArchive, FaFileAudio, FaFileVideo, FaFileImage, FaPython, FaFolderOpen, FaFolderPlus } from "react-icons/fa";
import { IoIosInformationCircleOutline, IoMdShare } from "react-icons/io";
import { MdContentCopy, MdContentPaste, MdDelete, MdDragIndicator, MdEdit, MdError, MdOutlineFileDownload } from "react-icons/md";
import { PiFileCBold, PiFileCppBold } from "react-icons/pi";

const icons : Record<string, IconType> = {
    pdf : FaFilePdf, 
    doc : FaFileWord, 
    docx : FaFileWord, 
    odt : FaFileWord,
    ppt : FaFilePowerpoint, 
    pptx : FaFilePowerpoint, 
    csv : FaFileCsv, 
    txt : FaFileAlt, 
    xls : FaFileExcel, 
    xlsx : FaFileExcel, 
    zip : FaFileArchive, 
    rar : FaFileArchive,
    mp3 : FaFileAudio, 
    mp4 : FaFileVideo, 
    webm : FaFileVideo, 
    mkv : FaFileVideo,
    avi : FaFileVideo,
    ico : FaFileImage, 
    gif : FaFileImage, 
    png : FaFileImage, 
    jpg : FaFileImage, 
    jpeg : FaFileImage, 
    tif : FaFileImage, 
    tiff : FaFileImage, 
    svg : FaFileImage, 
    webp : FaFileImage,
    cc : PiFileCppBold, 
    cpp : PiFileCppBold, 
    c : PiFileCBold, 
    h : PiFileCBold, 
    py : FaPython, 
    pyw : FaPython, 
    default : MdError,
    folder : FaFolderOpen, 
    addFolder : FaFolderPlus,
    download : MdOutlineFileDownload, 
    delete : MdDelete, 
    rename : MdEdit, 
    copy : MdContentCopy, 
    move : MdDragIndicator, 
    share : IoMdShare,
    properties : IoIosInformationCircleOutline,
    listInfo : BsThreeDotsVertical,
}

export default icons ; 
