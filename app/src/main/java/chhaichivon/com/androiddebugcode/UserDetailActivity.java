package chhaichivon.com.androiddebugcode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserDetailActivity extends AppCompatActivity {

    @BindView(R.id.tv_first_name)
    TextView mTextViewFirstName;
    @BindView(R.id.tv_last_name)
    TextView mTextViewLastName;
    @BindView(R.id.tv_email)
    TextView mTextViewEmail;
    @BindView(R.id.imageView2)
    ImageView imageView;

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        ButterKnife.bind(this);

//https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/User_icon_2.svg/220px-User_icon_2.svg.png

        // Using getSerializableExtra(String key) method
        user = (User) getIntent().getSerializableExtra("user");

        Log.d("Get User ", user.getLastName());
        Picasso.with(getApplicationContext()).load("https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/User_icon_2.svg/220px-User_icon_2.svg.png").into(imageView);
        mTextViewFirstName.setText(user.getFirstName());
        mTextViewLastName.setText(user.getLastName());
        mTextViewEmail.setText(user.getEmail());
    }
}
