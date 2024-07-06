package by.viho.pastebin2_3.dataAccessModule.util;

import by.viho.pastebin2_3.pasteSendingModule.domain.Person;

public abstract class PostsHelper {
    public static String getPersonUsername(Person person) {
        return person != null ? person.getUsername() : null;
    }
}
