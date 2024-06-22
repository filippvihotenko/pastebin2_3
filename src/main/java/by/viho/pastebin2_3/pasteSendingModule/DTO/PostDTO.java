package by.viho.pastebin2_3.pasteSendingModule.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PostDTO
{
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

}
