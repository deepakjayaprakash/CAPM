package capm.dto.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author deepak.jayaprakash
 */
@Data
public class ResponseDTO implements Serializable {
    private static final long serialVersionUID = -3800336684834821929L;
    private MetaData meta;
    private Object data;
}
