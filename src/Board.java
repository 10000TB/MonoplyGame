import java.util.ArrayList;

public class Board {

   private ArrayList <Tile> tiles;

   // 40 tiles total.
   public Board () {
	   
	   // brown
	   tiles.add(1, new Property (1, "Mediterranean Avenue", new int [] {10, 30, 90, 160, 250}));
	   tiles.add(3, new Property (3, "Baltic Avenue", new int[] {20, 60, 180, 320, 450}));
	   
	   // light blue
	   tiles.add(6, new Property (6, "Oriental Avenue", new int[] {30, 90, 270, 400, 550}));
	   tiles.add(8, new Property (8, "Vermont Avenue", new int[] {30, 90, 270, 400, 550}));
	   tiles.add(9, new Property (9, "Connecticut Avenue", new int[] {40, 100, 300, 450, 600}));
	   
	   // purple
	   tiles.add(11, new Property (11, "St. Charles Place", new int[] {50, 150, 450, 625, 750}));
	   tiles.add(13, new Property (13, "States Avenue", new int[] {50, 150, 450, 625, 750}));
	   tiles.add(14, new Property (14, "Virginia Avenue", new int[] {60, 180, 500, 700, 900}));
	   
	   // orange
	   tiles.add(16, new Property (16, "St. James Place", new int[] {70, 200, 550, 750, 950}));
	   tiles.add(18, new Property (18, "Tennessee Avenue", new int[] {70, 200, 550, 750, 950}));
	   tiles.add(19, new Property (19, "New York Avenue", new int[] {80, 220, 600, 800, 1000}));
	   
	   // red
	   tiles.add(21, new Property (21, "Kentucky Avenue", new int[] {90, 250, 700, 875, 1050}));
	   tiles.add(23, new Property (23, "Indiana Avenue", new int[] {90, 250, 700, 875, 1050}));
	   tiles.add(24, new Property (24, "Illinois Avenue", new int[] {100, 300, 750, 925, 1100}));
	   
	   // yellow
	   tiles.add(26, new Property (26, "Atlantic Avenue", new int[] {110, 300, 800, 975, 1150}));
	   tiles.add(27, new Property (27, "Ventnor Avenue", new int[] {110, 300, 800, 975, 1150}));
	   tiles.add(29, new Property (29, "Marvin Gardens", new int[] {120, 360, 850, 1025, 1200}));
	   
	   // green
	   tiles.add(31, new Property (31, "Pacific Avenue", new int[] {130, 390, 900, 1100, 1275}));
	   tiles.add(32, new Property (32, "North Carolina Avenue", new int[] {130, 390, 900, 1100, 1275}));
	   tiles.add(34, new Property (34, "Pennsylvania Avenue", new int[] {150, 450, 1000, 1200, 1400}));
	   
	   // blue
	   tiles.add(37, new Property (37, "Park Place", new int[] {175, 500, 1100, 1300, 1500}));
	   tiles.add(39, new Property (39, "Boardwalk", new int[] {200, 600, 1400, 1700, 2000}));
	   
	   
   }


}