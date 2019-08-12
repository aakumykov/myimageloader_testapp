package ru.aakumykov.me.myimageloader_testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.aakumykov.me.myimageloader.MyImageLoader;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.imageContainer)
    FrameLayout imageContainer;

//    private String imageURL = "https://i.ibb.co/zXCrWM7/Apps-freebsd-icon.png";
    private String imageURL = "https://i.ibb.co/TWDcwv3/a222ae88502d6a40c746f68d0103aae5.jpg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    void onButtonClicked() {
        removeImage();
//        showProgressBar();

        MyImageLoader.loadImageToContainer(
                this,
                imageContainer,
                imageURL,
                true,
                R.drawable.ic_broken_image_black_24dp,
                new MyImageLoader.Callbacks() {
                    @Override
                    public void onImageLoadSuccess(Drawable imageDrawable) {
//                        hideProgressBar();
                    }

                    @Override
                    public void onImageLoadError() {
//                        hideProgressBar();
                    }
                }
        );
    }

    private void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    private void removeImage() {
        imageContainer.removeAllViews();
    }
}
