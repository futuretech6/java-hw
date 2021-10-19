import java.util.HashMap;
import java.util.Scanner;
import java.util.Collections;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String raw = sc.nextLine();
            if (raw.equals(""))
                break;
            // raw = raw.split("POST\\s|GET\\s")[1].split("(\\?\\w*=\\w*)* HTTP")[0];
            String method = (raw.split("\\s")[5]).substring(1);
            raw = raw.split("\\s")[6];
            if (method.equalsIgnoreCase("GET")) {
                raw = raw.split("[\\s\\?]")[0];
            }
            if (map.containsKey(raw))
                map.put(raw, map.get(raw) + 1);
            else
                map.put(raw, 1);
        }

        sc.close();

        int maxNum = Collections.max(map.values());
        TreeSet<String> targetWeb = new TreeSet<>();

        for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxNum)
                targetWeb.add(entry.getKey());
        }

        for (String web : targetWeb) {
            System.out.println(maxNum + ":" + web);
        }

    }
}
/*
 * 10.180.17.246 - - [24/Dec/2017:09:31:44 +0800] "POST /login.php HTTP/1.1" 302
 * 452 "http://fm.zju.edu.cn/"
 * "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_2) AppleWebKit/604.4.7 (KHTML, like Gecko) Version/11.0.2 Safari/604.4.7"
 * 10.180.17.246 - - [24/Dec/2017:09:31:44 +0800] "GET /index.php HTTP/1.1" 200
 * 1400 "http://fm.zju.edu.cn/"
 * "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_2) AppleWebKit/604.4.7 (KHTML, like Gecko) Version/11.0.2 Safari/604.4.7"
 * 10.180.17.246 - - [24/Dec/2017:09:32:17 +0800]
 * "GET /showCourse.php?id=57 HTTP/1.1" 200 1894
 * "http://fm.zju.edu.cn/index.php"
 * "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_2) AppleWebKit/604.4.7 (KHTML, like Gecko) Version/11.0.2 Safari/604.4.7"
 * 
 */