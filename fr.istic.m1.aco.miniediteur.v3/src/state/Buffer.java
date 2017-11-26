package state;

public class Buffer {

	private StringBuffer buffer = new StringBuffer("");

	public StringBuffer getBuffer() {
		return buffer;
	}

	public void setBuffer(StringBuffer buffer) {
		this.buffer = buffer;
	}

	public Buffer clone() {
		Buffer b = new Buffer();
		b.setBuffer(new StringBuffer(buffer.toString()));
		return b;
	}
}
