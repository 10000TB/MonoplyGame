/*
 * Questions for Property:
 * 
 *
 * 3. what would happen if the morgStatus == true?
 */

public class Property extends Tile{


   private int cost;       		// cost to build one house
   private int rent;
   private int rentData[];
   private int mortgagePrice;  	// cost to mortgage
   private int numOfHouses;
   private int numOfHotels;
   private String owner;
   private boolean morgStatus;
   private boolean canBuild;

   public Property (int position, String desc, int rentData[]) {
	   cost = rentData[0];
	   numOfHouses = 0;
	   numOfHotels = 0;
	   owner = "";
	   mortgagePrice = 0;
	   morgStatus = false;
	   this.canBuild = true;
	   this.rentData = rentData;
	   super.setPosition (position);
	   super.setDesc (desc);
	   super.setType ("property");
   }
   
   // used for electricity tile
   public Property (int position, String desc, int rentData[], boolean canBuild) {
	   this (position, desc, rentData);
	   this.canBuild = canBuild;
   }
  

// get the cost to build house/hotel on the tile
   public int getCost () {
	   return cost;
   }
   
   // get the rent of the property
   public int getRent () {
	   return rent;
   }
   
   // update rent according to the property status
   public void updateRent() {
	   if (numOfHotels == 1) {
		   rent = rentData[4];
	   } else {
		   rent = rentData[numOfHouses];
	   }
	   
	   this.mortgagePrice = (int) (rent * 0.8);

   }
   
   
   // get the price to purchase the property
   public int getPurchasePrice () {
	   return mortgagePrice;
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
   
   
   // property announce morg
   public void setMorg() {
	   morgStatus = true;
   }
   
   // get morg status
   public boolean morg () {
	   return morgStatus;
   }
   
   // return false for electricity tile
   public boolean ifBuildable () {
	   return canBuild;
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
   
   // destroy all houses / hotel on the property tile when bankrupt or so.
   public void clearAll() {
	   numOfHouses = 0;
	   numOfHotels = 0;
	   owner = "";
	   morgStatus = false;
   }
   
   
   
   
   


}