import java.util.List;

public class Helper extends Player {
    public Helper (World w, String name, Location location, List<Peach> peaches, int health, RGB rgb){
        super(w,"Helper", w.home, w.home.peachesAtLocation,100,RGB.CYAN);
    }

    public void helperHelps(Player p, Helper h){
        Home homehome = new Home(new Position(0,0),"Home ", null, null);

        if (h.peaches.size()>5){
            for (int i = 0; i <5 ; i++) {
                p.peaches.add(h.peaches.get(i));
                h.peaches.remove(i);
            }

        }
        else{
            for (int i = 0; i <h.peaches.size() ; i++) {
                p.peaches.add(h.peaches.get(i));
                h.peaches.remove(i);
            }
        }
        h.setLocation(homehome);
    }
}
