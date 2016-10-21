/*
 * Questions for Property:
 * 
 *
 * 3. what would happen if the morgStatus == true?
 */

public class Property extends Tile{


   private int cost;       		// cost to build one house
   private int rent;
   private int purchasePrice;  	// cost to purchase one house
   private int numOfHouses;
   private int numOfHotels;
   private String owner;
   private boolean morgStatus;

   public Property (int position, String desc, String type) {
	   numOfHouses = 0;
	   numOfHotels = 0;
	   owner = "";
	   morgStatus = false;
	   setPosition (position);
	   setDesc (desc);
	   setType (type);
   
   }
   
   
   // get the cost to build house/hotel on the tile
   public int getCost () {
	   return cost;
   }
   
   // get the rent of the property
   public int getRent () {
	   return rent;
   }
   
   // get the price to purchase the property
   public int getPurchasePrice () {
	   return purchasePrice;
   }
   
   // get the number of houses on the tile
   public int getNumOfHouses () {
	   return numOfHouses;
   }
   
   // get the number of hotels on the tile
   public int getNumOfHotels () {
	   return numOfHotels;
   }
   
   // set owner to the property
   public void setOwner (String owner) {
	   this.owner = owner;
   }
   
   // get the owner of the property
   public String getOwner () {
	   return owner;
   }
   
   // get morg status
   public boolean morg () {
	   return morgStatus;
   }
   
   // check if player can buy hotel at the property (4 being the legitimate number).
   public boolean isFullHouse () {
	   return numOfHouses == 4;
   }
   
   // build house on the property # assume isFullHouse checked already
   public void buildHouse () {
	   numOfHouses += 1;
	   updateRent();
	   
   }
   
   // build hotel on the property. # assume isFullHouse checked already
   public void buildHotel () {
	   numOfHouses = 0;
	   numOfHotels = 1;
   }
   
   public void updateRent () {
	   
   }
   
   
   
   
   


}