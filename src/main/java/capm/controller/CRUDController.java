package capm.controller;

import capm.dto.request.CreateEmployeeRequest;
import capm.dto.request.CreateTeamRequest;
import capm.dto.response.MetaDataDTO;
import capm.dto.response.ResponseDTO;
import capm.enums.ReturnCode;
import capm.ifacade.CRUDFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author deepak.jayaprakash
 */
@RestController
@RequestMapping(value = "/capm")
@Slf4j
public class CRUDController {

    @Autowired
    private CRUDFacade crudFacade;

    @PostMapping(value = "/createNewEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO createNewEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            crudFacade.createNewEmployee(createEmployeeRequest);
        } catch (Exception e) {
            log.error("exception_in_test_api", e);
        }
        MetaDataDTO metaDataDTO = MetaDataDTO.builder().returnCode(ReturnCode.SC_001).build();
        responseDTO.setMeta(metaDataDTO);
        log.info("test_api_response: {}", responseDTO);
        return responseDTO;
    }

    @PostMapping(value = "/createNewTeam", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO createNewTeam(@RequestBody CreateTeamRequest teamRequest) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            crudFacade.createNewTeam(teamRequest);
        } catch (Exception e) {
            log.error("exception_in_test_api", e);
        }
        MetaDataDTO metaDataDTO = MetaDataDTO.builder().returnCode(ReturnCode.SC_001).build();
        responseDTO.setMeta(metaDataDTO);
        log.info("test_api_response: {}", responseDTO);
        return responseDTO;
    }
}
