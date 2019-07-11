/*
* This program shows the swap and time comparisions to execution between a 
* quick Sort and a Bubble Sort algoritim. it outputs to the user the time taken
* for execution of each comparision and the number of swaps completed for a
* collection of an array of Catalogue Items.
*/
package quicksortexam;

/**
 * @Date 11/07/2019.
 * @author jeff/Anotny Jones 92019124
 */
class CatalogueItem {//Catalogue class.
      
    private final Integer id;//set id to Integer type.
    private final String itemName;//set itemName to String type.
    private final String category;//Set category to String type.
    
    // getter methods getItemId.
    public int getItemId(){
    return id;
    }
    //getter method getItemName.
    public String getItemName(){
    return itemName;
    }
    //geteer method getCategory.
    public String getCategory(){
    return category;
    }
    
    // Constructor.
    public CatalogueItem(Integer newId,String newName, String newCategory){

        id = newId;//Set variable id to newId.
        itemName = newName;//Set variable itemName to newName.
        category = newCategory;//Set variable category to newCategory.
    }
    
}