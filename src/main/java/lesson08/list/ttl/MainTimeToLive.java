package lesson08.list.ttl;

import java.util.List;

/**
 * @author spasko
 */
public class MainTimeToLive {
	private static final int SEC_1 = 1000;
	private static final long SEC_5 = 5000l;

	public static void main(String[] args) {
		List<DummyForTime<String>> dummyForTimes = new ArrayListTime<String>(SEC_5);
		try {
			dummyForTimes.add(new DummyForTime<String>("first"));
			System.out.println("1. " + dummyForTimes.size() + " " + dummyForTimes.toString());
			
			Thread.sleep(SEC_1);
			dummyForTimes.add(new DummyForTime<String>("second"));
			System.out.println("2. " + dummyForTimes.size() + " " + dummyForTimes.toString());
			
			Thread.sleep(SEC_1);
			System.out.println("3. " + dummyForTimes.size() + " " + dummyForTimes.toString());
			
			Thread.sleep(SEC_1);
			System.out.println("4 " + dummyForTimes.size() + " " + dummyForTimes.toString());
			
			Thread.sleep(SEC_1);
			System.out.println("5. " + dummyForTimes.size() + " " + dummyForTimes.toString());
			
			Thread.sleep(SEC_1);
			System.out.println("6. " + dummyForTimes.size() + " " + dummyForTimes.toString());
			
			Thread.sleep(SEC_1);
			System.out.println("7. " + dummyForTimes.size() + " " + dummyForTimes.toString());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
