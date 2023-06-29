package fr.studi.promoweb.security.repository;

import fr.studi.promoweb.security.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

    @Query(value = """
        select t from Token t inner join User u\s
        on t.user.id_user = u.id_user\s
        where u.id_user = :id and (t.expired = false or t.revoked = false)\s
        """)
    List<Token> findAllValidTokenByUser(Long id);

    Optional<Token> findByToken(String token);
}
