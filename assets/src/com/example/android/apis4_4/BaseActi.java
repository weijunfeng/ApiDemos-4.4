package com.example.android.apis4_4;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.Toast;

/**
 * Created by hexin on 2017/2/26.
 */
public class BaseActi extends Activity {
    private String layoutResId;
    private String className;
    private FrameLayout contentView;

    @Override
    public void setContentView(int layoutResID) {
        LayoutInflater.from(this).inflate(layoutResID, contentView, true);
        layoutResId = getResources().getResourceEntryName(layoutResID);
    }

    @Override
    public void setContentView(View view) {
        contentView.addView(view);
    }

    @Override
    public void setContentView(View view, LayoutParams params) {
        contentView.addView(view, params);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        className = this.getClass().getName().replaceAll("\\.", "/");
        requestWindowFeature();
        super.setContentView(R.layout.activity_base);
        contentView = (FrameLayout) findViewById(R.id.layout_content);
        findViewById(R.id.check_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BaseActi.this, layoutResId, Toast.LENGTH_LONG).show();
            }
        });
        findViewById(R.id.check_src).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BaseActi.this, className, Toast.LENGTH_LONG).show();
                startActivity(BroswerActi.getJumpIntent(BaseActi.this, "file:///android_asset/src/" + className));
            }
        });
    }

    public void requestWindowFeature() {

    }
}
