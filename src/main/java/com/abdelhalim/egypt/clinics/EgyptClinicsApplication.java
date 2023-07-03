package com.abdelhalim.egypt.clinics;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.FileInputStream;
import java.io.IOException;

import static com.abdelhalim.egypt.clinics.utils.ImageUtils.BUCKET_NAME;

@SpringBootApplication()
@EnableJpaRepositories
public class EgyptClinicsApplication {

    public static void main(String[] args) {
        FileInputStream serviceAccount;
        try {
            serviceAccount = new FileInputStream("firebase-adminsdk.json");
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setStorageBucket(BUCKET_NAME)
                    .build();
            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            // connect firebase admin to the project to upload images or comment this line to run the app without firebase
            throw new RuntimeException(e);
        }


        SpringApplication.run(EgyptClinicsApplication.class, args);
    }

}
