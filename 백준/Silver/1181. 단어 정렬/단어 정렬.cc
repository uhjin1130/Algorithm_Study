#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool compare(const string& a, const string& b) {
	if (a.length() == b.length())
		return a < b;
	return a.length() < b.length();
}

int main() {
	vector<string> library;
	vector<string> order_library;
	int T;
	string word;

	do {
		cin >> T;
	} while (T < 1 || T > 20000);

	cin.ignore();

	while (T--) {
		getline(cin, word);
		if (word.length() <= 50) {
			library.push_back(word);
		}
		else
			T++;
	}

	sort(library.begin(), library.end(), compare);
	library.erase(unique(library.begin(), library.end()), library.end());

	for (int i = 0; i < library.size(); i++)
		cout << library[i] << endl;
}