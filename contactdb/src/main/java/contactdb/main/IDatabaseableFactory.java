package contactdb.main;


public interface IDatabaseableFactory {

	IDatabaseable getInstance();
	
	int getRecordLength();
	
}
