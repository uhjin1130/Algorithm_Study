import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	static class Calculator {
		public Vector<Integer> arr = new Vector<>(8001);

		public void getAverage() {
			double total = 0;
			double average = 0;
			for (int i : arr) {
				total += i;
			}
			average = Math.round(total / arr.size());
			System.out.println((int) average);
		}

		public void getCenter() {
			Vector<Integer> sortArr = new Vector<>(arr);
			Collections.sort(sortArr);
			System.out.println(sortArr.get(sortArr.size() / 2));
		}

		public void getMostNum() {
			int[] counting = new int[8001]; // -4000부터 4000까지의 숫자를 저장하기 위해 크기를 8001로 설정
			int max = 0, cnt = 0, mode = 0;

			for (int i : arr) {
				counting[i + 4000]++;
			}
			for (int i = 0; i < 8001; i++) {
				if (max < counting[i])
					max = counting[i];
			}

			for (int i = 0; i < 8001; i++) {
				if (max == counting[i]) {
					cnt++;
					mode = i - 4000;
				}
				if (cnt == 2)
					break;
			}
			System.out.println(mode);
		}

		public void getRange() {
			Collections.sort(arr);
			System.out.print(arr.get(arr.size() - 1) - arr.get(0));
		}
	}

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		if (N % 2 == 0 || N < 1 || N > 500000) {
			System.out.print("잘못된 N 값");
			System.exit(0);
		} else {
			while (N != 0) {
				int num = scanner.nextInt();
				calculator.arr.add(num);
				N--;
			}
			calculator.getAverage();
			calculator.getCenter();
			calculator.getMostNum();
			calculator.getRange();
		}
		scanner.close();
	}
}
