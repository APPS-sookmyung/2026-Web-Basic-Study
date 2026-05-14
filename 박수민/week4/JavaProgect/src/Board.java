import java.util.ArrayList;

public class Board {
    private ArrayList<Post> posts = new ArrayList<>();
    private int idCounter = 1;

    public void addPost(String title, String content, String author) {
        Post post = new Post(idCounter++, title, content, author);
        posts.add(post);
        System.out.println(">> 게시글이 등록되었습니다.");
    }

    public void showAllPosts() {
        System.out.println("\n--- [게시글 목록] ---");
        if (posts.isEmpty()) {
            System.out.println("게시물 목록");
        } else {
            for (Post post : posts) {
                post.printSummary();
            }
        }
    }

    public void viewPost(int id) {
        for (Post post : posts) {
            if (post.getId() == id) {
                System.out.println("\n--- [게시글 상세 정보] ---");
                System.out.println("번호: " + post.getId());
                System.out.println("제목: " + post.getTitle());
                System.out.println("작성자: " + post.getAuthor());
                System.out.println("내용: " + post.getContent());

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