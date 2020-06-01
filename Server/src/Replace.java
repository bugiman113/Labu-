import java.sql.SQLException;
import java.util.Scanner;

public class Replace {
    public boolean replace(long key, String name2, int x, int y, float hel) throws SQLException {
        int c = 0;
                    if (name2.length() < Collection.map.get(key).getName().length()&& !name2.equals("")) {
                        SpaceMarine sp = new SpaceMarine(name2, new Coordinates(Collection.map.get(key).getCordinatesX(), Collection.map.get(key).getCordinatesY()), Collection.map.get(key).getHealth(), Collection.map.get(key).getLoyal(), Collection.map.get(key).getHeight(), Collection.map.get(key).getCategory(), Collection.map.get(key).getChapter(), Collection.map.get(key).getId(), Collection.map.get(key).getUs(),Collection.map.get(key).getColor());
                        UpdateTable.up(sp, Collection.map.get(key).getId());
                        Collection.map.put( key,sp);
                        c++;
                    }
                    int a = x+y;
                    if (a < Collection.map.get(key).getCoordinates()&&a!=0)
                    { SpaceMarine sp2 = new SpaceMarine(Collection.map.get(key).getName(), new Coordinates(x, y), Collection.map.get(key).getHealth(), Collection.map.get(key).getLoyal(), Collection.map.get(key).getHeight(), Collection.map.get(key).getCategory(), Collection.map.get(key).getChapter(), Collection.map.get(key).getId(), Collection.map.get(key).getUs(),Collection.map.get(key).getColor());
                        UpdateTable.up(sp2, Collection.map.get(key).getId());
                    Collection.map.put(key,sp2);
                    c++;
                    }
                    if (hel < Collection.map.get(key).getHealth() && hel!=0){
                        SpaceMarine rep = new SpaceMarine(Collection.map.get(key).getName(), new Coordinates(Collection.map.get(key).getCordinatesX(), Collection.map.get(key).getCordinatesY()), hel, Collection.map.get(key).getLoyal(), Collection.map.get(key).getHeight(), Collection.map.get(key).getCategory(), Collection.map.get(key).getChapter(), Collection.map.get(key).getId(), Collection.map.get(key).getUs(),Collection.map.get(key).getColor());
                        UpdateTable.up(rep, Collection.map.get(key).getId());
                    Collection.map.put(key, rep);
                    c++;
                    }
                    if (c!=0){return true;}
                    else {return false;}
    }
    }
