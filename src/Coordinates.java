import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
/**
 * Этот класс описывает координаты
 */
public class Coordinates implements Serializable {
    private int x;
    private int y;
    public Coordinates(){}
    public Coordinates(int x1, int y1) {
        x = x1;
        y = Math.max(y1, -463);
    }

    public int getX() {
        return x;
    }
    public int getY() {return y;}
    public int getCor(){return x+y; }
}