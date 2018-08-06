package contactdb.main;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

import javax.management.RuntimeErrorException;

import contactdb.contact.Contact;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class JustDB <T extends IDatabaseable> implements Closeable

{

	public static final int SIZE_LENGTH = Long.BYTES;

	private IDatabaseableFactory factory;
	
//	public ObservableList<Contact> dbList = FXCollections.observableArrayList();
	
	private RandomAccessFile file;
	

	public JustDB(String path, IDatabaseableFactory factory) throws FileNotFoundException {
		this.Initialize(path);
		this.setFactory(factory);
	}


	public IDatabaseableFactory getFactory() {
		return factory;
	}

	public void setFactory(IDatabaseableFactory factory) {
		if(factory == null)
		{
			throw new IllegalArgumentException("Null factory object");
		}
		this.factory = factory;
	}

	public void add(T c) throws IOException {
		byte[] bytes = c.serialize();
		file.seek(findOffset(c.getId()));
		file.write(bytes, 0, bytes.length);
		incrementSize();
	}

	private void incrementSize() throws IOException {
		long size = DBSize();
		NewSize(size + 1);
	}

	private long findOffset(long CID) {
		return (CID * this.factory.getRecordLength()) + SIZE_LENGTH;
	}

	public T findEntry(long id) throws IOException {
		file.seek(findOffset(id));
		byte[] bytes = new byte[this.factory.getRecordLength()];
		file.read(bytes, 0, bytes.length);
		if (bytes[0] == 0) {
			return null;
		}
		@SuppressWarnings("unchecked")
		T c = (T) this.factory.getInstance();
		c.deserialize(bytes);
		return c;
	}

	public void remove(long id) throws IOException {
		file.seek(findOffset(id));
		file.write(0);
	}

	public long DBSize() throws IOException {
		file.seek(0);
		byte[] array = new byte[Long.BYTES];
		file.read(array, 0, array.length);
		ByteBuffer buffer = ByteBuffer.wrap(array);
		return buffer.getLong();
	}

	private void NewSize(long size) throws IOException {
		ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
		buffer.putLong(size);
		file.seek(0);
		file.write(buffer.array(), 0, Long.BYTES);
	}

	public void Initialize(String path) throws FileNotFoundException {
		file = new RandomAccessFile(path, "rw");
	}

	@Override
	public void close() {
		try {
			file.close();
		} catch (IOException f) {
			throw new RuntimeException(f);
		}
	}
}
