package com.example.hospital.Controller;


import com.example.hospital.API.ApiResponse;
import com.example.hospital.Model.Report;
import com.example.hospital.Service.ReportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/report")
@RequiredArgsConstructor
public class ReportController {



    private final ReportService reportService ;

    Logger logger = LoggerFactory.getLogger(ReportController.class);



    @GetMapping("/get")
    public ResponseEntity getAll(){

        logger.info("get all report");
        return ResponseEntity.status(200).body(reportService.getAll());
    }



    @PostMapping("/add")
    public ResponseEntity addReport(@RequestBody @Valid Report report){

        logger.info("add new report");


        reportService.addReport(report);
        return ResponseEntity.status(200).body(new ApiResponse("Report added"));

    }



    @PutMapping("/update/{Id}")
    public ResponseEntity updateReport(@PathVariable Integer Id , @RequestBody @Valid Report report ){

        logger.info("update report");


        reportService.updateReport(Id , report);

        return ResponseEntity.status(200).body(new ApiResponse("Report updated"));
    }



    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteReport(@PathVariable Integer Id ){
        logger.info("delete report");

        reportService.deleteReport(Id);

        return ResponseEntity.status(200).body(new ApiResponse("Report deleted"));
    }




//    endpoint


    @GetMapping("/refill/{reportId}/{amount}")
    public ResponseEntity refill(@PathVariable Integer reportId , @PathVariable Integer amount){

        reportService.refill(reportId , amount);

        return ResponseEntity.status(200).body(new ApiResponse("go to pharmacy"));
    }

}
