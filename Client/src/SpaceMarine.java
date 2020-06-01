import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

/**
 * Этот класс описывает SpaceMarine
 */
public class SpaceMarine implements Serializable {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float health; //Поле может быть null, Значение поля должно быть больше 0
    private Boolean loyal; //Поле не может быть null
    private Float height; //Поле может быть null
    private AstartesCategory category; //Поле не может быть null
    private Chapter chapter; //Поле не может быть null
    private long us;// каждому обекту преписывается id пользователя,который его создал
    private int color;

    public SpaceMarine(String name, Coordinates coordinates1, Float health, boolean loyal, Float height2, AstartesCategory category, Chapter chapter1, Long id) {
        this.name = name;
        this.coordinates = coordinates1;
        creationDate =  Date.from(Instant.now());
        this.health = health;
        this.height = height2;
        this.category = category;
        this.loyal = loyal;
        this.chapter = chapter1;
        this.id=id;
    }

    public SpaceMarine(String name, Coordinates coordinates1, Float health, boolean loyal, Float height2, AstartesCategory category, Chapter chapter1,int color) {
        this.name = name;
        this.coordinates = coordinates1;
        creationDate =  Date.from(Instant.now());
        this.health = health;
        this.height = height2;
        this.category = category;
        this.loyal = loyal;
        this.chapter = chapter1;
        this.color=color;
    }

    public SpaceMarine(String name, Coordinates coordinates1, Float health, boolean loyal, Float height2, AstartesCategory category, Chapter chapter1, Long id, long us,int color) {
        this.name = name;
        this.coordinates = coordinates1;
        creationDate =  Date.from(Instant.now());
        this.health = health;
        this.height = height2;
        this.category = category;
        this.loyal = loyal;
        this.chapter = chapter1;
        this.id=id;
        this.us=us;
        this.color=color;
    }


    public int getCoordinates() {
        return this.coordinates.getX() + this.coordinates.getY();
    }

    public int getColor(){return color;};


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

    public long getUs() { return us; }

    public Float getHeight() {
        return height;
    }

    public Chapter getChapter() {
        return chapter;
    }
}
