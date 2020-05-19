package redes;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import listaversionfinal.*;


/**
 * Protocolo:
 * 
 * GET CURSOS
 * 
 * [{"nombre":"edd"},{"nombre","otro curso"}]
 * 
 * INSCRIBIR edd {"nombre":"pepito","edad": 45}
 * 
 * @author Vladimir
 *
 */
public class TestJson {

	public static void main(String[] args) throws JsonProcessingException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		Lista<Car> cars = new Lista<Car>();
		Car car  = new Car();
		car.setColor("yellow");
		car.setTipo("renault");
		cars.insertar(car);
		
		String jsonString = objectMapper.writeValueAsString(cars);
		
		System.out.println(jsonString);
	}
}
