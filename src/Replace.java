import java.util.Scanner;

public class Replace {
    public void replace(Scanner Replace, long key,int anInt,String name2,int x,int y,float hel) {
                System.out.println("Введите что вы хотите изменить:1-Имя;2-кординаты;3-количесвто жизней");
                if (anInt == 1) {
                    if (name2.length() < Collection.collection.get(key).getName().length()) {
                        SpaceMarine sp = new  SpaceMarine(name2, new Coordinates(Collection.collection.get(key).getCordinatesX(), Collection.collection.get(key).getCordinatesY()), Collection.collection.get(key).getHealth(), Collection.collection.get(key).getLoyal(), Collection.collection.get(key).getHeight(), Collection.collection.get(key).getCategory(), Collection.collection.get(key).getChapter(), Collection.collection.get(key).getId());
                        Collection.collection.put( key,sp);
                    }
                }
                if (anInt == 2) {
                    int a = x+y;
                    if (a < Collection.collection.get(key).getCoordinates()) ;
                    { SpaceMarine sp2 = new  SpaceMarine(Collection.collection.get(key).getName(), new Coordinates(x, y), Collection.collection.get(key).getHealth(), Collection.collection.get(key).getLoyal(), Collection.collection.get(key).getHeight(), Collection.collection.get(key).getCategory(), Collection.collection.get(key).getChapter(), Collection.collection.get(key).getId());
                    Collection.collection.put(key,sp2);
                    }
                }
                if (anInt == 3) {
                    if (hel < Collection.collection.get(key).getHealth()) ;
                    { SpaceMarine rep = new SpaceMarine(Collection.collection.get(key).getName(), new Coordinates(Collection.collection.get(key).getCordinatesX(), Collection.collection.get(key).getCordinatesY()), hel, Collection.collection.get(key).getLoyal(), Collection.collection.get(key).getHeight(), Collection.collection.get(key).getCategory(), Collection.collection.get(key).getChapter(), Collection.collection.get(key).getId());
                        Collection.collection.put(key, rep);
                    }
                }
            }
    }
