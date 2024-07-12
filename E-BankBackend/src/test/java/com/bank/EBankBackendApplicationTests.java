package com.bank;

import com.bank.Dao.compteDAO;
import com.bank.Model.compte;
import com.bank.Model.User;
import com.bank.Service.CompteServiceIM;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EBankBackendApplicationTests {

	@Autowired
	private CompteServiceIM compteService;

	@Mock
	private compteDAO compteDao;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testCreerCompte() {
		String type_compte = "MOCK";
		float Solde_initial = 1990;
		String Date_creation = "2021-01-01";
		int idUser = 1;

		// Mock the User object
		User mockUser = new User();
		mockUser.setIdUser(idUser);

		// Mock the compte object to return the mockUser
		compte mockCompte = new compte();
		mockCompte.setType_compte(type_compte);
		mockCompte.setSolde_initial(Solde_initial);
		mockCompte.setDate_creation(Date_creation);
		mockCompte.setUser(mockUser);

//		when(compteDao.save(any(compte.class))).thenReturn(mockCompte);
	}

}
