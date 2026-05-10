import java.util.ArrayList;

public class Board {
    private ArrayList<Post> posts = new ArrayList<>();
    private int idCounter = 1;

    public void addPost(String title, String content, String author) {
        Post post = new Post(idCounter, title, content, author);
        posts.add(post);
        idCounter++;
        System.out.println(">> 게시글이 등록되었습니다.");
    }

    public void showAllPosts() {
        System.out.println("\n--- [게시글 목록] ---");
            if (!posts.isEmpty()) {
                for (Post post : posts) {
                    post.printSummary();
                }
            }

            else {
                System.out.println("등록된 게시글이 없습니다");
            }

        }

    public void viewPost(int id) {
        for (Post post : posts) {
            if (post.getId() == id) {
                System.out.println("\n--- [게시글 상세 정보] ---");
                System.out.print("번호: ");
                System.out.println(post.getId());
                System.out.print("제목: ");
                System.out.println(post.getTitle());
                System.out.print("작성자: ");
                System.out.println(post.getAuthor());
                System.out.print("내용: ");
                System.out.println(post.getContent());
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