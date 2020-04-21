import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;
///**
// * Эти теги нужны для записи xml
// */
//@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(propOrder = {"name","id","coordinates","creationDate","health","loyal","height","category","chapter"})

public class SpaceMarine implements Serializable {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float health; //Поле может быть null, Значение поля должно быть больше 0
    private Boolean loyal; //Поле не может быть null
    private Float height; //Поле может быть null
    private AstartesCategory category; //Поле не может быть null
    private Chapter chapter; //Поле не может быть null

    public SpaceMarine() {
    }

    public SpaceMarine(String name, Coordinates coordinates1, Float health, boolean loyal, Float height2, AstartesCategory category, Chapter chapter1,Long id) {
        this.name = name;
        this.coordinates = coordinates1;
        creationDate =  java.util.Date.from(Instant.now());
        this.health = health;
        this.height = height2;
        this.category = category;
        this.loyal = loyal;
        this.chapter = chapter1;
        this.id=id;
    }

    public SpaceMarine(String name, Coordinates coordinates1, Float health, boolean loyal, Float height2, AstartesCategory category, Chapter chapter1) {
        this.name = name;
        this.coordinates = coordinates1;
        creationDate =  java.util.Date.from(Instant.now());
        this.health = health;
        this.height = height2;
        this.category = category;
        this.loyal = loyal;
        this.chapter = chapter1;
    }

    public int getCoordinates() {
        return this.coordinates.getX() + this.coordinates.getY();
    }

    public int getCordinatesX(){return this.coordinates.getX();}

    public int getCordinatesY(){return this.coordinates.getY();}

    public Date getDate() {
        return creationDate;
    }

    public Float getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public AstartesCategory getCategory() {
        return category;
    }

    public long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, health, coordinates, loyal, chapter, height, id);
    }

    @Override
    public String toString() {
        return name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Boolean getLoyal() {
        return loyal;
    }

    public Float getHeight() {
        return height;
    }

    public Chapter getChapter() {
        return chapter;
    }
}
