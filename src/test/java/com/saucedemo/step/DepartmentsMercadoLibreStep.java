package com.saucedemo.step;

import com.saucedemo.api.ep.Endpoint;
import com.saucedemo.util.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import java.util.*;
import static org.junit.Assert.assertEquals;

public class DepartmentsMercadoLibreStep 
{	public DepartmentsMercadoLibreStep(TestContext context) {
	}

	@When("Get departments from mercado libre")
  	public void getDepartmentsFromMercadoLibre() throws Exception {
  	}

	@Then("validate departments")
  	public void validateDepartments(DataTable dataTable) throws Exception {
		List<List<String>> data = dataTable.asLists(String.class);
		Endpoint endpoint = new Endpoint();
		Response response = endpoint.getDepartments();
		String currentDepartment1 =  response.path("landings[0].label");
		String expectedDepartment1 = data.get(0).get(0); 
		assertEquals("Se esperaba "+expectedDepartment1+" pero se encontro "+currentDepartment1, expectedDepartment1.trim(), currentDepartment1.trim());
		String currentDepartment2 =  response.path("landings[1].label");
		String expectedDepartment2 = data.get(1).get(0); 
		assertEquals("Se esperaba "+expectedDepartment2+" pero se encontro "+currentDepartment2, expectedDepartment2.trim(), currentDepartment2.trim());
		String currentDepartment3 =  response.path("landings[2].label");
		String expectedDepartment3 = data.get(2).get(0); 
		assertEquals("Se esperaba "+expectedDepartment3+" pero se encontro "+currentDepartment3, expectedDepartment3.trim(), currentDepartment3.trim());
		String currentDepartment4 =  response.path("landings[3].label");
		String expectedDepartment4 = data.get(3).get(0); 
		assertEquals("Se esperaba "+expectedDepartment4+" pero se encontro "+currentDepartment4, expectedDepartment4.trim(), currentDepartment4.trim());
		String currentDepartment5 =  response.path("landings[4].label");
		String expectedDepartment5 = data.get(4).get(0); 
		assertEquals("Se esperaba "+expectedDepartment5+" pero se encontro "+currentDepartment5, expectedDepartment5.trim(), currentDepartment5.trim());
		String currentDepartment6 =  response.path("landings[5].label");
		String expectedDepartment6 = data.get(5).get(0); 
		assertEquals("Se esperaba "+expectedDepartment6+" pero se encontro "+currentDepartment6, expectedDepartment6.trim(), currentDepartment6.trim());
		String currentDepartment7 =  response.path("landings[6].label");
		String expectedDepartment7 = data.get(6).get(0); 
		assertEquals("Se esperaba "+expectedDepartment7+" pero se encontro "+currentDepartment7, expectedDepartment7.trim(), currentDepartment7.trim());
		String currentDepartment8 =  response.path("landings[7].label");
		String expectedDepartment8 = data.get(7).get(0); 
		assertEquals("Se esperaba "+expectedDepartment8+" pero se encontro "+currentDepartment8, expectedDepartment8.trim(), currentDepartment8.trim());
		String currentDepartment9 =  response.path("landings[8].label");
		String expectedDepartment9 = data.get(8).get(0); 
		assertEquals("Se esperaba "+expectedDepartment9+" pero se encontro "+currentDepartment9, expectedDepartment9.trim(), currentDepartment9.trim());
		String currentDepartment10 =  response.path("landings[9].label");
		String expectedDepartment10 = data.get(9).get(0); 
		assertEquals("Se esperaba "+expectedDepartment10+" pero se encontro "+currentDepartment10, expectedDepartment10.trim(), currentDepartment10.trim());
		String currentDepartment11 =  response.path("landings[10].label");
		String expectedDepartment11 = data.get(10).get(0); 
		assertEquals("Se esperaba "+expectedDepartment11+" pero se encontro "+currentDepartment11, expectedDepartment11.trim(), currentDepartment11.trim());
		String currentDepartment12 =  response.path("landings[11].label");
		String expectedDepartment12 = data.get(11).get(0); 
		assertEquals("Se esperaba "+expectedDepartment12+" pero se encontro "+currentDepartment12, expectedDepartment12.trim(), currentDepartment12.trim());
		String currentDepartment13 =  response.path("landings[12].label");
		String expectedDepartment13 = data.get(12).get(0); 
		assertEquals("Se esperaba "+expectedDepartment13+" pero se encontro "+currentDepartment13, expectedDepartment13.trim(), currentDepartment13.trim());
		String currentDepartment14 =  response.path("landings[13].label");
		String expectedDepartment14 = data.get(13).get(0); 
		assertEquals("Se esperaba "+expectedDepartment14+" pero se encontro "+currentDepartment14, expectedDepartment14.trim(), currentDepartment14.trim());
		String currentDepartment15 =  response.path("landings[14].label");
		String expectedDepartment15 = data.get(14).get(0); 
		assertEquals("Se esperaba "+expectedDepartment15+" pero se encontro "+currentDepartment15, expectedDepartment15.trim(), currentDepartment15.trim());
		String currentDepartment16 =  response.path("landings[15].label");
		String expectedDepartment16 = data.get(15).get(0); 
		assertEquals("Se esperaba "+expectedDepartment16+" pero se encontro "+currentDepartment16, expectedDepartment16.trim(), currentDepartment16.trim());
		String currentDepartment17 =  response.path("landings[16].label");
		String expectedDepartment17 = data.get(16).get(0); 
		assertEquals("Se esperaba "+expectedDepartment17+" pero se encontro "+currentDepartment17, expectedDepartment17.trim(), currentDepartment17.trim());
		response.then().assertThat().statusCode(200);
  	}
}