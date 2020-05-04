import java.io.Serializable;

public class AComands implements Serializable {
    Comand comand;
    int i;
    float aFloat;
    Long l;
    String string;

    public AComands(Comand comand){
        this.comand=comand;
    }
    public AComands(Comand comand, Long l){
        this.comand=comand;
        this.l=l;
    }
    public AComands(Comand comand, String string){
        this.comand=comand;
        this.string=string;
    }
    public AComands(Comand comand, int i){
        this.comand=comand;
        this.i=i;
    }
    public AComands(Comand comand, Long l, int i){
        this.comand=comand;
        this.l=l;
        this.i=i;
    }
    public AComands(Comand comand, Float fl){
        this.comand=comand;
        this.aFloat=fl;
    }

    public float getParam() { return aFloat; }
    public Comand getComand() {
        return comand;
    }
    public Long getL() {
        return l;
    }
    public String getString() { return string; }
    public int getI() { return i; }
}
