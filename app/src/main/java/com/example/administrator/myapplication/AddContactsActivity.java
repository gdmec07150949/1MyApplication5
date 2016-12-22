package com.example.administrator.myapplication;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by yusiqing on 2016/10/29.
 */
public class AddContactsActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText mobileEditText;
    private EditText qqEditText;
    private EditText danweiEditText;
    private EditText addressEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("添加联系人");
        nameEditText = (EditText) findViewById(R.id.name);
        mobileEditText = (EditText) findViewById(R.id.mobile);
        danweiEditText = (EditText) findViewById(R.id.danwei);
        qqEditText = (EditText) findViewById(R.id.qq);
        addressEditText = (EditText) findViewById(R.id.address);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, 1, Menu.NONE, "保存");
        menu.add(Menu.NONE, 2, Menu.NONE, "返回");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                if (!nameEditText.getText().toString().equals("")) {
                    Uesr uesr = new Uesr();
                    uesr.setName(nameEditText.getText().toString());
                    uesr.setMOBILE(mobileEditText.getText().toString());
                    uesr.setDANWEI(danweiEditText.getText().toString());
                    uesr.setQq(qqEditText.getText().toString());
                    uesr.setADDRESS(addressEditText.getText().toString());

                    ContactsTable ct = new ContactsTable(AddContactsActivity.this);

                    if (ct.addData(uesr)) {
                        Toast.makeText(AddContactsActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(AddContactsActivity.this, "添加失败", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(AddContactsActivity.this, "请先输入数据", Toast.LENGTH_SHORT).show();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
