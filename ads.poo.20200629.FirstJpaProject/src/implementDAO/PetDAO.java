package implementDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import interfaces.IPetDAO;
import projeto.jpa.model.Pet;

public class PetDAO implements IPetDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ads.poo.20200629.FirstJpaProject");
	EntityManager em = emf.createEntityManager();

	public PetDAO() {

	}

	@Override
	public void salvar(Pet petSalvar) {
		em.getTransaction().begin();
		em.persist(petSalvar);
		em.getTransaction().commit();
	}

	@Override
	public void excluir(Pet petExcluir) {
		Pet pet = em.find(Pet.class, petExcluir.getId());
		em.getTransaction().begin();
		em.remove(pet);
		em.getTransaction().commit();
	}

	@Override
	public void atualizar(Pet petAtualizar) {
//		Pet petAtualizar = em.find(Pet.class, pet.getId());
		em.getTransaction().begin();
		em.merge(petAtualizar);
		em.getTransaction().commit();
	}

	@Override
	public List<Pet> listasPets() {
		return em.createQuery("Select a from pet a").getResultList();
	}

	@Override
	public Pet findById(int id) {
		return em.find(Pet.class, id);
	}

	@Override
	public Pet findByName(String nome) {
		Query query = em.createNamedQuery("Pet.findByName");
		query.setParameter("nome", nome);
		return (Pet) query.getSingleResult();
	}
}
