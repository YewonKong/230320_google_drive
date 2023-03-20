package googledrive.domain;

import googledrive.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class VideoPrecessed extends AbstractEvent {

    private Long id;
    private Long fileid;
    private String url;
}
