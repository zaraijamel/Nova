package name.oleg;

import com.google.code.linkedinapi.client.oauth.LinkedInOAuthService;
import com.google.code.linkedinapi.client.oauth.LinkedInOAuthServiceFactory;
import com.google.code.linkedinapi.client.oauth.LinkedInRequestToken;

public class LinkedinProcessor {
    private static final String CONSUMER_KEY = "77hnk6zqvjt474";
    private static final String CONSUMER_SECRET = "1t4aOLkm4EoGgWVE";

    public void test() {
        final LinkedInOAuthService oauthService = LinkedInOAuthServiceFactory.getInstance().createLinkedInOAuthService(CONSUMER_KEY, CONSUMER_SECRET);
        LinkedInRequestToken requestToken = oauthService.getOAuthRequestToken();
        String authUrl = requestToken.getAuthorizationUrl();

    }
}
