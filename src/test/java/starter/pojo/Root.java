package starter.pojo;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import java.util.Objects;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Root {
    private Category category = new Category();
    private String description;
    private String title;
    private int numberOfDownloads;
    @JsonIgnore
    private Object iconData;
    private Author author = new Author();
    @JsonIgnore
    private Object imageData;
    @JsonIgnore
    private long uploadedTimeStamp;

    @Override
    public String toString() {
        return "{" +
                "title=" + title +
                "," + description +
                "," + category.getTitle() +
                "," + author.getName() +
                ",# of downloads: " + numberOfDownloads +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Root root = (Root) o;
        return numberOfDownloads == root.numberOfDownloads && Objects.equals(category.getTitle(), root.category.getTitle())
                && Objects.equals(description, root.description) && Objects.equals(title, root.title) && Objects.equals(author.getName(), root.author.getName());
    }
    @Override
    public int hashCode() {
        return Objects.hash(category.getTitle(), description, title, numberOfDownloads, author.getName());
    }
}

