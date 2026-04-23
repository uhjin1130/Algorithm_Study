#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int N;
	int total = 0;

	cin >> N;
	if (N < 3 || N>5000) {
		cout << "잘못된 수";
		return 0;
	}

	while (N >= 0) {
		if (N % 5 == 0) {
			total += N / 5;
			cout << total;
			return 0;
		}
		N -= 3;
		total++;
	}
	cout << -1;
}
