import java.sql.SQLException;
import java.util.Scanner;

public class Replace {
    public boolean replace(Scanner Replace, long key, int anInt, String name2, int x, int y, float hel) throws SQLException {
                if (anInt == 1) {
                    if (name2.length() < Collection.map.get(key).getName().length()) {
                        SpaceMarine sp = new SpaceMarine(name2, new Coordinates(Collection.map.get(key).getCordinatesX(), Collection.map.get(key).getCordinatesY()), Collection.map.get(key).getHealth(), Collection.map.get(key).getLoyal(), Collection.map.get(key).getHeight(), Collection.map.get(key).getCategory(), Collection.map.get(key).getChapter(), Collection.map.get(key).getId(), Collection.map.get(key).getUs());
                        UpdateTable.up(sp, Collection.map.get(key).getId());
                        Collection.map.put( key,sp);
                        return true;
                    }
                }
                if (anInt == 2) {
                    int a = x+y;
                    if (a < Collection.map.get(key).getCoordinates()) ;
                    { SpaceMarine sp2 = new SpaceMarine(Collection.map.get(key).getName(), new Coordinates(x, y), Collection.map.get(key).getHealth(), Collection.map.get(key).getLoyal(), Collection.map.get(key).getHeight(), Collection.map.get(key).getCategory(), Collection.map.get(key).getChapter(), Collection.map.get(key).getId(), Collection.map.get(key).getUs());
                        UpdateTable.up(sp2, Collection.map.get(key).getId());
                    Collection.map.put(key,sp2);
                    return true;
                    }
                }
                if (anInt == 3) {
                    if (hel < Collection.map.get(key).getHealth()) ;
                    { SpaceMarine rep = new SpaceMarine(Collection.map.get(key).getName(), new Coordinates(Collection.map.get(key).getCordinatesX(), Collection.map.get(key).getCordinatesY()), hel, Collection.map.get(key).getLoyal(), Collection.map.get(key).getHeight(), Collection.map.get(key).getCategory(), Collection.map.get(key).getChapter(), Collection.map.get(key).getId(), Collection.map.get(key).getUs());
                        UpdateTable.up(rep, Collection.map.get(key).getId());
                    Collection.map.put(key, rep);
                    return true;
                    }
                }
        return false;
    }
    }
