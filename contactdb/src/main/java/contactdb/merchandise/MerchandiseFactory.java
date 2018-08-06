package contactdb.merchandise;

import contactdb.main.IDatabaseable;
import contactdb.main.IDatabaseableFactory;

public class MerchandiseFactory implements IDatabaseableFactory {

	@Override
	public IDatabaseable getInstance() {
		return new Merchandise();
	}

	@Override
	public int getRecordLength() {
		return Merchandise.MERCH_LEN;
	}

}
