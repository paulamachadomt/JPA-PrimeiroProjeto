package interfaces;

import java.util.List;

import projeto.jpa.model.Pet;

public interface IPetDAO {
	
	public void salvar(Pet pet);
	
	public Pet findById(int id);
	
	public Pet findByName(String nome);
	
	public void excluir(Pet pet);
	
	public void atualizar(Pet pet);
	
	public List<Pet> listasPets();
	
}
