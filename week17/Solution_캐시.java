package kio.week17;
import java.util.*;


public class Solution_캐시 {
    private static class Node {
        String city;
        Node prev, next;

        Node(String city) {
            this.city = city;
        }
    }
    // 노드 제거
    private static void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 노드를 head 바로 뒤로 추가
    private static void addToFront(Node node, Node head) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    static public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        HashMap<String, Node> map = new HashMap<>();
        Node head = new Node(""); // 더미 head
        Node tail = new Node(""); // 더미 tail
        head.next = tail;
        tail.prev = head;

        for (String rawCity : cities) {
            String city = rawCity.toLowerCase(); // 대소문자 구분 없음

            if (map.containsKey(city)) { // hit
                answer += 1;
                Node node = map.get(city);
                remove(node);
                addToFront(node, head);
            } else { // miss
                answer += 5;
                Node node = new Node(city);
                addToFront(node, head);
                map.put(city, node);

                if (map.size() > cacheSize) { // 용량 초과
                    Node lru = tail.prev;
                    remove(lru);
                    map.remove(lru.city);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] cities = {
                "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"
        };
        System.out.println(solution(3, cities));
    }
}
