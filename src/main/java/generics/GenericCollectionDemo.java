package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.System.out;

public class GenericCollectionDemo {
	public void noGenerics() {
		List nums = new ArrayList();
		nums.add(3);
		nums.add(1);
		nums.add(4);
		nums.add("ooops");
		out.println(nums);

		nums.forEach(out::println);
	}

	public void genericList() {
		List<Integer> nums = new ArrayList<>();
		nums.add(3);
		nums.add(1);
		nums.add(4);
//		nums.add("ooops");	// won't compile
		out.println(nums);


		nums.forEach(out::println);
	}

	public static void main(String[] args) {
		GenericCollectionDemo demo = new GenericCollectionDemo();
		demo.noGenerics();

		demo.genericList();
	}
}
