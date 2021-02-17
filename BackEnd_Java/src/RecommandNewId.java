import java.util.Locale;

public class RecommandNewId {

    /* 단계 별로 순차적으로 해결하는 가장 기본적인 방법ㅇ */
    public static String solution_basic(String new_id) {

        /* 1. 소문자로 변경 */
        new_id = new_id.toLowerCase();

        /* 2. 소문자, 숫자, -, _, . 제외한 나머지 모든 문자 제거 */
        String id  = "";
        for (int i = 0; i < new_id.length(); i++) {
            // 특정 인덱스에 위치하는 유니코드 단일문자를 반환
            char ch = new_id.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                id += String.valueOf(ch); // 문자 id에 반환
            } else if (ch >= '0' && ch <= '9') {
                id += String.valueOf(ch); // 숫자 id에 반환
            } else if (ch == '.' || ch == '_' || ch == '-') {
                id += String.valueOf(ch); // - _ . id에 반환
            }
        }

        /* 3. 반복된 . 하나만 출력 */
        for (int i = 0; i < id.length(); i++) {
            if (id.charAt(i) == '.') {
                int j = i+1;
                String dot = ".";

                while (j != id.length() && id.charAt(j) == '.') {
                    dot += "."; // id에 첫 번째 . 다음에 . 이 추가될 때 마다 dot에 . 하나씩 추가
                    j++;        // j에 1씩 더하면서 반복 검사
                }

                if (dot.length() > 1)
                    id = id.replace(dot, "."); // . 이 2개 이상이면 무조건 . 하나로 대체
            }
        }

        /* 4. 첫번째와 마지막 . 제거 */
        if (id.startsWith(".")) {
            id = id.substring(1, id.length());   // id의 시작 인덱스 값을 1 마지막 인덱스 값을 전체 길이로 설정
        } else if (id.endsWith(".")) {
            id = id.substring(0, id.length()-1); // id의 시작 인덱스 값을 0 마지막 인덱스 값을 전체 길이-1 로 설정
        }

        /* 5. 빈 문자열이라면 a 대입 */
        if(id.length() == 0) {
            id += "a";
        }

        /* 6. 16자 이상이면, 15자만 남김 */
        if(id.length() >= 16) {
            id = id.substring(0, 15);
        }

        // 마지막 . 제거
        if(id.endsWith(".")) {
            id = id.substring(0, id.length()-1);
        }

        /* 7. 2자 이하라면 마지막 문자 길이를 반복하여 3자까지 만듬 */
        String lastch = id.charAt(id.length()-1) + "";
        if (id.length() == 2) {
            id = id + lastch;
        } else if (id.length() == 1) {
            id = id + lastch + lastch;
        }

        return id;
    }

    public static String solution_regex(String new_id) {

        /* 1단계 */
        String id = new_id.toLowerCase();

        /* 2단계 */
        id = id.replaceAll("[^-_.a-z0-9]", ""); // 정규표현식에 해당하는 문자 제외하고 모두 제거

        /* 3단계 */
        id = id.replaceAll("[.]{2,}", "."); // . 2번 이상 반복 시 . 하나로 대체

        /* 4단계 */
        id = id.replaceAll("^[.]|[.]$", ""); // 처음과 끝이 . 이면 제거

        /* 5단계 */
        if (id.equals("")) id += "a"; // 문자열이 비어있으면 a로 대체

        /* 6단계 */
        if (id.length() >= 16) {
            id = id.substring(0, 15);
            id = id.replaceAll("^[.]|[.]$", ""); // 15자가 . 일수도 있으니 끝 . 제거
        }

        if (id.length() <= 2) {
            while (id.length() < 3) {
                id += id.charAt(id.length() - 1);
            }
        }

        return id;
    }

    public static void main(String[] args) {
        String id1 = "...!@BaT#*..y.abcdefghijklm";
        String id2 = "abcdefghijklmn.p";
        String id3 = "z-+.^.";

        String result = solution_basic(id1);
        String result2 = solution_basic(id2);
        String result3 = solution_regex(id3);

        System.out.println(id1);
        System.out.println("====== 변경 후 ======");
        System.out.println(result);

        System.out.println();
        System.out.println(id2);
        System.out.println("====== 변경 후 ======");
        System.out.println(result2);

        System.out.println();
        System.out.println(id3);
        System.out.println("====== 변경 후 ======");
        System.out.println(result3);

    }
}