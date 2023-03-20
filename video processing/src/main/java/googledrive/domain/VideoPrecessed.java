package googledrive.domain;

import googledrive.domain.*;
import googledrive.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class VideoPrecessed extends AbstractEvent {

    private Long id;
    private Long fileid;
    private String url;

    public VideoPrecessed(Video aggregate) {
        super(aggregate);
    }

    public VideoPrecessed() {
        super();
    }
}
