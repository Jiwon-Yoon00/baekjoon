import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int total = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
           int num = Integer.parseInt(br.readLine());

           HashMap<String, Integer> hashMap = new HashMap<>();	// <종류, 개수>

            for (int j = 0; j < num; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                st.nextToken();	// 옷 이름은 필요 없음

                String kind = st.nextToken();	// 옷 종류

                /**
                 * 해당 종류의 옷이 해시맵에 있을경우
                 * 해시맵에 저장되어있던 해당 종류의 개수를 +1 증가시킨다.
                 *
                 * 해당 종류의 옷이 해시맵에 없을 경우
                 * 해당 종류와 개수 1을 넣는다.
                 */
                if (hashMap.containsKey(kind)) {
                    hashMap.put(kind, hashMap.get(kind) + 1);
                }
                else {
                    hashMap.put(kind, 1);
                }
            }

            int result = 1;
            for (int val: hashMap.values()) {
                result *= (val + 1);
            }
            System.out.println(result-1);
        }
    }

}