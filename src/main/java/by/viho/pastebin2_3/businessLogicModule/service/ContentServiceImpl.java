package by.viho.pastebin2_3.businessLogicModule.service;


import by.viho.pastebin2_3.dataAccessModule.repository.ContentRepo;
import by.viho.pastebin2_3.pasteSendingModule.domain.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ContentServiceImpl implements ContentService
{
    private final ContentRepo contentRepo;

    @Autowired
    public ContentServiceImpl(ContentRepo contentRepo)
    {
        this.contentRepo = contentRepo;
    }



    @Override
    public Optional<Content> findContentById(UUID id){
        return contentRepo.findById(id);
    }

    @Override
    public Content createContent(Content content)
    {
        return this.contentRepo.save(content);
    }

    @Override
    public void deleteContent(UUID id){
        contentRepo.deleteById(id);
    }
}

