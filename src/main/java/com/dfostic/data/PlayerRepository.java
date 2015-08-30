package com.dfostic.data;

import java.util.List;
import com.dfostic.beans.Player;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author dfostic
 */
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Player save(Player player);

    List<Player> findByLastName(String lastName);

}
