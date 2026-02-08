import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    boolean[] visited;

    public int solution(String numbers) {
        visited = new boolean[numbers.length()];

        // 길이 1 ~ n 까지 모든 순열 생성
        for (int i = 1; i <= numbers.length(); i++) {
            dfs(numbers, "", i);
        }

        int count = 0;
        for (int num : set) {
            if (isPrime(num)) count++;
        }

        return count;
    }

    // 순열 생성
    private void dfs(String numbers, String current, int depth) {
        if (current.length() == depth) {
            set.add(Integer.parseInt(current));
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(numbers, current + numbers.charAt(i), depth);
                visited[i] = false;
            }
        }
    }

    // 소수 판별
    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
