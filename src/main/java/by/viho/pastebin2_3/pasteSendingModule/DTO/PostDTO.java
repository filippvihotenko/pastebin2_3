package by.viho.pastebin2_3.pasteSendingModule.DTO;

import by.viho.pastebin2_3.pasteSendingModule.domain.Post;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class PostDTO
{

    private UUID post_id;


    @NotBlank
    @Size(min = 1, max = 1000)
    private String message;
    @NotBlank
    @Size(min = 1, max = 30)
    private String title;
    @NotNull
    private String paste_exposure;
    @NotNull
    private String paste_expiration;
    @NotNull
    private String cathegory;

    private String person;

    private Long likes;

    private Boolean meLiked;


    public PostDTO(Post post, Long likes, Boolean meLiked) {
        this.likes = likes;
        this.meLiked = meLiked;
        this.message = post.getMessage();
        this.title = post.getTitle();
        this.paste_exposure = post.getPaste_exposure();
        this.paste_expiration = post.getPaste_expiration();
        this.cathegory = post.getCathegory();
        this.person = post.getPerson().getUsername();
        this.post_id = post.getPost_id();
    }

    public UUID getPost_id() {
        return post_id;
    }

    public void setPost_id(UUID post_id) {
        this.post_id = post_id;
    }

    public Boolean getMeLiked() {
        return meLiked;
    }

    public void setMeLiked(Boolean meLiked) {
        this.meLiked = meLiked;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public String getPaste_exposure()
    {
        return paste_exposure;
    }

    public void setPaste_exposure(String paste_exposure)
    {
        this.paste_exposure = paste_exposure;
    }

    public String getPaste_expiration()
    {
        return paste_expiration;
    }

    public void setPaste_expiration(String paste_expiration)
    {
        this.paste_expiration = paste_expiration;
    }


    public String getCathegory()
    {
        return cathegory;
    }

    public void setCathegory(String cathegory)
    {
        this.cathegory = cathegory;
    }


    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public PostDTO()
    {
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
}
