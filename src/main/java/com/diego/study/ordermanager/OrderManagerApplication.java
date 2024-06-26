package com.diego.study.ordermanager;

import com.diego.study.ordermanager.model.*;
import com.diego.study.ordermanager.model.enums.ClientType;
import com.diego.study.ordermanager.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class OrderManagerApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(OrderManagerApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Category category1 = new Category(null, "IT");
		Category category2 = new Category(null, "Sales");

		Product product1 = new Product(null, "Laptop", BigDecimal.valueOf(3000.00));
		Product product2 = new Product(null, "Chair", BigDecimal.valueOf(700.00));
		Product product3 = new Product(null, "Printer", BigDecimal.valueOf(300.00));

		category1.getProducts().addAll(List.of(product1, product3));
		category2.getProducts().addAll(List.of(product1, product2, product3));

		product1.getCategories().addAll(List.of(category1, category2));
		product2.getCategories().add(category2);
		product3.getCategories().addAll(List.of(category1, category2));

		categoryRepository.saveAll(List.of(category1, category2));
		productRepository.saveAll(List.of(product1, product2, product3));

		State state1 = new State(null, "São Paulo");
		State state2 = new State(null, "Minas Gerais");

		City city1 = new City(null, "São Paulo", state1);
		City city2 = new City(null, "Guarulhos", state1);
		City city3 = new City(null, "Campinas", state1);
		City city4 = new City(null, "Belo Horizonte", state2);
		City city5 = new City(null, "Montes Claros", state2);
		City city6 = new City(null, "Cotia", state1);

		stateRepository.saveAll(List.of(state1, state2));
		cityRepository.saveAll(List.of(city1, city2, city3, city4, city5, city6));

		Client client1 = new Client(null, "Diego Vieira", "diego.vieira@email.com", "12345678909", ClientType.B2C);
		Client client2 = new Client(null, "Pedro Bó", "pedro.bo@email.com", "12345678909", ClientType.B2C);
		Client client3 = new Client(null, "Misato Katsuragi", "misato.katsuragi@email.com", "12345678909", ClientType.B2C);
		Client client4 = new Client(null, "Sócrates Brasileiro", "socrates@email.com", "12345678909", ClientType.B2C);
		Client client5 = new Client(null, "Padaria Pão Gostoso", "pao.gostoso@email.com", "345678909/0001-54", ClientType.B2B);
		Client client6 = new Client(null, "Mercados Chan", "mercados.chan@email.com", "111111111/0001-11", ClientType.B2B);

		Address address1 = new Address(null, "Rua Kyalame", "16", null, "Jardim Claudio", "06715-835", client1, city6);
		Address address2 = new Address(null, "Rua Augusta", "1450", "apto 44", "Centro", "01234-432", client2, city1);
		Address address3 = new Address(null, "Rua dos Patos", "33", null, "Centro", "99999-999", client3, city2);
		Address address4 = new Address(null, "Rua das Primas", "16", null, "Jardim Itatinga", "22222-222", client4, city3);
		Address address5 = new Address(null, "Avenida Tiradentes", "10", null, "Pampulha", "33333-333", client5, city4);
		Address address6 = new Address(null, "Rua do Trem", "912", null, "Centro", "44444-444", client6, city5);

		client1.getPhones().addAll(List.of("999998888", "888889999"));
		client2.getPhones().add("987654321");
		client3.getPhones().add("896745231");
		client4.getPhones().add("909090999");
		client5.getPhones().addAll(List.of("987987987", "445673212"));
		client6.getPhones().add("888888881");

		clientRepository.saveAll(List.of(client1, client2, client3, client4, client5, client6));
		addressRepository.saveAll(List.of(address1, address2, address3, address4, address5, address6));
	}
}
