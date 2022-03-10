package api.motortracker.motortracker.service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;
import com.amazonaws.services.cognitoidp.model.GetUserRequest;
import com.amazonaws.services.cognitoidp.model.GetUserResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CognitoClientSService {

    private AWSCognitoIdentityProvider client;

    public CognitoClientSService() {
        client = createCognitoClient();
    }

    private AWSCognitoIdentityProvider createCognitoClient() {
        AWSCredentials cred = new BasicAWSCredentials("AKIA5N2QTOGGPICAIWWG", "pkjMOTsb4b+9IfykZ3vZ5B2USzFoD3vqJpCgJVpb");
        AWSCredentialsProvider credProvider = new AWSStaticCredentialsProvider(cred);
        return AWSCognitoIdentityProviderClientBuilder.standard()
                .withCredentials(credProvider)
                .withRegion(Regions.US_EAST_1)
                .build();
    }

    //You need to pas accessToken and username
    public boolean isUserAuthenticated(String username, String accessToken) {
        GetUserRequest userRequest = new GetUserRequest();
        userRequest.setAccessToken(accessToken);

        try {
            GetUserResult result = client.getUser(userRequest);
            //use this to ensure it is the same username. The client needs to pass username and accessToken
            String existingUsername = result.getUsername();

            if (username.equals(existingUsername)) {
                return true;
            }

            return false;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

}
