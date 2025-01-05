package com.senac.pi.controller;

import com.senac.pi.model.Analise;
import com.senac.pi.model.Atividade;
import com.senac.pi.service.AnaliseService;
import com.senac.pi.service.AtividadeService;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AtividadeController {

    @Autowired
    AtividadeService atividadeService;

    @Autowired
    AnaliseService analiseService;

    @GetMapping("/")
    public String inicio() {  
        return "index"; 
    }

    @GetMapping("/cadastrarAtividade") 
    public String cadastre(Model model) {
        model.addAttribute("atividade", new Atividade());
        return "cadastrarAtividade";
    }

    @PostMapping("/gravar") 
    public String processarFormulario(@ModelAttribute Atividade atividade, Model model) {
        atividadeService.criar(atividade);

        return "redirect:/listarAtividade"; 
    }

    @GetMapping("/listarAtividade")
    public String listaForm(Model model) {
        model.addAttribute("lista", atividadeService.buscarTodos());
        return "listarAtividade";
    }

    @GetMapping("/exibir")
    public String mostrarDetalhes(Model model, @RequestParam String id) {

        Integer atividadeId = Integer.parseInt(id);
        Atividade atividade = atividadeService.buscarPorId(atividadeId);
        List<Analise> analiseEncontrada = analiseService.buscarTodosPeloIdAtividade(atividadeId);

        model.addAttribute("atividade", atividade);
        model.addAttribute("analise", new Analise());
        model.addAttribute("analises", analiseEncontrada);
        return "detalhesAtividade";
    }

    @GetMapping("/alterar-atividade")
    public String alterarFilme(Model model, @RequestParam String id) {

        int idAtividade = Integer.parseInt(id);
        model.addAttribute("atividade", atividadeService.buscarPorId(idAtividade));
        return "cadastrarAtividade";
    }

    @GetMapping("/excluir-atividade")
    public String excluirFilme(Model model, @RequestParam String id) {

        int idAtividade = Integer.parseInt(id);
        atividadeService.excluir(idAtividade);

        return "redirect:/listarAtividade"; 
    }

    @PostMapping("/gravar-analise")
    public String processarFormulario(@ModelAttribute Atividade atividade, @ModelAttribute Analise analise, Model model) {
        analise.setAtividade(atividade);
        analiseService.criar(analise);
        return "redirect:/listarAtividade";
    }

    @GetMapping("/excluir-analise")
    public String excluirAnalise(Model model, @RequestParam String id) {

        int atividadeId = Integer.parseInt(id);
        analiseService.excluir(atividadeId);

        return "redirect:/listarAtividade";
    }

}
