package projeto.jpa.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import implementDAO.PetDAO;

public class UsaJpa {
	
	public UsaJpa() {
		
	}

	public static void main(String[] args) {
		
		//create
		Pet novoPet = new Pet();
		novoPet.setNome("Simone");
		novoPet.setIdade(2);
		novoPet.setSexo("fêmea");
		new PetDAO().salvar(novoPet);
		
		//findbyid -> atualizar
		Pet findPet = new PetDAO().findById(1);
		findPet.setIdade(1);
		new PetDAO().atualizar(findPet);
		
		//delete
		Pet deletePet = new PetDAO().findById(9);
		new PetDAO().excluir(deletePet);

		//select by name
		Pet findByName = new PetDAO().findByName("Forrest");
		System.out.println(findByName.toString());
		
		//select all
		List<Pet> listaPets = new PetDAO().listasPets();
		
		//print all
		for(Pet pet : listaPets) {
			System.out.println(pet.toString());
		}
		
		
		
	}

}
