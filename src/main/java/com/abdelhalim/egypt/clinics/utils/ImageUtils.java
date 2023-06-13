package com.abdelhalim.egypt.clinics.utils;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.firebase.cloud.StorageClient;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

public class ImageUtils {

    public static String uploadObjectFromMemory(
            String bucketName, String objectName, byte[] contents, String extension) throws IOException {

        BlobId blobId = BlobId.of(bucketName, objectName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();

        Bucket bucket = StorageClient.getInstance().bucket();
        Blob blob = bucket.create(objectName, new ByteArrayInputStream(contents), "image/" + extension);
        System.out.println(blob +
                "Object "
                + objectName
                + " uploaded to bucket "
                + bucketName
                + " with contents "
                + contents);

        return blob.signUrl(365 * 10, TimeUnit.DAYS).toString();
    }

    public static void deleteImage(String bucketName, String objectName) {

        Bucket bucket = StorageClient.getInstance().bucket();
        Blob blob = bucket.get(objectName);
        blob.delete();
        System.out.println("Object " + objectName + " was deleted from " + bucketName);
    }

    public static String saveImageBase64(String base64Image, String objectPath) {
        try {
            String extension = Base64Utils.getFileExtensionFromBase64(base64Image);
            byte[] decodedBytes = Base64.getDecoder().decode(base64Image.split(",")[1]);

            return ImageUtils.uploadObjectFromMemory("clink-3b1fe.appspot.com", objectPath, decodedBytes, extension);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
