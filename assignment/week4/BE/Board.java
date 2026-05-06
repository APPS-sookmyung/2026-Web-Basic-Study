import java.util.ArrayList;

public class Board {
    private ArrayList<Post> posts = new ArrayList<>();
    private int idCounter = 1;

    public void addPost(String title, String content, String author) {
        // Post 객체 생성해서 ArrayList에 추가하기. id는 idCounter 이용하여 순서대로 붙여져야 함
        System.out.println(">> 게시글이 등록되었습니다.");
    }

    public void showAllPosts() {
        System.out.println("\n--- [게시글 목록] ---");
        /*
        *
        *
        * 조건문, 반복문 적절히 사용하여
        * 게시글 없을 경우 "등록된 게시글이 없습니다" 출력,
        * 게시글 있을 경우 post.printSummary(); 사용하여 목록 출력
        *
        *
        * */
    }

    public void viewPost(int id) {
        for (Post post : posts) {
            if (post.getId() == id) {
                System.out.println("\n--- [게시글 상세 정보] ---");
                /*
                *
                * 게시글 상세 정보 모두 출력
                *
                * */
                return;
            }
        }
        System.out.println(">> 해당 번호의 게시글을 찾을 수 없습니다.");
    }

    public void deletePost(int id) {
        boolean removed = posts.removeIf(post -> post.getId() == id);
        if (removed) {
            System.out.println(">> " + id + "번 게시글이 삭제되었습니다.");
        } else {
            System.out.println(">> 해당 번호의 게시글을 찾을 수 없습니다.");
        }
    }
}