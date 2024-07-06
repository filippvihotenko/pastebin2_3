package by.viho.pastebin2_3.dataAccessModule.repository;


import by.viho.pastebin2_3.pasteSendingModule.DTO.PostDTO;
import by.viho.pastebin2_3.pasteSendingModule.domain.Person;
import by.viho.pastebin2_3.pasteSendingModule.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostRepo extends JpaRepository<Post,UUID>
{

    @Query("select new by.viho.pastebin2_3.pasteSendingModule.DTO.PostDTO(" +
            "   m, " +
            "   count(ml), " +
            "   sum(case when ml = :person then 1 else 0 end) > 0" +
            ") " +
            "from Post m left join m.personSet ml " +
            "where m.title ILIKE %:keyword%  " +
            "group by m")
    Page<PostDTO> findByTitleContainingIgnoreCase(@Param("keyword")  String keyword, Pageable pageable, @Param("person") Person person);



    @Query("select new by.viho.pastebin2_3.pasteSendingModule.DTO.PostDTO(" +
            "   m, " +
            "   count(ml), " +
            "   sum(case when ml = :person then 1 else 0 end) > 0" +
            ") " +
            "from Post m left join m.personSet ml " +
            "group by m")
    Page<PostDTO> findAll( Pageable pageable, @Param("person") Person person);


    @Query("select new by.viho.pastebin2_3.pasteSendingModule.DTO.PostDTO(" +
            "   m, " +
            "   count(ml), " +
            "   sum(case when ml = :person then 1 else 0 end) > 0" +
            ") " +
            "from Post m left join m.personSet ml " +
            "where m.person.username = :sender_Id " +
            "group by m")
    Page<PostDTO> findPostBySenderId(@Param("sender_Id") String sender_Id, @Param("person") Person person,  Pageable pageable);

    @Query("select new by.viho.pastebin2_3.pasteSendingModule.DTO.PostDTO(" +
            "   m, " +
            "   count(ml), " +
            "   sum(case when ml = :person then 1 else 0 end) > 0" +
            ") " +
            "from Post m left join m.personSet ml " +
            "where m.title ILIKE %:keyword%  AND m.person.username = :sender_Id " +
            "group by m")
    Page<PostDTO> findPostBySenderIdContainingIgnoreCase(@Param("sender_Id") String sender_Id, @Param("person") Person person,Pageable pageable, @Param("keyword") String keyword);


 }
