# MongoDB DatabaseAPI


## Integrate into your plugin
**We will use Guice to inject the dependency.**
```java
AbuseSystemConfig abuseSystemConfig = new AbuseSystemConfig("host", port, "username" , "password", "database");
Injector injector = Guice.createInjector(new AbuseSystemCommon(abuseSystemConfig));
```

**Second, you need to access the Repository of an object. For example, we access the UserRepository where all users all stored. **
```java
UserRepository userRepository = injector.getInstance(UserRepository.class);
```

**Now, you can interact with the users collection in the database. Here are some examples:**
```java
//Create a User
userRepository.createUser();
//Get a User by his UniqueID
userRepository.findByUniqueID(UUID)
```
## Repositories
**Following repositories are available at the moment:**

------------

###### Users
- UserRepository
###### Punishment System
- PunishmentRepository
- PointRepository
- TemplateRepository
- ReportRepository
###### Message System (Punish Messages, Report Messages, Global Prefixes etc.)
- MessageRepository
###### Map Repository (Spawn points etc, Not implemented yet!!!)
- MapRepository



