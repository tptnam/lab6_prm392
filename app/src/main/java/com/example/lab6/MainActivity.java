package com.example.lab6;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        MenuItemId menuItemId = MenuItemId.fromId(item.getItemId());
        switch (menuItemId) {
            case MENU_EXIT:
                finishAffinity(); // This will close the activity
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private enum MenuItemId {
        NONE(-1),
        MENU_EXIT(R.id.exit);

        private final int id;

        MenuItemId(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public static MenuItemId fromId(int id) {
            for (MenuItemId menuItemId : values()) {
                if (menuItemId.id == id) {
                    return menuItemId;
                }
            }
            return NONE;
        }
    }
}
