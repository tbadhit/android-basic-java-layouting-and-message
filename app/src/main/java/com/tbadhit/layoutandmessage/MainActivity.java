package com.tbadhit.layoutandmessage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.tbadhit.layoutandmessage.databinding.MessageBoxBinding;

// 1 membuat layout "linear_layout"
// 2. latihan membuat layout "form_linear_login"
// 3. membuat layout "relative_layout"
// 4. latihan relative layout "latihan_relative_layout"
// 5. membuat constraint layout latihan "constraint_layout"
// 6. Masuk materi message box
// 7. membuat layout "message_box" pilih linear layout
// 8. bikin logic di mainActivity dengan menggunakan view Binding
public class MainActivity extends AppCompatActivity {

    private MessageBoxBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =  MessageBoxBinding.inflate(getLayoutInflater());
        // kalo mau jalanin layoutnya ubah dbwh ini
        // setContentView(R.layout.message_box);
        setContentView(binding.getRoot());

        // 1
        binding.btnToast.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Ini adalah toast", Toast.LENGTH_SHORT).show();
        });

        // 2
        binding.btnAlertDialog.setOnClickListener(v -> {
            AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
            alert.setTitle("ini judul alert");
            alert.setIcon(R.drawable.ic_launcher_background);
            alert.setMessage("ini pesan aler");
            alert.setPositiveButton("ya", (dialog, which) -> {
                Toast.makeText(MainActivity.this, "button positive", Toast.LENGTH_SHORT).show();
            });
            alert.setNegativeButton("tidak", (dialog, which) -> {
                Toast.makeText(MainActivity.this, "button negative", Toast.LENGTH_SHORT).show();
            });
            alert.setNeutralButton("cancel", (dialog, which) -> {
                Toast.makeText(MainActivity.this, "button neutral", Toast.LENGTH_SHORT).show();
            });
            alert.show();
        });

        // 3
        // ke layout message_box ->
        binding.btnSnackbar.setOnClickListener(v -> {
            Snackbar mySnackBar = Snackbar.make(findViewById(R.id.layout_message_box), "ini adalah snackbar", Snackbar.LENGTH_SHORT);
            mySnackBar.setAction("toast", v1 -> {
                Toast.makeText(this, "button snackbar", Toast.LENGTH_SHORT).show();
            });
            mySnackBar.show();

        });
    }
}