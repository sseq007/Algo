import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] parking = new int[n][m];
            int[] temp = new int[m];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    parking[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cur = 1, sum = 0;

            while(true){

                boolean flag = false;
                loop:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (parking[i][j] == cur) {
                            flag = true;

                            //엘리베이터 왕복
                            sum += (i*2)*10;
                            //컨테이너 가까운 데 찾아서 실행
                            if(j<=m/2){
                                sum+=(j*5);
                            }else{
                                sum+=(m-j)*5;
                            }

                            for (int k = 0; k < m; k++) {
                                temp[(k+m-j)%m]  = parking[i][k];
                            }
                            for (int k = 0; k < m; k++) {
                                parking[i][k]= temp[k];
                            }

                        }
                        if(flag){
                            cur++;
                            break loop;
                        }
                    }

                }
                if(!flag) break;

            }
            System.out.println(sum);
        }

    }
}
