import java.util.ArrayList;

public class Board {

   private ArrayList <Tile> tiles;

   // 40 tiles total.
   public Board () {
	   
	   // brown
	   tiles.add(1, new Property (1, "Mediterranean Avenue"));
	   tiles.add(3, new Property (3, "Baltic Avenue"));
	   
	   // light blue
	   tiles.add(6, new Property (6, "Oriental Avenue"));
	   tiles.add(8, new Property (8, "Vermont Avenue"));
	   tiles.add(9, new Property (9, "Connecticut Avenue"));
	   
	   // purple
	   tiles.add(11, new Property (11, "St. Charles Place"));
	   tiles.add(13, new Property (13, "States Avenue"));
	   tiles.add(14, new Property (14, "Virginia Avenue"));
	   
	   // orange
	   tiles.add(16, new Property (16, "St. James Place"));
	   tiles.add(18, new Property (18, "Tennessee Avenue"));
	   tiles.add(19, new Property (19, "New York Avenue"));
	   
	   // red
	   tiles.add(21, new Property (21, "Kentucky Avenue"));
	   tiles.add(23, new Property (23, "Indiana Avenue"));
	   tiles.add(24, new Property (24, "Illinois Avenue"));
	   
	   // yellow
	   tiles.add(26, new Property (26, "Atlantic Avenue"));
	   tiles.add(27, new Property (27, "Ventnor Avenue"));
	   tiles.add(29, new Property (29, "Marvin Gardens"));
	   
	   // green
	   tiles.add(31, new Property (31, "Pacific Avenue"));
	   tiles.add(32, new Property (32, "North Carolina Avenue"));
	   tiles.add(34, new Property (34, "Pennsylvania Avenue"));
	   
	   // blue
	   tiles.add(37, new Property (37, "Park Place"));
	   tiles.add(39, new Property (39, "Boardwalk"));
	   
	   
   }


}