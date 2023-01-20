package az.itcity.bina.config;


import az.itcity.bina.domain.Balance;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

import java.util.List;
import java.util.Map;

@Data
@Configuration
@ConfigurationProperties("bina")
public class BinaConfiguration {
    private String baseUrl;
    private String registerUrl;
    private boolean enableNotifications;
    private List<String> allowedIpList;
    private Map<String, Integer> balance;
    private List<Balance> defaultBalanceList;
    @DataSizeUnit(value = DataUnit.MEGABYTES)
    private DataSize maxUploadLimit;

}
