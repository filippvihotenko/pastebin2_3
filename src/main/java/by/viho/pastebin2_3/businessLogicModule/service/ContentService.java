package by.viho.pastebin2_3.businessLogicModule.service;


import by.viho.pastebin2_3.pasteSendingModule.domain.Content;

import java.util.Optional;
import java.util.UUID;

public interface ContentService
{
    Optional<Content> findContentById(UUID id);

    Content createContent(Content content);

    void deleteContent(UUID id);
}
