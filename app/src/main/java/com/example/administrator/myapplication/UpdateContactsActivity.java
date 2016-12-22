package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by yusiqing on 2016/11/10.
 */
public class UpdateContactsActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText mobileEditText;
    private EditText qqEditText;
    private EditText danweiEditText;
    private EditText addressEditText;
    private Uesr uesr;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        nameEditText = (EditText) findViewById(R.id.name);
        mobileEditText = (EditText) findViewById(R.id.mobile);
        danweiEditText = (EditText) findViewById(R.id.danwei);
        qqEditText = (EditText) findViewById(R.id.qq);
        addressEditText = (EditText) findViewById(R.id.address);

        Bundle localBundle =getIntent().getExtras();
        int id =localBundle.getInt("user_ID");
        ContactsTable ct = new ContactsTable(this);

        uesr=ct.getUserByID(id);

        nameEditText.setText(uesr.getNAME());
        mobileEditText.setText(uesr.getMOBILE());
        danweiEditText.setText(uesr.getDANWEI());
        qqEditText.setText(uesr.getQQ());
        addressEditText.setText(uesr.getADDRESS());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"保存");
        menu.add(0,2,0,"返回");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                if (!nameEditText.getText().toString().trim().equals("")){
                    uesr.setName(nameEditText.getText().toString());
                    uesr.setMOBILE(mobileEditText.getText().toString());
                    uesr.setDANWEI(danweiEditText.getText().toString());
                    uesr.setQq(qqEditText.getText().toString());
                    uesr.setADDRESS(addressEditText.getText().toString());
                    ContactsTable ct = new ContactsTable(this);
                    if (ct.updateUesr((uesr))){
                        Toast.makeText(this,"修改成功了",Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(this,"修改失败了",Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(this,"数据不能为空",Toast.LENGTH_LONG).show();
                }
                break;
            case 2:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
