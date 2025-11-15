package com.sistema.estoque.controller;

import com.sistema.estoque.model.Veiculo;
import com.sistema.estoque.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
@CrossOrigin(origins = "*")
public class VeiculoController {

    @Autowired
    private VeiculoRepository repository;

    // LISTAR TODOS
    @GetMapping
    public List<Veiculo> listarTodos() {
        return repository.findAll();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Veiculo buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    // CADASTRAR
    @PostMapping
    public Veiculo cadastrar(@RequestBody Veiculo veiculo) {
        return repository.save(veiculo);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public Veiculo atualizar(@PathVariable Long id, @RequestBody Veiculo dados) {
        Veiculo veiculo = repository.findById(id).orElse(null);
        if (veiculo == null) return null;

        veiculo.setMarca(dados.getMarca());
        veiculo.setModelo(dados.getModelo());
        veiculo.setAno(dados.getAno());
        veiculo.setCor(dados.getCor());
        veiculo.setPreco(dados.getPreco());
        veiculo.setQuilometragem(dados.getQuilometragem());
        veiculo.setStatus(dados.getStatus());

        return repository.save(veiculo);
    }

    // DELETAR
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }

    // ===========================================
    // 🔍 FILTRO COMPLETO (CORRIGIDO E FUNCIONAL)
    // ===========================================
    @GetMapping("/filtrar")
    public List<Veiculo> filtrarVeiculos(
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) String modelo,
            @RequestParam(required = false) String ano,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String precoMin,
            @RequestParam(required = false) String precoMax
    ) {
        String marcaNorm = (marca == null || marca.trim().isEmpty()) ? null : marca.trim();
        String modeloNorm = (modelo == null || modelo.trim().isEmpty()) ? null : modelo.trim();
        String statusNorm = (status == null || status.trim().isEmpty()) ? null : status.trim();

        Integer anoInt = null;
        try {
            if (ano != null && !ano.trim().isEmpty()) {
                anoInt = Integer.parseInt(ano.trim());
            }
        } catch (NumberFormatException e) {
            return List.of();
        }

        Double precoMinD = null;
        Double precoMaxD = null;

        try {
            if (precoMin != null && !precoMin.trim().isEmpty()) {
                String p = precoMin.trim().replace(".", "").replace(",", ".");
                precoMinD = Double.parseDouble(p);
            }
        } catch (NumberFormatException e) {
            return List.of();
        }

        try {
            if (precoMax != null && !precoMax.trim().isEmpty()) {
                String p = precoMax.trim().replace(".", "").replace(",", ".");
                precoMaxD = Double.parseDouble(p);
            }
        } catch (NumberFormatException e) {
            return List.of();
        }

        System.out.printf("Filtro => marca=%s modelo=%s ano=%s status=%s precoMin=%s precoMax=%s%n",
                marcaNorm, modeloNorm, anoInt, statusNorm, precoMinD, precoMaxD);

        return repository.filtrar(
                marcaNorm,
                modeloNorm,
                anoInt,
                statusNorm,
                precoMinD,
                precoMaxD
        );
    }
}
