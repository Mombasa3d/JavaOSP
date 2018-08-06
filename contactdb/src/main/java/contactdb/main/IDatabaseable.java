package contactdb.main;

public interface IDatabaseable {

	byte[] serialize();
	
	void deserialize(byte[] rawData);
	
	long getId();
	
}
