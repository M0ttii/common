package m0ttii.com.github.common.repository.user;


import com.google.inject.Inject;
import com.google.inject.name.Named;
import m0ttii.com.github.common.repository.Repository;
import m0ttii.com.github.common.utils.AbuseSystemConstants;
import m0ttii.com.github.common.entity.user.UserEntity;
import m0ttii.com.github.common.repository.punishments.PointRepository;
import m0ttii.com.github.common.repository.punishments.PunishmentRepository;
import xyz.morphia.Datastore;


import java.util.UUID;

public class UserRepository extends Repository<UserEntity> {

    @Inject private PunishmentRepository punishmentRepository;
    @Inject private PointRepository pointRepository;

    @Inject
    protected UserRepository(@Named(AbuseSystemConstants.AbuseSystem_DATASTORE) Datastore datastore) {
        super(UserEntity.class, datastore);
    }

    public UserEntity findByUniqueId(UUID uuid) {
        return this.createQuery()
                .field("uuid").equal(uuid)
                .get();
    }


    public UserEntity findByLatestName(String name) {
        return this.createQuery()
                .field("latestName").equal(name)
                .get();
    }


    /*public List<AbuseSystemPunishment> getPunishments() {
        return punishmentRepository.createQuery().
    }*/

    //DEBUG
    public UserEntity createUser(String latestName) {
        UserEntity user = new UserEntity();
        user.setUuid(UUID.fromString(latestName));
        user.setLatestName(latestName);
        pointRepository.createRepo(UUID.fromString(latestName));
        getDatastore().save(user);
        return user;
    }

    public UserEntity createUser(UUID uuid, String latestName) {
        UserEntity user = new UserEntity();
        user.setUuid(uuid);
        user.setLatestName(latestName);
        pointRepository.createRepo(uuid);
        getDatastore().save(user);
        return user;
    }








}
