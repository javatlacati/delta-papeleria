package repositorios;

import entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query("Select c from Cliente c where c.nombre like '%?1%'")
    Cliente getOneByName(String name);
}
