package m0ttii.com.github.common;


import com.google.inject.Guice;
import com.google.inject.Injector;
import m0ttii.com.github.common.repository.user.UserRepository;
import m0ttii.com.github.common.utils.AbuseSystemConfig;

public class Test {

    public static void main( String[] args ){
        AbuseSystemConfig abuseSystemConfig = new AbuseSystemConfig("localhost", 27017, "" , "", "test");
        Injector injector = Guice.createInjector(new AbuseSystemCommon(abuseSystemConfig));

        UserRepository userRepository = injector.getInstance(UserRepository.class);
        userRepository.createUser()



    }
}
