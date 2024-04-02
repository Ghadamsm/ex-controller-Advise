package com.example.hospital.Controller;


import com.example.hospital.API.ApiResponse;
import com.example.hospital.Model.Appointment;
import com.example.hospital.Service.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appointment")
@RequiredArgsConstructor
public class AppointmentController {


    private final AppointmentService appointmentService ;

    Logger logger = LoggerFactory.getLogger(AppointmentController.class);


    @GetMapping("/get")
    public ResponseEntity getAll(){
        logger.info("get all appointment");
        return ResponseEntity.status(200).body(appointmentService.getAll());
    }



    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Appointment appointment){

        logger.info("add new appointment");

        return ResponseEntity.status(200).body(appointmentService.add(appointment));

    }



    @PutMapping("/update/{Id}")
    public ResponseEntity update(@PathVariable Integer Id , @RequestBody @Valid Appointment appointment){

        logger.info("update appointment");

        appointmentService.update(Id , appointment);

        return ResponseEntity.status(200).body(new ApiResponse("Appointment updated"));
    }



    @DeleteMapping("/delete/{Id}")
    public ResponseEntity delete(@PathVariable Integer Id ){
        logger.info("delete appointment");

        appointmentService.delete(Id);

        return ResponseEntity.status(200).body(new ApiResponse("Appointment deleted"));
    }



//     endpoint



    @GetMapping("/getD/{sp}")
    public ResponseEntity getAllDoctor(@PathVariable String sp){
        logger.info("get all doctor by specialty");

        return ResponseEntity.status(200).body( appointmentService.getAllDoctorBySp(sp));
    }



    @GetMapping("/getA/{userId}/{TORF}")
    public ResponseEntity getAllAppoF(@PathVariable Integer userId ,@PathVariable Boolean TORF){
        logger.info("get appointments if true or false");

        return ResponseEntity.status(200).body( appointmentService.getAllAppoF(userId, TORF));
    }



    @GetMapping("/visit/{visits}")
    public ResponseEntity getVisit(@PathVariable Integer visits){
        logger.info("get doctors by visited number");

        return ResponseEntity.status(200).body(appointmentService.getVisit(visits));

    }

}
