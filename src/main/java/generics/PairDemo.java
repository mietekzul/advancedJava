package generics;

public class PairDemo {
	public static void main(String[] args) {
		Pair<Integer> pair = new Pair<>(3, 4);
		System.out.println(pair);
		pair = pair.swap();
		System.out.println(pair);

		Pair<Integer> secondPair = new Pair<>(5, 12);
		System.out.println(secondPair);
		Pair.swap(secondPair);
		System.out.println(secondPair);

		Pair.<Integer>swap(secondPair);
		System.out.println(secondPair);
	}
}
