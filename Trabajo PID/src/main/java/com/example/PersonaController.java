/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    private personaRepository personaRepository;
    @GetMapping
public List<persona> persona() {
    return personaRepository.findAll();
}
    @PostMapping
public persona agregarProducto(@RequestBody persona Persona) {
    return personaRepository.save(Persona);
}
@DeleteMapping("/{id}")
public void borrarProducto(@PathVariable Long id) {
    personaRepository.deleteById(id);
}
 @PutMapping("/{id}")
    public ResponseEntity<persona> actualizarPersona(@PathVariable Long id, @RequestBody persona personaActualizada) {
        Optional<persona> optionalPersona = personaRepository.findById(id);

        if (!optionalPersona.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        persona persona = optionalPersona.get();
        persona.setNombre(personaActualizada.getNombre());

        personaRepository.save(persona);  

        return ResponseEntity.ok(persona);
    }


}
