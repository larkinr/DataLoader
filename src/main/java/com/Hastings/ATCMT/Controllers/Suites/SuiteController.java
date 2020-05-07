package com.Hastings.ATCMT.Controllers.Suites;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import com.Hastings.ATCMT.Models.Suites.SuiteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Hastings.ATCMT.ErrorHandling.*;
import com.Hastings.ATCMT.Repositories.Suites.SuiteRepository;

@RestController
@RequestMapping("/ATCMT/Repositories")
public class SuiteController {

    @Autowired
    private SuiteRepository _suiteRepository;


    @GetMapping("Get/Suites")
    public List<SuiteModel> getAllTestSuites() {
        return _suiteRepository.findAll();
    }

    @GetMapping("Get/Suites/{Id}")
    public SuiteModel getTestSuite(@PathVariable(value = "Id") long stcID) throws ResourceNotFoundException {

        SuiteModel suite = _suiteRepository.findById(stcID).orElseThrow(() -> new ResourceNotFoundException(
                "Suite testcase  [" + stcID + "] not found"));
        return _suiteRepository.save(suite);
    }

    @PostMapping("Create/Suites")
    public SuiteModel createTestSuite(@Valid @RequestBody SuiteModel suite) { return _suiteRepository.save(suite); }

    @PutMapping("Update/Suites/{Id}")
    public ResponseEntity<SuiteModel> updateTestSuite(@PathVariable(value = "Id") Long testSuiteID, @Valid @RequestBody
            SuiteModel suiteName) throws ResourceNotFoundException {

        SuiteModel suite = _suiteRepository.findById(testSuiteID).orElseThrow(() -> new ResourceNotFoundException(
                "Suite [" + suiteName + "] not found"));
        suite.setSuiteName(suiteName.getSuiteName());
        suite.setSuiteDescription(suiteName.getSuiteDescription());
        final SuiteModel updatedSuite = _suiteRepository.save(suite);
        return ResponseEntity.ok(updatedSuite);
    }

    @DeleteMapping("Delete/Suites/{Id}")
    public Map<String, Boolean> deleteTestSuite(@PathVariable(value = "Id") Long testSuiteID) throws ResourceNotFoundException {
        SuiteModel suite = _suiteRepository.findById(testSuiteID).orElseThrow(() -> new ResourceNotFoundException(
                "Suite [" + testSuiteID + "] not found"));

        _suiteRepository.delete(suite);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}


