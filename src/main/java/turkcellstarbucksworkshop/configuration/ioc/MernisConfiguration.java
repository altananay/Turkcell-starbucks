package turkcellstarbucksworkshop.configuration.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import turkcellstarbucksworkshop.adapters.mernis.WUWKPSPublicSoap;

@Configuration
public class MernisConfiguration {

    @Bean
    public WUWKPSPublicSoap getMernis()
    {
        return new WUWKPSPublicSoap();
    }
}