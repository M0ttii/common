package m0ttii.com.github.common.entity.reports;

import lombok.Getter;
import lombok.Setter;
import m0ttii.com.github.common.entity.AbstractEntity;
import m0ttii.com.github.common.entity.user.UserEntity;
import xyz.morphia.annotations.Entity;
import xyz.morphia.annotations.Indexed;
import xyz.morphia.annotations.Reference;

import java.util.Date;

@Setter
@Getter
@Entity(value = "reports", noClassnameStored = true)
public class ReportEntity extends AbstractEntity{
    @Indexed(unique = true)
    private String id;
    @Reference
    private UserEntity reporter;
    @Reference
    private UserEntity player;
    private String reason;
    private String gamemode;
    private String server;
    private Date date;
    private boolean active;

}
