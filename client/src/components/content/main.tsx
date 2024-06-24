import { Filter } from "./filter";
import { ListItem } from "./listItem";

const Main: React.FC = () => {
  return (<>
        <div>
          <div>
            <Filter/>
          </div>
        <div className="">
          <ListItem title="Documents" type="Folder" ext="folder" iconSize={20}/>
        </div>

        </div>
    </>);
};

export default Main;