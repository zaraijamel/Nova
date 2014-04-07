package name.oleg;

import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientFactory;
import com.google.code.linkedinapi.client.oauth.LinkedInAccessToken;
import com.google.code.linkedinapi.client.oauth.LinkedInOAuthService;
import com.google.code.linkedinapi.client.oauth.LinkedInRequestToken;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/service-context.xml"})
public class LinkedinTest {

    @Autowired
    private LinkedInOAuthService oAuthServiceFactory;

    @Autowired
    private LinkedInApiClientFactory clientFactory;

    @Test
    public void test() {
        LinkedInRequestToken requestToken = oAuthServiceFactory.getOAuthRequestToken("http://www.tut.by");
        String authorizationUrl = requestToken.getAuthorizationUrl();

        String oauthVerifier = "test";
        LinkedInAccessToken accessToken = oAuthServiceFactory.getOAuthAccessToken(requestToken, oauthVerifier);
        LinkedInApiClient linkedInApiClient = clientFactory.createLinkedInApiClient(accessToken);
        System.err.println("");
    }
}
