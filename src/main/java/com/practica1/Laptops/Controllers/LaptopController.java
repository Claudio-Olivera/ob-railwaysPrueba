package com.practica1.Laptops.Controllers;
import com.practica1.Laptops.Models.Laptop;
import com.practica1.Laptops.Repository.LaptopRepository;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {
    private final Logger log = LoggerFactory.getLogger(LaptopController.class);
    private LaptopRepository laptopRepository;
    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/api/laptops")
    @Operation(summary = "findAll() - Obtiene todas las Laptops")
    @Parameter(name = "No se necesita especificar parámetros")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }

    @GetMapping("/api/laptops/{id}")
    @Operation(summary = "findOneById() - Obtiene laptop por id")
    public ResponseEntity<Laptop> findOneById(@Parameter(name = "Parámetro de tipo Long") @PathVariable Long id){
        Optional<Laptop> laptopOptional = laptopRepository.findById(id);
        if(laptopOptional.isPresent())
            return ResponseEntity.ok(laptopOptional.get());
        else
            return ResponseEntity.notFound().build();

    }

    @PostMapping("/api/laptops")
    @Operation(summary = "create() - Crea una laptop")
    @Parameter(name = "Parámetro de tipo @RequestBody Laptop")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        if(laptop.getId() != null ){
            log.warn("Intentas agregar una laptop que ya existe");
            return ResponseEntity.badRequest().build();
        }
        Laptop result  = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }



    @PutMapping("/api/laptops")
    @Operation(summary = "update() - Actualiza una laptop por id")
    @Parameter(name = "Parámetro de tipo @RequestBody Laptop")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if (laptop.getId()== null){
            log.warn("Estas intentando actualizar una laptop sin especificar un id");
            return ResponseEntity.badRequest().build();
        }
        if (!laptopRepository.existsById(laptop.getId())){
            log.warn("Ese id de laptop no existe");
            return ResponseEntity.notFound().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    @Hidden
    @DeleteMapping("/api/laptops/{id}")
    @Operation(summary = "delete() - Elimina una laptop por id")
    public ResponseEntity<Laptop> delete(@Parameter(name = "Parámetro de tipo Long") @PathVariable Long id){
        if (!laptopRepository.existsById(id)) {
            log.warn("Ese id de laptop no existe");
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @Hidden
    @DeleteMapping("/api/laptops/")
    @Operation(summary = "deleteAll() - Elimina todas las laptop")
    @Parameter(name = "No se necesita especificar parámetros")
    public ResponseEntity<Laptop> deleteAll(){
        if(laptopRepository.count()== 0){
            log.warn("No existen laptops que eliminar");
            return ResponseEntity.badRequest().build();
        }
        log.info("Estas haciendo un request para eliminar todos los libros");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }


}
