package codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quiz4 {

    static class Node {
        Long key;
        String name;
        boolean isFile;
        boolean idHidden;
        List<Node> children=new ArrayList<>();

        public Node(Long id, String name, boolean isFile, boolean isHidden, Node... children) {
            this.key = id;
            this.name = name;
            this.isFile = isFile;
            this.idHidden = isHidden;
            if (children != null) {
                this.children.addAll(Arrays.asList(children));
            }
        }
    }

    //다음 노드를 방문해서 키워드를 찾는 메소드
    public static void searchKeyword(Node node, String keyword) {
        // 숨겨진 노드는 무시
        if (node == null || node.idHidden) return;
        if (!node.isFile&&!node.name.equals("루트")) {
            // 현재 노드가 디렉토리인 경우
            // 자기 자신 제외
            int count = counting(node, keyword) - (node.name.contains(keyword) ? 1 : 0);
            System.out.println("[" + node.key + "-" + node.name + "]:" + count);
        }
        for (Node child : node.children) {
            searchKeyword(child, keyword);
        }
    }

    //현재 노드부터 자식 노드 끝까지 방문해서 키워드를 포함한 이름 갯수 찾는 메소드
    private static int counting(Node node, String keyword) {
        // 숨겨진 노드는 무시
        if (node.idHidden) return 0;
        int count = node.name.contains(keyword) ? 1 : 0;
        if (!node.isFile) {
            for (Node child : node.children) {
                count += counting(child, keyword);
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {

        // 주어진 입력값
        Node root = new Node(0L, "루트", false, false,
                new Node(1L, "프로젝트 관리", false, false,
                        new Node(2L, "프로젝트-2023", false, false,
                                new Node(3L, "상반기 보고서.pdf", true, false),
                                new Node(4L, "첨부파일", false, false,
                                        new Node(5L, "이미지1.png", true, false),
                                        new Node(7L, "프로젝트 로고.png", true, false)
                                )
                        )
                ),
                new Node(6L, "사용자 관리", false, false,
                        new Node(8L, "사용자-2023", false, false,
                                new Node(9L, "사용자 프로젝트 등록 현황.pdf", true, true),
                                new Node(10L, "첨부파일", false, true,
                                        new Node(11L, "이미지1.png", true, false),
                                        new Node(12L, "프로젝트 로고.png", true, false)
                                )
                        )
                )
        );
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String keyword = br.readLine();
        System.out.println("keyword: " + keyword);
        searchKeyword(root, keyword);
    }
}

