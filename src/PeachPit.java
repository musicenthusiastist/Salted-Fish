import java.util.ArrayList;
import java.util.List;

public class PeachPit extends Location {
    public PeachPit (Position p, List<Player> people, List<Peach> peach_pit){
        super(p, "Peach Pit ", people, peach_pit);
        p.x =1;
        p.y= 1;
        peach_pit = new ArrayList<Peach>(3);
        Peach p1 = new Peach(10);
        Peach p2 = new Peach(8);
        Peach p3 = new Peach(10);

        peach_pit.add(0,p1);
        peach_pit.add(1,p2);
        peach_pit.add(1,p3);
    }

    public void fallIntoPit(Player p , Home home){
        //Check if Player p has fallen into this pit
        for (Player current_p: peopleAtLocation) {
            if(p.equals(current_p)){
                p.setHealth(p.getHealth()/2);
                p.setLocation(home);
            }
        }
        //Player p hasn't been fallen into this pit
        p.setHealth(p.getHealth()/2);
        peopleAtLocation.add(p);
        System.out.println(p.getName() + "just falls into the pit "+ position);
        //Get peaches from the pit
        if(peachesAtLocation.size()>0){
            for (int i = 0; i <peachesAtLocation.size() ; i++) {
                p.peaches.add(peachesAtLocation.get(i));
                peachesAtLocation.remove(i);
            }
        }
    }


}
