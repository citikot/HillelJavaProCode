package lesson14.multithreading.list;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MainCopyOnWriteArrayList {

	public static void main(String[] args) {

		List<Integer> list = new CopyOnWriteArrayList<>();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		new WriteThread("Writer", list).start();

		new ReadThread("Reader", list).start();

	}
}

