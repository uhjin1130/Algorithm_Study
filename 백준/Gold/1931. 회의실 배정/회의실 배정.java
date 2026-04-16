import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bufRead = new BufferedReader( new InputStreamReader(System.in) );
		StringTokenizer strToken = null;

		int N = Integer.parseInt( bufRead.readLine() );
		int [][] time = new int[N][];

		for (int i = 0; i < N; i++) {
			strToken = new StringTokenizer( bufRead.readLine() );
			time[i] = new int[] {Integer.parseInt( strToken.nextToken() )
								, Integer.parseInt( strToken.nextToken() )};
		} // for - time[i][0] : 시작 시간, time[i][1] : 종료 시간

		bufRead.close();

		Arrays.sort(time, (o1, o2)
							-> o1[1] == o2[1]? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1])
		); // Arrays.sort - 끝나는 시간이 같으면 시작 시간으로 정렬, 다르면 종료 시간으로 정렬.

		int [] end = time[0]; // time[0] : 종료 시간이 가장 빠른 회의를 넣고 시작.
		int cnt = 1;

		for (int i = 1; i < time.length; i++) {
			if( end[1] <= time[i][0] ) { // end의 종료 시간보다 time[i]의 시작 시간이 늦다. -> 겹치지 않음.
				end = time[i];
				cnt++;
			} // if
		} // for

		// 결과 값 출력.
		StringBuilder strBuild = new StringBuilder();
		strBuild.append( cnt );
		System.out.println( strBuild.toString() );

	} // main

}