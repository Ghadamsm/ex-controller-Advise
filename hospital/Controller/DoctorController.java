package com.example.hospital.Controller;


import com.example.hospital.API.ApiResponse;
import com.example.hospital.Model.Doctor;
import com.example.hospital.Service.DoctorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctor")
@RequiredArgsConstructor
public class DoctorController {


    private final DoctorService doctorService ;

    Logger logger = LoggerFactory.getLogger(DoctorController.class);


    @GetMapping("/get")
    public ResponseEntity getAll(){
        logger.info("get all doctor");
        return ResponseEntity.status(200).body(doctorService.getAll());
    }



    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Doctor doctor ){

        logger.info("add new doctor");


        doctorService.add(doctor);
        return ResponseEntity.status(200).body(new ApiResponse("Doctor added"));

    }



    @PutMapping("/update/{Id}")
    public ResponseEntity update(@PathVariable Integer Id , @RequestBody @Valid Doctor doctor){

        logger.info("update doctor");


        doctorService.update(Id , doctor);

        return ResponseEntity.status(200).body(new ApiResponse("Doctor updated"));
    }



    @DeleteMapping("/delete/{Id}")
    public ResponseEntity delete(@PathVariable Integer Id ){
        logger.info("delete doctor");

        doctorService.delete(Id);

        return ResponseEntity.status(200).body(new ApiResponse("Doctor deleted"));
    }





//     endpoint




    @GetMapping("/bonus/{DID}/{bonus}")
    public ResponseEntity bonuses(@PathVariable Integer DID , @PathVariable Integer bonus){
        logger.info("bones to doctor salary");

        doctorService.bonuses(DID, bonus);

        return ResponseEntity.status(200).body(new ApiResponse("bonus added"));
    }




    @GetMapping("/searchByNC/{nationality}/{certification}")
    public ResponseEntity getDoctorByNationalityAndCertification(@PathVariable String nationality ,@PathVariable String certification){

        logger.info("get doctors be nationality and certification ");

        return ResponseEntity.status(200).body(doctorService.getDoctorByNationalityAndCertification(nationality, certification));
    }
}
