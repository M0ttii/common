package m0ttii.com.github.common.repository.punishments;

import m0ttii.com.github.common.utils.AbuseSystemConstants;
import m0ttii.com.github.common.entity.MessageEntity;
import m0ttii.com.github.common.repository.Repository;
import xyz.morphia.Datastore;

import javax.inject.Inject;
import javax.inject.Named;

public class MessageRepository extends Repository<MessageEntity> {

    @Inject
    protected MessageRepository(@Named(AbuseSystemConstants.AbuseSystem_DATASTORE) Datastore datastore) {
        super(MessageEntity.class, datastore);
    }

    public String getByName(String name){
        return this.createQuery()
                .field("name")
                .equal(name).get().getMessage();
    }

    public MessageEntity createMessage(String name, String message){
        if(!(this.createQuery().field("name").equal(name).get() == null)){
            return null;
        }
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setName(name);
        messageEntity.setMessage(message);
        getDatastore().save(messageEntity);
        return messageEntity;
    }
}
