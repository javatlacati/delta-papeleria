package repositorios;

import entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NProducto extends JpaRepository<Producto, Integer> {
    @Query("select count (p.stock) from Producto p where p.id = ?1")
    int stockDisponible(int codigo);

    @Query("SELECT max(p.id)+1 from Producto p")
    String codigoSiguiente();
}