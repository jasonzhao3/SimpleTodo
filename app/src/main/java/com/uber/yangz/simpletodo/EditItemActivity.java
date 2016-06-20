package com.uber.yangz.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    private EditText etItem;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        pos = getIntent().getIntExtra("pos", 0);
        String item = getIntent().getStringExtra("item");
        if (item == null) {
            item = "";
        }

        etItem = (EditText) findViewById(R.id.etEditItem);
        assert etItem != null;
        etItem.setText(item);
        int position = item.length();
        etItem.setSelection(position);
    }

    public void onSaveItem(View v) {
        // closes the activity and returns to first screen
        Intent data = new Intent();
        data.putExtra("item", etItem.getText().toString());
        data.putExtra("pos", pos);
        setResult(RESULT_OK, data);
        finish();
    }
}
