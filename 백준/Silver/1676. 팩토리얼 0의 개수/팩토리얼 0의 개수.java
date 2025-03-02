import java.beans.PropertyEditorSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.util.Collections.sort;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int count = 0;
        while(num >= 5){
            count += num /5;
            num /= 5;
        }

        System.out.println(count);

    }
}


