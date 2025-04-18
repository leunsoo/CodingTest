import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static Character[][] map;
	static int[] startPos;
	static int[] targetPos;
	static int[] currPos;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; ++tc) {
			sb.append("#").append(tc).append(" ");
			
			N = Integer.parseInt(br.readLine());
			//차윤이가 조종을 연습할 N x N 필드
			map = new Character[N][N];
			startPos = new int[2];
			targetPos = new int[2];
			currPos = new int[2];
			
			
			for(int i = 0; i < N; ++i) {
				String str = br.readLine();
				for(int j = 0; j < N; ++j) {
					map[i][j] = str.charAt(j);

					// 'X' : 현재 RC카의 위치
					// 'Y' : RC카를 이동 시키고자 하는 위치
					if(map[i][j] == 'X') {
						startPos[0] = i;
						startPos[1] = j;
					}
					if(map[i][j] == 'Y') {
						targetPos[0] = i;
						targetPos[1] = j;
					}
				}
			}
			
			// 조종 횟수
			int ctrlCnt = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < ctrlCnt; ++i) {
				String[] ctrls = br.readLine().split(" ");
				
				int cmdCnt = Integer.parseInt(ctrls[0]); //커맨드의 길이
				String cmds = ctrls[1]; // 커맨드
				
				// 출발 위치 초기화
				currPos[0] = startPos[0];
				currPos[1] = startPos[1]; 
				
				currDir = 0; // 항상 위를 바라보는 방향으로 시작
				
				for(int c = 0; c < cmdCnt; ++c) {
					executeCmd(cmds.charAt(c));
				}
				
				// 커맨드를 전부 실행 후 목적지에 도달했는지를 확인
				sb.append(isArrived() ? 1 : 0).append(" ");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	// 상 우 하 좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int currDir;
	
	// 'A' : 앞으로 이동 - 나무가 있는 곳이나 필드를 벗어나는 경우에는 아무 일도 일어나지 않는다.
    // 'L' : 현재 바라보고 있는 방향에서 왼쪽으로 90도 회전
	// 'R' : 현재 바라보고 있는 방향에서 오른쪽으로 90도 회전
	private static void executeCmd(Character cmd) {
		switch (cmd) {
		case 'A' : 
		{
			int nr = currPos[0] + dr[currDir];
			int nc = currPos[1] + dc[currDir];
			
			//나무가 있는 곳이나 필드를 벗어나는 경우에는 아무 일도 일어나지 않는다.
			// 'T' : RC카가 이동이 불가능한 나무
			if(nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 'T') return;
			
			currPos[0] = nr;
			currPos[1] = nc;
		}
		break;
		case 'L' : 
		{
			currDir--;
			currDir = currDir < 0 ? 3 : currDir;
		}
		break;
		case 'R' : 
		{
			currDir++;
			currDir = currDir > 3 ? 0 : currDir;
		}
		break;
		}
	}

	//목적지에 위치 해 있어야 한다
	private static boolean isArrived() {
		return currPos[0] == targetPos[0] && currPos[1] == targetPos[1];
	}
}
