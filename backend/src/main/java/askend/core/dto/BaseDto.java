package askend.core.dto;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
public abstract class BaseDto implements Serializable {

    private Date createdAt;
    private Date lastModifiedAt;
    private Date deletedAt;
}
