
package org.foobarspam;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.assertj.core.api.EnumerableAssert;
import org.foobarspam.component.TarifaComponent;
import org.foobarspam.entity.Cliente;
import org.foobarspam.entity.Conductor;
import org.foobarspam.repository.ConductorRepository;
import org.foobarspam.service.CarreraService;
import org.foobarspam.service.impl.ConductorServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProyectoMySqlApplicationTests {
	
	@Autowired
	@Qualifier("tarifaComponent")
	private TarifaComponent tarifaComponent;
	
	@Autowired
	@Qualifier("carreraService")
	private CarreraService carreraService;
	
	@Autowired
	@Qualifier("conductorRepository")
	private ConductorRepository conductorRepository;
	
	@Autowired
	@Qualifier("conductorServiceImpl")
	private ConductorServiceImpl conductorServiceImpl;
	
	Conductor conductor = new Conductor();
	
	Cliente cliente = new Cliente();
	
	
	
	@Before
	public void setup(){
//		
//		double distancia = 7.75;
//		double minutos = 10;
		
		conductor.setMatricula("45678");
		conductor.setModelo("Citroen");
		conductor.setNombre("Elena");
		conductor.setValoracionmedia(2.4);
		conductor.setValoracion(2);
		conductor.setOcupado(false);
		
		cliente.setDestino("Magaluf");
		cliente.setDistancia(7.75);
		cliente.setTiempo(10);
		cliente.setOrigen("Palma");
		
		
//		
//		tarifaComponent.setDistancia(distancia);
//		tarifaComponent.setMinutos(minutos);
		carreraService.setConductor(conductor);
//		
		carreraService.setDestino(cliente.getDestino());
		carreraService.setDistancia(cliente);
		carreraService.setOrigen(cliente.getOrigen());
		carreraService.setTiempoEsperado(cliente);
	}
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testCarreraNormal(){
		double esperado = 13.9625;
//		assertThat(tarifaComponent.getDistancia()).isEqualTo(7.75);
		assertThat(esperado).isEqualTo(carreraService.getCosteEsperado());
		assertEquals(esperado, carreraService.getCosteEsperado(),0);
		
		assertThat(carreraService.getDistancia()).isEqualTo(7.75);
		assertThat(carreraService.getDestino()).isEqualTo("Magaluf");
		assertEquals(carreraService.getOrigen(), "Palma");
		
	
		

		
		
	}
	
	@Test
	public void testDatosConductor(){
		
		assertTrue(conductorRepository.findByNombre("noname") == null);
		assertThat(conductorRepository.count()).isEqualTo(4);
		

		assertThat(conductor.getMatricula()).isEqualTo("45678");
		assertThat(conductor.getNombre()).isEqualTo("Elena");
		assertThat(conductor.getValoracion()).isEqualTo(2);
	

	
		
		
	}
	
	@Test
	public void existeUnConductor() {
		
		
		
		
		assertEquals(conductorRepository.exists(1), true);
		assertEquals(conductorRepository.exists(5), true);
		assertEquals(conductorRepository.exists(19), true);
		assertEquals(conductorServiceImpl.conductorLibre().isOcupado(), conductor.isOcupado());
		assertEquals(conductorServiceImpl.conductorLibre().isOcupado(), false);
//		assertThat(conductorServiceImpl.conductorLibreLista()).isEqualTo(conductor);
//		
//		assertEquals("elena", carreraService.getConductores().findOne(1).getNombre());
		
		
	}
}


