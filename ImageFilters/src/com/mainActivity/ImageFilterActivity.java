package com.mainActivity;

import com.imageFilters.ComicFilter;
import com.imageFilters.GlowingEdgeFilter;
import com.imageFilters.IceFilter;
import com.imageFilters.MoltenFilter;
import com.imageFilters.SoftGlowFilter;
import com.imageFilters.BrightContrastFilter;
import com.imageFilters.GaussianBlurFilter;
import com.util.ImageCache;
import com.util.ImageUtil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class ImageFilterActivity extends Activity {

	ImageView imageView1, imageView2;
	Drawable mDrawable;
	Bitmap mBitmap;

	Context mContext;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image);
		mContext = this;
		findView();

		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		int pos = bundle.getInt("position", 0);
		Bitmap tmpBitmap;
		switch (pos) {
		case 0:
			if (ImageCache.get("IceFilter") != null) {  //ImageCache is use hash map
				tmpBitmap = ImageCache.get("IceFilter");
				imageView2.setImageBitmap(tmpBitmap);
				break;
			}
			tmpBitmap = new IceFilter(mBitmap).imageProcess().getDstBitmap();
			imageView2.setImageBitmap(tmpBitmap);
			ImageCache.put("IceFilter", tmpBitmap);
			break;
		case 1:
			if (ImageCache.get("MoltenFilter") != null) {
				tmpBitmap = ImageCache.get("MoltenFilter");
				imageView2.setImageBitmap(tmpBitmap);
				break;
			}
			tmpBitmap = new MoltenFilter(mBitmap).imageProcess().getDstBitmap();
			imageView2.setImageBitmap(tmpBitmap);
			ImageCache.put("MoltenFilter", tmpBitmap);
			break;
		case 2:
			if (ImageCache.get("ComicFilter") != null) {
				tmpBitmap = ImageCache.get("ComicFilter");
				imageView2.setImageBitmap(tmpBitmap);
				break;
			}
			tmpBitmap = new ComicFilter(mBitmap).imageProcess().getDstBitmap();
			imageView2.setImageBitmap(tmpBitmap);
			ImageCache.put("ComicFilter", tmpBitmap);
			break;
		case 3:
			if (ImageCache.get("SoftGlowFilter") != null) {
				tmpBitmap = ImageCache.get("SoftGlowFilter");
				imageView2.setImageBitmap(tmpBitmap);
				break;
			}
			tmpBitmap = new SoftGlowFilter(mBitmap, 10, 0.1f, 0.1f).imageProcess().getDstBitmap();
			imageView2.setImageBitmap(tmpBitmap);
			ImageCache.put("SoftGlowFilter", tmpBitmap);
			break;
		case 4:
			if (ImageCache.get("GlowingEdgeFilter") != null) {
				tmpBitmap = ImageCache.get("GlowingEdgeFilter");
				imageView2.setImageBitmap(tmpBitmap);
				break;
			}
			tmpBitmap = new GlowingEdgeFilter(mBitmap).imageProcess().getDstBitmap();
			imageView2.setImageBitmap(tmpBitmap);
			ImageCache.put("GlowingEdgeFilter", tmpBitmap);
			break;
			
		case 5:
			if (ImageCache.get("BrightContrastFilter") != null) {
				tmpBitmap = ImageCache.get("BrightContrastFilter");
				imageView2.setImageBitmap(tmpBitmap);
				break;
			}
			tmpBitmap = new BrightContrastFilter(mBitmap).imageProcess().getDstBitmap();
			imageView2.setImageBitmap(tmpBitmap);
			ImageCache.put("BrightContrastFilter", tmpBitmap);
			break;
			
		case 6:
			if (ImageCache.get("GaussianBlurFilter") != null) {
				tmpBitmap = ImageCache.get("GaussianBlurFilter");
				imageView2.setImageBitmap(tmpBitmap);
				break;
			}
			tmpBitmap = new GaussianBlurFilter(mBitmap).imageProcess().getDstBitmap();
			imageView2.setImageBitmap(tmpBitmap);
			ImageCache.put("GaussianBlurFilter", tmpBitmap);
			break;
			
		default:
			imageView2.setImageBitmap(mBitmap);
			break;
		}
	}

	private void findView() {
		// TODO Auto-generated method stub
		imageView1 = (ImageView) findViewById(R.id.imageView1);
		imageView2 = (ImageView) findViewById(R.id.imageView2);
		mDrawable = imageView1.getDrawable();//put in picture
		mBitmap = ImageUtil.readBitMap(mContext, R.drawable.face); //load
		imageView2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//imageView1.setVisibility(View.GONE);
			}
		});
	}
}
