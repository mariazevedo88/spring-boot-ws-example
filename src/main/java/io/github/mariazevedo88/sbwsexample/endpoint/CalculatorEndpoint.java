package io.github.mariazevedo88.sbwsexample.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import lombok.extern.log4j.Log4j2;
import mariazevedo88.github.io.types.calculator.AdditionInput;
import mariazevedo88.github.io.types.calculator.DivisionInput;
import mariazevedo88.github.io.types.calculator.MultiplicationInput;
import mariazevedo88.github.io.types.calculator.ObjectFactory;
import mariazevedo88.github.io.types.calculator.Output;
import mariazevedo88.github.io.types.calculator.SubtractionInput;

@Log4j2
@Endpoint
public class CalculatorEndpoint {
	
    @ResponsePayload
    @PayloadRoot(namespace = "http://io.github.mariazevedo88/types/calculator", localPart = "AdditionInput")
    public Output addition(@RequestPayload AdditionInput input){
        log.info("Request received for addition with input "+input);
        ObjectFactory objectFactory = new ObjectFactory();
        Output output = objectFactory.createOutput();
        output.setResult(input.getNumber1() + input.getNumber2());
        return output;
    }

    @ResponsePayload
    @PayloadRoot(namespace = "http://io.github.mariazevedo88/types/calculator", localPart = "SubtractionInput")
    public Output subtraction(@RequestPayload SubtractionInput input){
        log.info("Request received for addition with input "+input);
        ObjectFactory objectFactory = new ObjectFactory();
        Output output = objectFactory.createOutput();
        output.setResult(input.getNumber1() - input.getNumber2());
        return output;
    }

    @ResponsePayload
    @PayloadRoot(namespace = "http://io.github.mariazevedo88/types/calculator", localPart = "MultiplicationInput")
    public Output multiplication(@RequestPayload MultiplicationInput input){
        log.info("Request received for addition with input "+input);
        ObjectFactory objectFactory = new ObjectFactory();
        Output output = objectFactory.createOutput();
        output.setResult(input.getNumber1() * input.getNumber2());
        return output;
    }

    @ResponsePayload
    @PayloadRoot(namespace = "http://io.github.mariazevedo88/types/calculator", localPart = "DivisionInput")
    public Output division(@RequestPayload DivisionInput input){
        log.info("Request received for addition with input "+input);
        if(input.getNumber2() == 0){
            throw new IllegalArgumentException("Divisor can't be null");
        }
        ObjectFactory objectFactory = new ObjectFactory();
        Output output = objectFactory.createOutput();
        output.setResult(input.getNumber1() + input.getNumber2());
        return output;
    }

}
