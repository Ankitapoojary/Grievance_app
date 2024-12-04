package com.example.activity_intro;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class bridges extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private static final int PICK_VIDEO_REQUEST = 2;
    private static final int PICK_AUDIO_REQUEST = 3;

    private ImageView pickedbridgesImage;
    private RadioButton bridgesSelectButton;
    private RadioButton bridgesUploadButton;
    private RadioButton bridgesSelectVideoButton;
    private RadioButton bridgesUploadVideoButton;
    private RadioButton bridgesSelectAudioButton;
    private RadioButton bridgesUploadAudioButton;
    private EditText editbridgesText;

    private Uri imageUri;
    private Uri videoUri;
    private Uri audioUri;

    private StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bridges);

        pickedbridgesImage = findViewById(R.id.pickedbridgesImage);
        bridgesSelectButton = findViewById(R.id.bridgesselectbutton);
        bridgesUploadButton = findViewById(R.id.bridgesuploadbutton);
        bridgesSelectVideoButton = findViewById(R.id.bridgesselectvideobutton);
        bridgesUploadVideoButton = findViewById(R.id.bridgesuploadvideobutton);
        bridgesSelectAudioButton = findViewById(R.id.bridgesselectaudiobutton);
        bridgesUploadAudioButton = findViewById(R.id.bridgesuploadaudiobutton);
        editbridgesText = findViewById(R.id.editbridgesText);

        storageReference = FirebaseStorage.getInstance().getReference();

        bridgesSelectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImageChooser();
            }
        });

        bridgesUploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();
            }
        });

        bridgesSelectVideoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVideoChooser();
            }
        });

        bridgesUploadVideoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadVideo();
            }
        });
        bridgesSelectAudioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {openAudioChooser();}
        });

        bridgesUploadAudioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadAudio();
            }
        });
    }

    private void openImageChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    private void openVideoChooser() {
        Intent intent = new Intent();
        intent.setType("video/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_VIDEO_REQUEST);
    }
    private void openAudioChooser() {
        Intent intent = new Intent();
        intent.setType("audio/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_AUDIO_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imageUri = data.getData();
            pickedbridgesImage.setImageURI(imageUri);
        } else if (requestCode == PICK_VIDEO_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            videoUri = data.getData();
        }else if (requestCode == PICK_AUDIO_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            audioUri = data.getData();
        }
    }

    private void uploadImage() {
        if (imageUri != null) {
            StorageReference imageRef = storageReference.child("images/" + System.currentTimeMillis() + ".jpg");
            imageRef.putFile(imageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            // Handle successful image upload
                            Toast.makeText(bridges.this, "Image uploaded successfully", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            // Handle failed image upload
                            Toast.makeText(bridges.this, "Image upload failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        } else {
            // No image selected
            Toast.makeText(this, "Please select an image", Toast.LENGTH_SHORT).show();
        }
    }

    private void uploadVideo() {
        if (videoUri != null) {
            StorageReference videoRef = storageReference.child("videos/" + System.currentTimeMillis() + ".mp4");
            videoRef.putFile(videoUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            // Handle successful video upload
                            Toast.makeText(bridges.this, "Video uploaded successfully", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            // Handle failed video upload
                            Toast.makeText(bridges.this, "Video upload failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        } else {
            // No video selected
            Toast.makeText(this, "Please select a video", Toast.LENGTH_SHORT).show();
        }
    }
    private void uploadAudio() {
        if (audioUri != null) {
            StorageReference audioRef = storageReference.child("audio/" + System.currentTimeMillis() + ".mp3");
            audioRef.putFile(audioUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            // Handle successful audio upload
                            Toast.makeText(bridges.this, "Audio uploaded successfully", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            // Handle failed audio upload
                            Toast.makeText(bridges.this, "Audio upload failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        } else {
            // No audio selected
            Toast.makeText(this, "Please select an audio file", Toast.LENGTH_SHORT).show();
        }
    }

}