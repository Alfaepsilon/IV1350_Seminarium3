package POSsys.model;
/**
Denna klass representerar varorna
@author Henrik
*/
public class Item{
  public String itemIdentifier = "";
  public int quantity = 0;
  public int price;
  private double VATrate;
/**
Konstruktorn för klassen Item
@author Henrik
 @param itemIdentifier
 @param quantity
 @param price
 @param VATrate
*/
  public Item(String itemIdentifier, int quantity, int price){
      this.itemIdentifier = itemIdentifier;
      this.quantity = quantity;
      this.price = price;
  }

  public String getItemID(){
    return this.itemIdentifier;
  }

  public int getQuantity(){
    return this.quantity;
  }

  public int getPrice(){
    return this.price;
  }
}
