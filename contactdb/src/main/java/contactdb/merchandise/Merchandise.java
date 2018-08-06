package contactdb.merchandise;

import contactdb.main.IDatabaseable;

public class Merchandise implements IDatabaseable {

	public static final int ID_LEN = 20, ITEM_NAME = 128, ITEM_DESC = 255, ITEM_COST = 20;
	
	public static final int MERCH_LEN = (ID_LEN + ITEM_NAME + ITEM_DESC + ITEM_COST);
	
	public static long idIndex = 1;
	private long id;
	private String itemName;
	private String itemDesc;
	private float itemCost;
	
	public Merchandise()
	{
		
	}
	
	public Merchandise(String itemName, String itemDesc, float itemCost)
	{
		this.id = idIndex;
		idIndex ++;
		this.setItemName(itemName);
		this.setItemDesc(itemDesc);
		this.setItemCost(itemCost);
	}
	
	public long getId()
	{
		return id;
	}
	
	public void setId(long id)
	{
		this.id = id;
	}
	
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public float getItemCost() {
		return itemCost;
	}

	public void setItemCost(float itemCost) {
		this.itemCost = itemCost;
	}

	@Override
	public byte[] serialize() {
		String serializedString = String.format(
"%" + ID_LEN + "d%" + ITEM_NAME + "s%" + ITEM_DESC + "s%" + ITEM_COST + "f", this.getId(), this.getItemName(), this.getItemDesc()
				, this.getItemCost());
		return serializedString.getBytes();
	}

	@Override
	public void deserialize(byte[] bytes) {
		String data = new String(bytes);
		int index = 0;
		String id = data.substring(index, ID_LEN).trim();
		index += ID_LEN;
		String iName = data.substring(index, index + ITEM_NAME).trim();
		index += ITEM_NAME;
		String iDesc = data.substring(index, index + ITEM_DESC).trim();
		index += ITEM_DESC;
		String iCost = data.substring(index, index + ITEM_COST).trim();
		index += ITEM_COST;
		this.setId(Long.parseLong(id));
		this.setItemName(iName);
		this.setItemDesc(iDesc);
		this.setItemCost(Float.parseFloat(iCost));
		
	}
	
	@Override
	public String toString()
	{
		return "{" + this.getId() +" " + this.getItemName() + " " + this.getItemDesc() + " " + this.getItemCost() + " }"; 
	}

}
