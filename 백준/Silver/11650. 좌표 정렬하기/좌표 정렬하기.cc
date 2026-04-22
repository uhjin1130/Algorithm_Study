#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool sortcoor(pair<int, int>p1, pair<int, int>p2) {
	if (p1.first == p2.first) {
		return p1.second < p2.second;
	}
	else {
		return p1.first < p2.first;
	}
}

int main() {
	int N;
	cin >> N;
	if (N < 1 || N > 100000) {
		cout << "잘못된 수";
		return 0;
	}

	vector<pair<int, int>>coordinate;
	
	for (int i = 0; i < N; i++) {
		int getx, gety;
		cin >> getx >> gety;
		coordinate.push_back(pair<int, int>(getx, gety));
	}

	sort(coordinate.begin(), coordinate.end(), sortcoor);

	for (int i = 0; i < N; i++) {
		cout << coordinate[i].first << ' ' << coordinate[i].second << '\n';
	}
}
