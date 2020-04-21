import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
        import java.util.List;
/**
 * Этот класс нужен для записи в файл формата xml
 */
@XmlRootElement(name="lists")
public class SpaceMarineList{
    List<SpaceMarine> SpaceMarineList;
    public List<SpaceMarine> getSpaceMarineList() {
        return SpaceMarineList;
    }
    public void setSpaceMarineList(List<SpaceMarine> SpaceMarineList) {
        this.SpaceMarineList = SpaceMarineList;
    }
}

