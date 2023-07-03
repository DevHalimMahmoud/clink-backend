package com.abdelhalim.egypt.clinics.utils;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.firebase.cloud.StorageClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.util.Base64;
import java.util.concurrent.TimeUnit;


public class ImageUtils {

    public static final String BUCKET_NAME = "clink-3b1fe.appspot.com";
    private static final Logger logger = LoggerFactory.getLogger(ImageUtils.class);
    private static final StorageClient storage = StorageClient.getInstance();

    private ImageUtils() {
        // Private constructor to prevent instantiation
    }

    private static String uploadObjectFromMemory(
            String bucketName, String objectName, byte[] contents, String extension) {

        BlobId blobId = BlobId.of(bucketName, objectName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();

        Bucket bucket = storage.bucket(bucketName);
        Blob blob = bucket.create(objectName, new ByteArrayInputStream(contents), "image/" + extension);
        logger.info("Object {} uploaded to bucket {} with contents {}", objectName, bucketName, contents);

        return blob.signUrl(365 * 100, TimeUnit.DAYS).toString();
    }

    public static void deleteImage(String objectName) {
        try {
            Bucket bucket = storage.bucket(BUCKET_NAME);
            Blob blob = bucket.get(objectName);
            if (blob != null) {
                blob.delete();
                logger.info("Object {} deleted from bucket {}", objectName, bucket.getName());
            } else {
                logger.warn("Object {} not found in bucket {}", objectName, bucket.getName());
            }
        } catch (Exception e) {
            logger.error("Error deleting object {}: {}", objectName, e.getMessage());
        }
    }

    public static String saveImageBase64(String base64Image, String objectPath) {
        try {
            String extension = Base64Utils.getFileExtensionFromBase64(base64Image);
            byte[] decodedBytes = Base64.getDecoder().decode(base64Image.split(",")[1]);

            return uploadObjectFromMemory(BUCKET_NAME, objectPath, decodedBytes, extension);
        } catch (Exception e) {
            logger.error("Error saving image: {}", e.getMessage());
            return null;
        }
    }

// Add other methods and improvements as needed
}