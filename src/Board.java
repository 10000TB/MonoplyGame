import java.util.ArrayList;

public class Board {

   private ArrayList <Tile> tiles;

   // 40 tiles total.
   public Board () {
	   
	   tiles = new ArrayList <Tile> ();
	   
	   // ---------------------------------- BOTTOM	ROW ------------------------------------------
	   
	   // Go tile
	   tiles.add(new SpecialTile(0, "GO!"));
	   // brown
	   tiles.add(new Property (1, "Mediterranean Avenue", new int [] {60, 10, 30, 90, 160, 250}));	   
	   // community chest
	   tiles.add(new SpecialTile(2, "Community Chest"));  
	   
	   tiles.add(new Property (3, "Baltic Avenue", new int[] {60, 20, 60, 180, 320, 450}));   
	   // income tax
	   tiles.add(new SpecialTile(4, "Income Tax"));
	   // Reading RailRoad
	   tiles.add(new SpecialTile(5, "Reading RailRoad"));
	   
	   // light blue
	   tiles.add(new Property (6, "Oriental Avenue", new int[] {100, 30, 90, 270, 400, 550}));   
	   // chance tile
	   tiles.add(new SpecialTile(7, "Chance"));
	   
	   tiles.add(new Property (8, "Vermont Avenue", new int[] {100, 30, 90, 270, 400, 550}));
	   tiles.add(new Property (9, "Connecticut Avenue", new int[] {120, 40, 100, 300, 450, 600}));
	   
	   
	   
	   // ---------------------------------- LEFT	ROW ------------------------------------------
	   
	   // JAIL tile
	   tiles.add(new SpecialTile (10, "IN JAIL"));
	   // purple
	   tiles.add(new Property (11, "St. Charles Place", new int[] {140, 50, 150, 450, 625, 750}));
	   // electricity tile ---- rent set to flat 40
	   tiles.add(new SpecialTile(12, "Electricity Company"));
	   
	   tiles.add(new Property (13, "States Avenue", new int[] {140, 50, 150, 450, 625, 750}));
	   tiles.add(new Property (14, "Virginia Avenue", new int[] {160, 60, 180, 500, 700, 900}));
	   
	   // Pennsylvania RR
	   tiles.add(new SpecialTile(15, "Pennsylvania RR"));
	   
	   // orange
	   tiles.add(new Property (16, "St. James Place", new int[] {180, 70, 200, 550, 750, 950}));
	   
	   // community chest
	   tiles.add(new SpecialTile (17, "Community Chest"));
	   
	   tiles.add(new Property (18, "Tennessee Avenue", new int[] {180, 70, 200, 550, 750, 950}));
	   tiles.add(new Property (19, "New York Avenue", new int[] {200, 80, 220, 600, 800, 1000}));
	   
	   
	   
	   
	   
	   
	   // ---------------------------------- TOP	ROW ------------------------------------------
	   
	   // free parking tile	--> do nothing
	   tiles.add(new SpecialTile(20, "Free Parking (Just take a rest)"));
	   
	   // red
	   tiles.add(new Property (21, "Kentucky Avenue", new int[] {220, 90, 250, 700, 875, 1050}));
	   
	   // chance tile
	   tiles.add(new SpecialTile(22, "Chance"));
	   
	   tiles.add(new Property (23, "Indiana Avenue", new int[] {220, 90, 250, 700, 875, 1050}));
	   tiles.add(new Property (24, "Illinois Avenue", new int[] {240, 100, 300, 750, 925, 1100}));
	   
	   // B&O RR
	   tiles.add(new SpecialTile(25, "B&O Rail Road"));
	   
	   // yellow
	   tiles.add(new Property (26, "Atlantic Avenue", new int[] {260, 110, 300, 800, 975, 1150}));
	   tiles.add(new Property (27, "Ventnor Avenue", new int[] {260, 110, 300, 800, 975, 1150}));
	   
	   // water works	--> rent set to flat 40
	   tiles.add(new SpecialTile(28, "Water Works"));
	   
	   tiles.add(new Property (29, "Marvin Gardens", new int[] {280, 120, 360, 850, 1025, 1200}));
	   
	   
	   
	   
	   
	   // ---------------------------------- RIGHT	ROW ------------------------------------------
	   
	   // go to jail
	   tiles.add(new SpecialTile (30, "GO TO JAIL"));
	   
	   // green
	   tiles.add(new Property (31, "Pacific Avenue", new int[] {300, 130, 390, 900, 1100, 1275}));
	   tiles.add(new Property (32, "North Carolina Avenue", new int[] {300, 130, 390, 900, 1100, 1275}));
	   
	   // community chest
	   tiles.add(new SpecialTile(33, "Community Chest"));
	   
	   tiles.add(new Property (34, "Pennsylvania Avenue", new int[] {320, 150, 450, 1000, 1200, 1400}));
	   
	   // Short Line station
	   tiles.add(new SpecialTile(35, "Short Line Station"));
	   // chance tile
	   tiles.add(new SpecialTile(36, "Chance"));
	   
	   // blue
	   tiles.add(new Property (37, "Park Place", new int[] {350, 175, 500, 1100, 1300, 1500}));
	   
	   // sales tax
	   tiles.add(new SpecialTile (38, "SUPER TAX"));
	   
	   tiles.add(new Property (39, "Boardwalk", new int[] {400, 200, 600, 1400, 1700, 2000}));
	   
	   
   }
   
   public Tile getTile (int index) {
	   return  index >=0 && index < tiles.size() ? tiles.get(index) : null;
   }
   
   public int getSize() {
	   return tiles.size();
   }
   
   
   public void info() {
   
      for (int i = 0; i < tiles.size(); i++ ){
      
         System.out.print ("Position:  " + i + "   ");
      
         if (tiles.get(i).getType().equals("property")){
            Property p = (Property) tiles.get(i);
            System.out.println (p.getDescription() + "   " + p.getCost());
         } else {
         
            SpecialTile s = (SpecialTile) tiles.get(i);
            System.out.println(s.getDescription());
            
         }
      
      }
   
   }
   
   
}