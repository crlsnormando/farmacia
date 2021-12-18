package br.com.farmacia.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.farmacia.model.Medicamento;
import br.com.farmacia.service.MedicamentoService;
import br.com.farmacia.utility.Message;
import br.com.farmacia.utility.NegocioException;

@Named
@SessionScoped
public class MedicamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Medicamento medicamento;

	@Inject
	private MedicamentoService service;

	
	private List<Medicamento> medicamentos;

	@PostConstruct
	public void carregar() {

		medicamentos = service.todosOsMedicamentos();

	}

	public void adicionar() {
		try {

			service.salvar(medicamento);
			medicamento = new Medicamento();
			carregar();

			Message.info("Salvo Com Sucesso");

		} catch (NegocioException e) {
			Message.erro(e.getMessage());
		}

	}
	
	public void teste() {
		System.out.println("teste");
	}

	public void excluir() {

		try {
			service.remover(medicamento);
			carregar();
			Message.info(medicamento.getNome() + " foi removido");

		} catch (NegocioException e) {
			Message.erro(e.getMessage());
		}
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}



}
