package com.abdelhalim.egypt.clinics.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;

import static com.abdelhalim.egypt.clinics.utils.ImageUtils.BUCKET_NAME;

@Service
public class FBInitialize {

    @PostConstruct
    public void initialize() {

        try {
            FileInputStream serviceAccount = new FileInputStream("firebase-adminsdk.json");
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setStorageBucket(BUCKET_NAME)
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            } else {
                FirebaseApp.getApps().get(0);
            }
        } catch (IOException e) {
            // connect firebase admin to the project to upload images or comment this line to run the app without firebase
            throw new RuntimeException(e);
        }

    }
}
