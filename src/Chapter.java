import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;
/**
 * Этот класс описывает SpaceMarine
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Chapter implements Serializable {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String parentLegion;
    private int marinesCount; //Поле может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 1000
    public Chapter(){}
    public  Chapter(String name1,String parentLegion, int marinesCount){
        this.name=name1;
        this.parentLegion=parentLegion;
        this.marinesCount=marinesCount; }
    public int getMarinesCount() {
        return marinesCount;
    }

    public String getName(){
        return name;
    }

    public String getParentLegion(){
        return parentLegion;
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, parentLegion, marinesCount);
    }
}
