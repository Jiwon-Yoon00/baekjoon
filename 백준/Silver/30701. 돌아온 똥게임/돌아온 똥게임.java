import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long D = Long.parseLong(st.nextToken()); // 전투력은 곱셈 때문에 long 사용

        List<Long> monsters = new ArrayList<>();
        List<Long> equipments = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            long X = Long.parseLong(st.nextToken());
            if (type == 1) {
                monsters.add(X);
            } else {
                equipments.add(X);
            }
        }

        // 몬스터와 장비 정렬
        Collections.sort(monsters);
        Collections.sort(equipments);

        long current = D;
        int used = 0;
        int i = 0; // 몬스터 인덱스

        // 초기 전투력으로 잡을 수 있는 몬스터 처리
        while (i < monsters.size() && monsters.get(i) < current) {
            current += monsters.get(i);
            used++;
            i++;
        }

        // 장비 처리
        for (long e : equipments) {
            current *= e;
            used++;
            // 장비 얻은 후 잡을 수 있는 몬스터 처리
            while (i < monsters.size() && monsters.get(i) < current) {
                current += monsters.get(i);
                used++;
                i++;
            }
        }

        System.out.println(used);
    }
}
