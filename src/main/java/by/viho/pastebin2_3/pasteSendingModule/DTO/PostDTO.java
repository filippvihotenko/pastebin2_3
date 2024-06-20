package by.viho.pastebin2_3.pasteSendingModule.DTO;

import java.util.UUID;

public class PostDTO
{
    private UUID post_id;
    private String message;
    private String title;
    private String paste_exposure;

    private String paste_expiration;

    private String cathegory;

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

    public PostDTO()
    {
    }

    public String getCathegory()
    {
        return cathegory;
    }

    public void setCathegory(String cathegory)
    {
        this.cathegory = cathegory;
    }

    public UUID getPost_id()
    {
        return post_id;
    }

    public void setPost_id(UUID post_id)
    {
        this.post_id = post_id;
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
}
