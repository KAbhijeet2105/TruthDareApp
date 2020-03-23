package india.abhijeet.k.truthdare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView bottle;
    Button spinner;

    Random random =new Random();
    int lastDirection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottle=findViewById(R.id.imageView);
        spinner=findViewById(R.id.button);


    }



    public void spin(View view)
    {

        int newDirection=random.nextInt(36000);

        float pivotX=bottle.getWidth()/2;
        float pivotY=bottle.getHeight()/2;


        Animation rotate =new RotateAnimation(lastDirection,newDirection,pivotX,pivotY);


        rotate.setDuration(4000);
        rotate.setFillAfter(true);


        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

                spinner.setEnabled(false);
                spinner.setBackground(getDrawable(R.drawable.custom_disabled));

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                spinner.setEnabled(true);
                spinner.setBackground(getDrawable(R.drawable.custom_button));

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        lastDirection=newDirection;

        bottle.startAnimation(rotate);


    }



}

