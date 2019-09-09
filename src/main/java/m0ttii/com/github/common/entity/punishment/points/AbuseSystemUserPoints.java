package m0ttii.com.github.common.entity.punishment.points;


import lombok.Getter;
import lombok.Setter;
import m0ttii.com.github.common.entity.AbstractEntity;
import xyz.morphia.annotations.Embedded;
import xyz.morphia.annotations.Entity;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity(value = "punishpoints", noClassnameStored = true)
public class AbuseSystemUserPoints extends AbstractEntity {
    private UUID player;
    @Embedded
    private List<AbuseSystemUserPointsTemplate> templates;


}
