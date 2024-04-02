package com.example.hospital.Controller;


import com.example.hospital.API.ApiResponse;
import com.example.hospital.Model.Pharmacy;
import com.example.hospital.Service.PharmacyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pharmacy")
@RequiredArgsConstructor
public class PharmacyController {


    private final PharmacyService pharmacyService ;

    Logger logger = LoggerFactory.getLogger(PharmacyController.class);


    @GetMapping("/get")
    public ResponseEntity getAll(){

        logger.info("get all medicine");
        return ResponseEntity.status(200).body(pharmacyService.getAll());
    }



    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Pharmacy pharmacy ){

        logger.info("add new medicine");


        pharmacyService.add(pharmacy);
        return ResponseEntity.status(200).body(new ApiResponse("Pharmacy added"));

    }



    @PutMapping("/update/{Id}")
    public ResponseEntity update(@PathVariable Integer Id , @RequestBody @Valid Pharmacy pharmacy ){
        logger.info("update medicine");


        pharmacyService.update(Id , pharmacy);

        return ResponseEntity.status(200).body(new ApiResponse("Pharmacy updated"));
    }



    @DeleteMapping("/delete/{Id}")
    public ResponseEntity delete(@PathVariable Integer Id ){

        logger.info("delete medicine");

        pharmacyService.delete(Id);

        return ResponseEntity.status(200).body(new ApiResponse("Pharmacy deleted"));
    }




//      Extra


    @GetMapping("/recipe/{appointmentId}")
    public ResponseEntity recipe( @PathVariable Integer appointmentId ){
        pharmacyService.recipe(appointmentId);
        logger.info("recipe");

        return ResponseEntity.status(200).body(new ApiResponse("Thank you"));
    }




    @GetMapping("/refillPh/{reportId}")
    public ResponseEntity refillPh(@PathVariable Integer reportId){

        logger.info("refill the medicine");

        pharmacyService.refillPh(reportId);

        return ResponseEntity.status(200).body(new ApiResponse("thank you"));

    }




    @GetMapping("/restock/{MId}/{amount}")
    public ResponseEntity restock(@PathVariable Integer MId , @PathVariable Integer amount){

        logger.info("restock the medicine");

        pharmacyService.restock(MId, amount);

        return ResponseEntity.status(200).body(new ApiResponse("restock done"));
    }

}
