package jayt.com.apnabegun.model;

public class NewsItems {

    String id;
    String writer;
    String title;
    String content;
    String image;
    String is_breaking;
    String published_at;

    public NewsItems(String id, String writer, String title, String content, String image, String is_breaking, String published_at) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.image = image;
        this.is_breaking = is_breaking;
        this.published_at = published_at;
    }

    public String getId() {
        return id;
    }

    public String getWriter() {
        return writer;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getImage() {
        return image;
    }

    public String getIs_breaking() {
        return is_breaking;
    }

    public String getPublished_at() {
        return published_at;
    }
}
