package com.hienqp.popupmenudemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPopup = (Button) findViewById(R.id.button_popup_menu);

        buttonPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu();
            }
        });
    }

    private void showMenu() {
        // khởi tạo 1 đối tượng PopupMenu tồn tại ở Context MainActivity.this, được gắn vào Button chỉ định
        androidx.appcompat.widget.PopupMenu popupMenu = new androidx.appcompat.widget.PopupMenu(MainActivity.this, buttonPopup);
        // lấy UI của Pop-up menu đã xây dựng gán cho đối tượng PopupMenu vừa tạo
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu_demo, popupMenu.getMenu());
        // sau khi có giao diện cho đối tượng PopupMenu, tiến hành show nó ra để nó có thể hiển thị
        popupMenu.show();
        // xử lý sự kiện khi click vào 1 trong các item trong PopupMenu
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_them:
                        buttonPopup.setText("Menu Thêm");
                        break;
                    case R.id.menu_xoa:
                        buttonPopup.setText("Menu Xóa");
                        break;
                    case R.id.menu_sua:
                        buttonPopup.setText("Menu Sửa");
                        break;
                }
                return false;
            }
        });
    }
}