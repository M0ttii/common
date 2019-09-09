package m0ttii.com.github.common.entity.punishment;

import lombok.Getter;
import lombok.Setter;
import m0ttii.com.github.common.entity.AbstractEntity;
import m0ttii.com.github.common.entity.user.UserEntity;
import xyz.morphia.annotations.*;

import java.util.Date;


@Setter
@Getter
@Entity(value = "punishment", noClassnameStored = true)
public class AbuseSystemPunishment extends AbstractEntity {
    @Reference
    private UserEntity player_id;
    @Reference
    private UserEntity punisher_id;
    private AbuseSystemType type;
    private String reason;
    private String evidence;
    private Date expire_at;
}
