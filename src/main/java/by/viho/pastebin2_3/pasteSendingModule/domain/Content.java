package by.viho.pastebin2_3.pasteSendingModule.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.net.URL;
import java.util.Date;
import java.util.UUID;
@Document(collection = "Content")
public class Content
{

    private UUID content_id;

    private String content;

    private UUID author_ID;

    public Content(UUID content_id, String content, UUID author_ID)
    {
        this.content_id = content_id;
        this.content = content;
        this.author_ID = author_ID;
    }

    public Content()
    {
    }

    public UUID getContent_id()
    {
        return content_id;
    }

    public void setContent_id(UUID content_id)
    {
        this.content_id = content_id;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public UUID getAuthor_ID()
    {
        return author_ID;
    }

    public void setAuthor_ID(UUID author_ID)
    {
        this.author_ID = author_ID;
    }
}
