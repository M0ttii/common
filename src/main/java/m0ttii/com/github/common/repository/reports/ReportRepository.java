package m0ttii.com.github.common.repository.reports;

import m0ttii.com.github.common.entity.reports.ReportEntity;
import m0ttii.com.github.common.entity.user.UserEntity;
import m0ttii.com.github.common.repository.Repository;
import m0ttii.com.github.common.repository.user.UserRepository;
import m0ttii.com.github.common.utils.AbuseSystemConstants;
import m0ttii.com.github.common.utils.RandomString;
import xyz.morphia.Datastore;

import javax.inject.Inject;
import javax.inject.Named;
import java.security.SecureRandom;
import java.util.Date;
import java.util.UUID;

public class ReportRepository extends Repository<ReportEntity> {

    @com.google.inject.Inject
    private UserRepository userRepository;

    @Inject
    protected ReportRepository(@Named(AbuseSystemConstants.AbuseSystem_DATASTORE) Datastore datastore) {
        super(ReportEntity.class, datastore);
    }

    public ReportEntity getReport(String id){
        return this.createQuery()
                .field("id")
                .equal(id).get();
    }

    public ReportEntity getActiveReport(UUID uuid){
        UserEntity userEntity = userRepository.findByUniqueId(uuid);

        ReportEntity reportEntity = this.createQuery()
                .field("player")
                .equal(userEntity).get();

        if(reportEntity.isActive()){
            return reportEntity;
        }
        return null;
    }

    public void createReport(UUID playerUUID, UUID reporterUUID, String reason, String gamemode, String server){
        ReportEntity reportEntity = new ReportEntity();
        reportEntity.setActive(true);
        reportEntity.setDate(new Date());
        reportEntity.setGamemode(gamemode);
        RandomString randomString = new RandomString();
        reportEntity.setId(randomString.generateString(new SecureRandom(), 10));
        reportEntity.setServer(server);
        reportEntity.setPlayer(userRepository.findByUniqueId(playerUUID));
        reportEntity.setReporter(userRepository.findByUniqueId(reporterUUID));
        this.getDatastore().save(reportEntity);
    }


}
