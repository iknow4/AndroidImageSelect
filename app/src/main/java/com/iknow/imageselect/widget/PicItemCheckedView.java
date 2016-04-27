package com.iknow.imageselect.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.iknow.imageselect.R;
import com.iknow.imageselect.utils.DeviceInforHelper;

public class PicItemCheckedView extends RelativeLayout implements Checkable {

    private Context mContext;
    private boolean mChecked;
    private SimpleDraweeView mImgView = null;
    private ImageView mSelectView;

  private static final int columnNum = 3;

    public PicItemCheckedView(Context context,boolean isHide) {
      this(context, null, 0,isHide);
    }

    public PicItemCheckedView(Context context) {
        this(context, null, 0,false);
    }

    public PicItemCheckedView(Context context, AttributeSet attrs) {
        this(context, attrs, 0,false);
    }

    public PicItemCheckedView(Context context, AttributeSet attrs, int defStyle,boolean isHide) {
        super(context, attrs, defStyle);
        mContext = context;
        LayoutInflater.from(mContext).inflate(R.layout.image_select_item, this);
        mImgView = (SimpleDraweeView) findViewById(R.id.img_view);
       
        int size = DeviceInforHelper.getScreenWidth()/ columnNum;
		    FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) mImgView.getLayoutParams();
        params.width = size;
        params.height = size;
        mImgView.setLayoutParams(params);

        mSelectView = (ImageView) findViewById(R.id.select);
        if(isHide) {
          ImageView mUnSelectView = (ImageView) findViewById(R.id.unselect);
          mUnSelectView.setVisibility(View.GONE);
        }
    }

	@Override
    public void setChecked(boolean checked) {
        mChecked = checked;
        mSelectView.setVisibility(checked ? View.VISIBLE : View.GONE);
    }

    @Override
    public boolean isChecked() {
        return mChecked;
    }

    @Override
    public void toggle() {
        setChecked(!mChecked);
    }

    public void setImgResId(int resId) {
        if (mImgView != null) {
            mImgView.setBackgroundResource(resId);
        }
    }
    
    public void setImageView(Bitmap bp){
    	if(mImgView != null){
    		mImgView.setImageBitmap(bp);
    	}
    }
    
    public void setImageView(Drawable db){
    	if(mImgView != null){
    		mImgView.setImageDrawable(db);
    	}
    }
    
    public ImageView getImageView(){
    	return mImgView;
    }

}
