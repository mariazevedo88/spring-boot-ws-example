package io.github.mariazevedo88.sbwsexample.test;

import javax.xml.transform.Source;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.ws.test.server.MockWebServiceClient;
import org.springframework.xml.transform.StringSource;

import static org.springframework.ws.test.server.RequestCreators.withPayload;
import static org.springframework.ws.test.server.ResponseMatchers.payload;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(Lifecycle.PER_CLASS)
class SpringBootWsExampleApplicationTests {

   @Autowired
   private ApplicationContext applicationContext;
   private MockWebServiceClient mockClient;

   @BeforeAll
   public void createClient() {
      mockClient = MockWebServiceClient.createClient(applicationContext);
      GenericApplicationContext ctx = (GenericApplicationContext) applicationContext;
      final XmlBeanDefinitionReader definitionReader = new XmlBeanDefinitionReader(ctx);
      definitionReader.setValidationMode(XmlBeanDefinitionReader.VALIDATION_NONE);
      definitionReader.setNamespaceAware(true);
   }
	   
   @Test
   public void testCountryEndpoint() throws Exception {
      
	   Source requestPayload = new StringSource(
         "<cal:AdditionInput xmlns:cal='http://io.github.mariazevedo88/types/calculator'>"
         + "<cal:number1>2</cal:number1>"
         + "<cal:number2>4</cal:number2>"
         + "</cal:AdditionInput>");				
      
      Source responsePayload = new StringSource(
         "<ns2:output xmlns:ns2='http://io.github.mariazevedo88/types/calculator'>"
         + "<ns2:result>6</ns2:result>"
         + "</ns2:output>");
      
      mockClient.sendRequest(withPayload(requestPayload))
    		  .andExpect(payload(responsePayload));
   }	

}
