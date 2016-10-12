package generics;

public class Tuple<T, U> {
	private T first;
	private U second;

	public Tuple(T first, U second) {
		this.first = first;
		this.second = second;
	}

	public T getFirst() {
		return first;
	}

	public U getSecond() {
		return second;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Tuple{");
		sb.append("first=").append(first);
		sb.append(", second=").append(second);
		sb.append('}');
		return sb.toString();
	}
}
