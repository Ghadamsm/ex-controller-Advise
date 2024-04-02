package com.example.hospital.Controller;


import com.example.hospital.API.ApiResponse;
import com.example.hospital.Model.HomeVisit;
import com.example.hospital.Service.HomeVisitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/home")
@RequiredArgsConstructor
public class HomeVisitController {



    private final HomeVisitService homeVisitService ;

    Logger logger = LoggerFactory.getLogger(HomeVisitController.class);


    @GetMapping("/get")
    public ResponseEntity getAll(){
        logger.info("get all appointment in home visit");
        return ResponseEntity.status(200).body(homeVisitService.getAll());
    }



    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid HomeVisit homeVisit){

        logger.info("add appointment in home visit");


        return ResponseEntity.status(200).body(homeVisitService.add(homeVisit));

    }



    @PutMapping("/update/{Id}")
    public ResponseEntity update(@PathVariable Integer Id , @RequestBody @Valid HomeVisit homeVisit){

        logger.info("update appointment in home visit");

        homeVisitService.update(Id , homeVisit);

        return ResponseEntity.status(200).body(new ApiResponse("HomeVisit updated"));
    }



    @DeleteMapping("/delete/{Id}")
    public ResponseEntity delete(@PathVariable Integer Id ){
        logger.info("delete appointment in home visit");

        homeVisitService.delete(Id);

        return ResponseEntity.status(200).body(new ApiResponse("HomeVisit deleted"));
    }




//     endpoint




    @GetMapping("/status/{Id}")
    public ResponseEntity status(@PathVariable Integer Id){
        logger.info("change appointment in home visit");

        homeVisitService.status(Id);

        return ResponseEntity.status(200).body(new ApiResponse("Thank you for requesting the home visit service"));
    }



    @GetMapping("/getD/{specialty}")
    public ResponseEntity getAllDoctor(@PathVariable String specialty){
        logger.info("get doctor by specialty");

        return ResponseEntity.status(200).body( homeVisitService.getAllDoctorBySp(specialty));
    }




    @GetMapping("/getBest/{visit}")
    public ResponseEntity bestDoctor(@PathVariable Integer visit ){
        logger.info("get doctors by visited number");

        return ResponseEntity.status(200).body(homeVisitService.bestDoctor(visit));
    }



}
