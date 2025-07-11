package com.example.springComplete.controler;

import com.example.springComplete.Exception.ResourceNotFoundException;
import com.example.springComplete.Services.empService;
import com.example.springComplete.Data.employeeEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/")
@RestController
public class empController {
    private final empService service;
    empController(empService service){
        this.service=service;
    }
    @GetMapping("hello")
    public String syahello() {
        System.out.println("hey");
        return "hello";
    }

    @GetMapping("getAll/id/{empID}")
    public ResponseEntity<?> getByID(@PathVariable long empID) {
        employeeEntity employee = service.getByID(empID);
return new ResponseEntity<>(employee,HttpStatus.OK);
    }
//it is local exception handling
//    @ExceptionHandler(ResourceNotFoundException.class)
    //this return string ("Data not Exist")
//    public ResponseEntity<String> handleEmployeeNotFound(ResourceNotFoundException exception){
//        return new ResponseEntity<>(exception.getMessage(),exception.getStatus());
//    }
//    public ResponseEntity<String> handleEmployeeNotFound(ResourceNotFoundException exception){
//        ErrorResponse errorResponse=new ErrorResponse(new Date(),e.getMessage(),e.getStatus().value());
//        return new ResponseEntity<>(errorResponse,exception.getStatus());
//    }
   @GetMapping("getAll")
    public ResponseEntity<List<employeeEntity>> getAllDetails(){
        List<employeeEntity> employee = service.getAllDetails();
    return new ResponseEntity<>(employee,HttpStatus.OK);

   }
@GetMapping("getAll/{keyword}")
public ResponseEntity<List<employeeEntity>> searchByEmpName(@PathVariable(name = "keyword") String Keyword){
        List<employeeEntity> employeeEntities=service.searchByEmpName(Keyword);
        return new ResponseEntity<>(employeeEntities,HttpStatus.OK);
}

    @PostMapping("add")
    public ResponseEntity<employeeEntity> addDetails(@RequestBody employeeEntity employee){
        return new ResponseEntity<>(service.addDetails(employee),HttpStatus.ACCEPTED);
    }
    @PutMapping("Updates/{empId}")
    public ResponseEntity<employeeEntity> updateEmpAll(@RequestBody employeeEntity employee, @PathVariable long empID){
        return  new ResponseEntity<>(service.updateEmp(empID,employee),HttpStatus.OK);
    }

@PatchMapping("Update/{empID}")
public ResponseEntity<employeeEntity> updateEmp(@PathVariable long empID,@RequestBody employeeEntity updates ){
        return new ResponseEntity<>(service.updateEmp(empID, updates),HttpStatus.CREATED);
}

@DeleteMapping("delete/{empID}")
    public ResponseEntity<String> deleteEmp(@PathVariable long empID){
        return new ResponseEntity<>(service.deleteEmp(empID),HttpStatus.GONE);
}
//@ExceptionHandler(ResourceNotFoundException.class)
//   public ResponseEntity<?> handleEmployeeNotFound(ResourceNotFoundException exception){
//        ErrorResponse errorResponse=new ErrorResponse(new Date(), exception.getMessage(),exception.getStatus().value());
//        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
//    }

}
