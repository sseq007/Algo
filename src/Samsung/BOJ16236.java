package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//아기 상어
public class BOJ16236 {

    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n,cur_x,cur_y,size,min_dist,min_x,min_y,result,count;
    static int[][] map;
    static Queue<Point> q;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    cur_x=i;
                    cur_y=j;
                    map[i][j] = 0;
                }
            }
        }
        result = 0;
        count=0;
        size =2;
        while (true) {
            dist = new int[n][n];
            min_dist = Integer.MAX_VALUE;
            min_x = Integer.MAX_VALUE;
            min_y = Integer.MAX_VALUE;
            bfs(cur_x, cur_y);
            if (min_x == Integer.MAX_VALUE || min_y == Integer.MAX_VALUE) {
                break;
            } else {
                count++;
                cur_x = min_x;
                cur_y = min_y;
                result += dist[min_x][min_y];
                map[min_x][min_y]=0;
                if (count == size) {
                    size++;
                    count=0;
                }

            }
        }
        System.out.println(result);

    }

    private static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if(0>nx||0>ny||nx>=n||ny>=n) continue;
                if(size<map[nx][ny]) continue;
                if(dist[nx][ny]!=0) continue;
                dist[nx][ny]=dist[cur.x][cur.y]+1;
                q.add(new Point(nx, ny));
                if (map[nx][ny] < size && map[nx][ny] != 0) {
                    if (min_dist > dist[nx][ny]) {
                        min_dist = dist[nx][ny];
                        min_x = nx;
                        min_y=ny;
                    } else if (min_dist == dist[nx][ny]) {
                        if (min_x > nx) {
                            min_x = nx;
                            min_y = ny;
                        } else if (min_x == nx) {
                            if (min_y > ny) {
                                min_x = nx;
                                min_y = ny;
                            }
                        }
                    }
                }
            }
        }
    }


}
