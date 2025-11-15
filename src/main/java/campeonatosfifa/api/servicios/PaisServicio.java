package campeonatosfifa.api.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import campeonatosfifa.api.dominio.Pais;
import campeonatosfifa.api.repositorios.PaisRepositorio;

@Service
public class PaisServicio {

    @Autowired
    private PaisRepositorio repositorio;

    public List<Pais> listar() {
        return repositorio.findAll();
    }

    public Pais agregar(Pais pais) {
        pais.setId(0);
        return repositorio.save(pais);
    }

    public Pais modificar(Pais pais) {
        if (repositorio.findById(pais.getId()).isPresent()) {
            return repositorio.save(pais);
        } else {
            return null;
        }
    }

    public boolean eliminar(int id) {
        try {
            repositorio.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
