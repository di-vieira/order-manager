package com.diego.study.ordermanager;

import com.diego.study.ordermanager.model.*;
import com.diego.study.ordermanager.model.enums.ClientType;
import com.diego.study.ordermanager.model.enums.PaymentStatus;
import com.diego.study.ordermanager.repository.*;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
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

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	public static void main(String[] args) {
		SpringApplication.run(OrderManagerApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Category category1 = new Category(null, "IT");
		Category category2 = new Category(null, "Sales");
		Category category3 = new Category(null, "Electronics");
		Category category4 = new Category(null, "Office");
		Category category5 = new Category(null, "Home and Garden");
		Category category6 = new Category(null, "Household Linen");
		Category category7 = new Category(null, "Sports");
		Category category8 = new Category(null, "Books");
		Category category9 = new Category(null, "Games");
		Category category10 = new Category(null, "Fashion");
		Category category11 = new Category(null, "Beauty");
		Category category12 = new Category(null, "Health");

		Product product1 = new Product(null, "Laptop", BigDecimal.valueOf(3000.00));
		Product product2 = new Product(null, "Chair", BigDecimal.valueOf(700.00));
		Product product3 = new Product(null, "Printer", BigDecimal.valueOf(300.00));

		category1.getProducts().addAll(List.of(product1, product3));
		category2.getProducts().addAll(List.of(product1, product2, product3));

		product1.getCategories().addAll(List.of(category1, category2));
		product2.getCategories().add(category2);
		product3.getCategories().addAll(List.of(category1, category2));

		categoryRepository.saveAll(List.of(category1, category2, category3, category4, category5, category6, category7, category8, category9, category10, category11, category12));
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
		Address address7 = new Address(null, "Rua da Independencia", "1412", null, "Centro", "55555-444", client6, city5);

		client1.getPhones().addAll(List.of("999998888", "888889999"));
		client2.getPhones().add("987654321");
		client3.getPhones().add("896745231");
		client4.getPhones().add("909090999");
		client5.getPhones().addAll(List.of("987987987", "445673212"));
		client6.getPhones().add("888888881");

		clientRepository.saveAll(List.of(client1, client2, client3, client4, client5, client6));
		addressRepository.saveAll(List.of(address1, address2, address3, address4, address5, address6));

		Order order1 = new Order(null, LocalDateTime.of(2024, 03, 01, 10, 45), client1, address1);
		Order order2 = new Order(null, LocalDateTime.of(2024, 04, 04, 11, 44), client2, address2);
		Order order3 = new Order(null, LocalDateTime.of(2024, 05, 05, 12, 43), client6, address6);
		Order order4 = new Order(null, LocalDateTime.of(2024, 03, 01, 10, 45), client5, address5);

		Payment payment1 = new PaymentBankSlip(null, PaymentStatus.OUTSTANDING, order1, LocalDate.of(2024, 03, 15), null);
		Payment payment2 = new PaymentCreditCard(null, PaymentStatus.DONE, order2, 6);
		Payment payment3 = new PaymentCreditCard(null, PaymentStatus.DONE, order3, 3);
		Payment payment4 = new PaymentCreditCard(null, PaymentStatus.CANCELLED, order4, 1);

		order1.setPayment(payment1);
		order2.setPayment(payment2);
		order3.setPayment(payment3);
		order4.setPayment(payment4);

		client1.getOrders().add(order1);
		client2.getOrders().add(order2);
		client6.getOrders().add(order3);
		client5.getOrders().add(order4);

		//orderRepository.saveAll(List.of(order1, order2, order3));
		//paymentRepository.saveAll(List.of(payment1, payment2, payment3));
		orderRepository.saveAll(List.of(order1, order2, order3, order4));
		paymentRepository.saveAll(List.of(payment1, payment2, payment3, payment4));

		OrderItem orderItem1 = new OrderItem(order1, product1, BigDecimal.ZERO, 5, BigDecimal.valueOf(35) );
		OrderItem orderItem2 = new OrderItem(order1, product3, BigDecimal.ZERO, 15, BigDecimal.valueOf(2.5) );
		OrderItem orderItem3 = new OrderItem(order2, product2, BigDecimal.TEN, 45, BigDecimal.valueOf(9.9) );
		OrderItem orderItem4 = new OrderItem(order3, product3, BigDecimal.TEN, 100, BigDecimal.valueOf(2.5) );

		order1.getOrderItems().addAll(Arrays.asList(orderItem1, orderItem2));
		order2.getOrderItems().add(orderItem3);
		order3.getOrderItems().add(orderItem4);

		product1.getOrderItems().add(orderItem1);
		product2.getOrderItems().add(orderItem3);
		product3.getOrderItems().addAll(Arrays.asList(orderItem2, orderItem4));

		orderItemRepository.saveAll(Arrays.asList(orderItem1, orderItem2, orderItem3, orderItem4));
	}
}
