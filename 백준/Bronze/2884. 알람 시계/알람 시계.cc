#include <stdio.h>

int main(void) {
	int min, hour;

	scanf("%d %d", &hour, &min);

	min -= 45;

	if (min < 0) {
		hour -= 1;
		min += 60;
		if (hour < 0) {
			printf("%d %d", 24 + hour, min);
		}
		else
			printf("%d %d", hour, min);
	}

	else if (min == 0)
		printf("%d %d", hour, min);

	else {
		printf("%d %d", hour, min);
	}

	return 0;
}