import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame{
	private World world;
	public Screen(World world){
		super("Demo for A5");
		setSize(world.getWorld()[0].length*200+400,world.getWorld().length*200+200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.world = world;
		JPanel pane=new JPanel(){
			public void paintComponent(Graphics g) {
				for (int i = 0; i<=world.getWorld().length;i++) {
					g.drawLine(0, i*200, world.getWorld()[0].length*200, i*200);
				}
				for (int j = 0; j <= world.getWorld()[0].length;j++) {
					g.drawLine(j*200, 0, j*200, world.getWorld().length*200);
				}
				g.drawLine(world.getWorld()[0].length*200, 0, world.getWorld()[0].length*200,this.getHeight());
				}
		};
		 getContentPane().add(pane);
	}

	public void showScreen() {
        JPanel panel = new JPanel(); 
        this.add(panel);
        this.setLayout(null);
        this.setVisible(true);
        for(int i = 0; i<world.getWorld().length*world.getWorld()[0].length; i++) {
        	JLabel areas = new JLabel(world.getLocations().get(i).getDescription());
        	areas.setBounds(i%world.getWorld().length*200+50,(int)(i/world.getWorld().length)*200,100,50);
            this.add(areas);
        }
        /*
         * JLabel realTimeInformation = new JLabel("Real-time Information:\n"+world.getRealTimeInformation());
         * realTimeInformation.setBounds(20,world.getWorld().length*200+25,world.getWorld().length[0]*200-20,150)
         */
        
        /*
         * JLabel playersInformation = new JLabel("Player Information:\n"+world.getPlayersInformation());
         * realTimeInformation.setBounds(world.getWorld().length[0]*200+20,0,180,this.getHeight())
         */
	}
	
	
	public static void main(String[] arrays) {
		World world = new World();
		Player p = new Player(world, "cat", world.home, new ArrayList<Peach>(), 50, RGB.YELLOW);
	    Player q = new Player(world, "dog", world.home, new ArrayList<Peach>(), 100, RGB.BLUE);
	    world.addPlayer(p).addPlayer(q);
		Screen thisScreen = new Screen(world);
		thisScreen.setVisible(true);
		thisScreen.showScreen();
	}
}

