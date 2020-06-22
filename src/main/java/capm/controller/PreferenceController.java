package capm.controller;

import capm.dto.request.CreateEmployeeRequest;
import capm.dto.request.PunchInRequest;
import capm.dto.response.MetaDataDTO;
import capm.dto.response.ResponseDTO;
import capm.enums.ReturnCode;
import capm.ifacade.CRUDFacade;
import capm.ifacade.EmployeeFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author deepak.jayaprakash
 */
@RestController
@RequestMapping(value = "/capm")
@Slf4j
public class PreferenceController {

    @Autowired
    private EmployeeFacade employeeFacade;

    @PostMapping(value = "/punch-in-preference", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO createNewEmployee(@RequestBody PunchInRequest punchInRequest) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            employeeFacade.punchInPreference(punchInRequest);
        } catch (Exception e) {
            log.error("exception_in_test_api", e);
        }
        MetaDataDTO metaDataDTO = MetaDataDTO.builder().returnCode(ReturnCode.SC_001).build();
        responseDTO.setMeta(metaDataDTO);
        log.info("test_api_response: {}", responseDTO);
        return responseDTO;
    }
}
