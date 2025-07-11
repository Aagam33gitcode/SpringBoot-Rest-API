package com.example.springComplete.Services;

import com.example.springComplete.Data.employeeDTO;
import com.example.springComplete.Data.employeeEntity;
import com.example.springComplete.Exception.ResourceNotFoundException;
import com.example.springComplete.Repo.empRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class empService {
    private final empRepository repo;
    private final  ModelMapper mapper;
    empService(empRepository repo, ModelMapper mapper){
        this.repo=repo;
        this.mapper=mapper;

    }


    public List<employeeEntity> getAllDetails() {
        List<employeeDTO> employeeD= repo.findAll();
               return employeeD.stream()
                .map(employeeDTO -> mapper.map(employeeDTO, employeeEntity.class)).collect(Collectors.toList());
   }
   //mapping //exception
public employeeEntity getByID(long empID) {
    employeeDTO employeedto= repo.findById(empID).orElseThrow(()-> new ResourceNotFoundException("this id "+empID+" not found!"));
    return mapper.map(employeedto, employeeEntity.class);
}
    public List<employeeEntity> searchByEmpName(String keyword) {
        List<employeeDTO> emplDTO = repo.findByEmpNameContainingIgnoreCase(keyword);
        try {
            Long id = Long.parseLong(keyword);
            Optional<employeeDTO> optionalEntity = repo.findById(id);
            if (optionalEntity.isPresent()) {
                emplDTO.add(optionalEntity.get());
            }
            else {

                throw new ResourceNotFoundException(keyword+" not found");
            }
            emplDTO = repo.findByEmpNameContainingIgnoreCase(keyword);
        } catch (NumberFormatException e) {
            throw new ResourceNotFoundException(keyword +"not found");
        }
        return emplDTO
                .stream()
                .map(entity -> mapper.map(entity, employeeEntity.class))
                .collect(Collectors.toList());
    }

//mapping //exception
public employeeEntity addDetails(employeeEntity employee) {
    employeeDTO existing = repo.findByEmpNameAndEmpAgeAndEmpBODAndIsExist(
            employee.getEmpName(),
            employee.getEmpAge(),
            employee.getEmpBOD(),
            employee.isExist()
    );
    if(existing.isExist()){
        throw new ResourceNotFoundException.ResourceAlreadyExistsException("employee exixt already "+existing);
    }
        employeeDTO tosave=mapper.map(employee,employeeDTO.class);

        employeeDTO employeeD=repo.save(tosave);
        return mapper.map(employeeD,employeeEntity.class);
    }
//exception //mapping
    public employeeEntity updateEmpAll(employeeEntity employee, long empID) {
        employeeDTO existing = repo.findById(empID)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with ID " + empID + " not found."));

        existing.setEmpName(employee.getEmpName());
        existing.setEmpAge(employee.getEmpAge());
        existing.setEmpBOD(employee.getEmpBOD());
        existing.setExist(employee.isExist());

        employeeDTO saved = repo.save(existing);
        return mapper.map(saved, employeeEntity.class);
    }


//Exception //mapping
    public String deleteEmp(long empID) {
        try {
            Optional<employeeDTO> employeeOpt = repo.findById(empID);
            if (employeeOpt.isPresent()) {
                repo.delete(employeeOpt.get());
            } else {
                throw new ResourceNotFoundException("Employee with ID " + empID + " not found");
            }}catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return "DELETED";
    }
//    public employeeEntity updateEmp(long empID, Map<String, Object> updates) {
//        boolean exists=repo.existsById(empID);
//        if(!exists) return null;
//employeeDTO employee=repo.findById(empID).get();
//updates.forEach((field, value) ->{
//        Field fields= ReflectionUtils.findRequiredField(employeeDTO.class,field);
//        fields.setAccessible(true);
//            ReflectionUtils.setField(fields,employeeDTO.class,value);
//
//});
//return  mapper.map(repo.save(employee), employeeEntity.class);
//    }
    //Exception //mapping
public employeeEntity updateEmp(Long id, employeeEntity entity) {
    employeeDTO existing = repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Employee with ID " + id + " not found"));

    // Only update non-null or valid fields
    if (entity.getEmpName() != null) existing.setEmpName(entity.getEmpName());
    if (entity.getEmpAge() > 0) existing.setEmpAge(entity.getEmpAge());
    if (entity.getEmpBOD() != null) existing.setEmpBOD(entity.getEmpBOD());
    existing.setExist(entity.isExist());  // primitive boolean, always updates

    employeeDTO saved = repo.save(existing);
    return mapper.map(saved, employeeEntity.class);
}

}

