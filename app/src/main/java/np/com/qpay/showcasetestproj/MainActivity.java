package np.com.qpay.showcasetestproj;

import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.MotionEvent;

import np.com.qpay.showcasetestproj.showcaseview.OnShowcaseEventListener;
import np.com.qpay.showcasetestproj.showcaseview.ShowcaseView;
import np.com.qpay.showcasetestproj.showcaseview.targets.ViewTarget;

public class MainActivity extends AppCompatActivity{

    ViewTarget target;
    int frame_count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        target = new ViewTarget(R.id.pay_frame, this);
        new ShowcaseView.Builder(this)
                .withHoloShowcase()
                .useDecorViewAsParent()
                .setTarget(target)
                .setContentTitle("payFame")
                .setContentText("This is payframe")
                .setStyle(R.style.CustomShowcaseTheme3)
                .setShowcaseEventListener(onShowcaseEventListener)
                .build();
    }

    OnShowcaseEventListener onShowcaseEventListener = new OnShowcaseEventListener() {
        @Override
        public void onShowcaseViewHide(ShowcaseView showcaseView) {
            if (frame_count == 1) {
                target = new ViewTarget(R.id.send, MainActivity.this);
                new ShowcaseView.Builder(MainActivity.this)
                        .withHoloShowcase()
                        .useDecorViewAsParent()
                        .setTarget(target)
                        .setContentTitle("payFame")
                        .setContentText("This is payframe")
                        .setStyle(R.style.CustomShowcaseTheme3)
                        .setShowcaseEventListener(onShowcaseEventListener)
                        .build();
            } else if (frame_count == 2) {
                target = new ViewTarget(R.id.bill_payment, MainActivity.this);
                Paint p = new Paint();
                p.setTextSize(25);
                p.setColor(Color.parseColor("#000000"));
                new ShowcaseView.Builder(MainActivity.this)
                        .withHoloShowcase()
                        .useDecorViewAsParent()
                        .setTarget(target)
                        .setContentTitle("payFame")
                        .setContentTitlePaint(new TextPaint(p))
                        .setContentText("This is payframe")
                        .setStyle(R.style.CustomShowcaseTheme3)
                        .setShowcaseEventListener(onShowcaseEventListener)
                        .build();
            } else if (frame_count == 3) {
                target = new ViewTarget(R.id.nearby, MainActivity.this);
                new ShowcaseView.Builder(MainActivity.this)
                        .withHoloShowcase()
                        .useDecorViewAsParent()
                        .setTarget(target)
                        .setContentTitle("payFame")
                        .setContentText("This is payframe")
                        .setStyle(R.style.CustomShowcaseTheme4)
                        .setShowcaseEventListener(onShowcaseEventListener)
                        .build();
            }
            frame_count++;
        }

        @Override
        public void onShowcaseViewDidHide(ShowcaseView showcaseView) {

        }

        @Override
        public void onShowcaseViewShow(ShowcaseView showcaseView) {

        }

        @Override
        public void onShowcaseViewTouchBlocked(MotionEvent motionEvent) {

        }
    };
}
