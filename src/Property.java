public class Property extends Tile{


   private int cost;       // cost to build one house
   private int rent;
   private int purchasePrice;  // cost to purchase one house
   private int numOfHouses;
   private int numOfHotels;
   private String owner;
   private boolean morgStatus;

   public Property (int position, String desc, String type) {
   
      setPosition (position);
      setDesc (desc);
      setType (type);
   
   }
   
   
   
   public int getCost () {
	   return cost;
   }
   
   public int getRent () {
	   return rent;
   }
   
   public int getPurchasePrice () {
	   return purchasePrice;
   }
   
   public int getNumOfHouses () {
	   return numOfHouses;
   }
   
   public int getNumOfHotels () {
	   return numOfHotels;
   }
   
   public String getOwner () {
	   return owner;
   }
   
   public boolean morg () {
	   return morgStatus;
   }
   



}