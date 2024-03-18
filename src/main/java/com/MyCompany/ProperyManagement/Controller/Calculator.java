package com.MyCompany.ProperyManagement.Controller;

import com.MyCompany.ProperyManagement.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cal")
public class Calculator {
    @PostMapping("mul")
    public ResponseEntity<Double> mul(@RequestBody CalculatorDTO calculatorDTO)
    {
        Double result = calculatorDTO.getNum1() * calculatorDTO.getNum2() * calculatorDTO.getNum3() * calculatorDTO.getNum4();
        ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return responseEntity;
    }

    @PutMapping("add")
    public ResponseEntity<Double> Add(@RequestBody CalculatorDTO calculatorDTO,@RequestParam("num5") Double num5)
    {
        calculatorDTO.setNum4(num5);
        Double result = calculatorDTO.getNum1() + calculatorDTO.getNum2() + calculatorDTO.getNum3() + calculatorDTO.getNum4();
        ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return responseEntity;
    }
}
