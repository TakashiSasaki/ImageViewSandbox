package com.google.takashi316.sandbox;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ImageViewSandboxActivity extends Activity implements
		SurfaceHolder.Callback {

	ImageView imageView;
	SurfaceView surfaceView;
	LinearLayout linearLayout;
	TextView textViewMatrix;
	TextView textViewImageMatrix;
	TextView textViewScaleX;
	TextView textViewScaleY;
	TextView textViewScaleType;
	TextView textViewPivotX;
	TextView textViewPivotY;
	TextView textViewHeight;
	TextView textViewWidth;
	TextView textViewLeft;
	TextView textViewBottom;
	TextView textViewRight;
	TextView textViewTop;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		this.imageView = (ImageView) findViewById(R.id.imageView1);
		this.textViewHeight = (TextView) findViewById(R.id.textViewHeight);
		this.textViewImageMatrix = (TextView) findViewById(R.id.textViewImageMatrix);
		this.textViewMatrix = (TextView) findViewById(R.id.textViewMatrix);
		this.textViewPivotX = (TextView) findViewById(R.id.textViewPivotX);
		this.textViewPivotY = (TextView) findViewById(R.id.textViewPivotY);
		this.textViewScaleType = (TextView) findViewById(R.id.textViewScaleType);
		this.textViewScaleX = (TextView) findViewById(R.id.textViewScaleX);
		this.textViewScaleY = (TextView) findViewById(R.id.textViewScaleY);
		this.textViewWidth = (TextView) findViewById(R.id.textViewWidth);
		this.textViewLeft = (TextView) findViewById(R.id.textViewLeft);
		this.textViewBottom = (TextView) findViewById(R.id.textViewBottom);
		this.textViewRight = (TextView) findViewById(R.id.textViewRight);
		this.textViewTop = (TextView) findViewById(R.id.textViewTop);

		this.surfaceView = (SurfaceView) findViewById(R.id.surfaceView1);
		this.surfaceView.setZOrderOnTop(true);
		this.surfaceView.getHolder().setFormat(PixelFormat.TRANSLUCENT);
		this.surfaceView.getHolder().addCallback(this);
		// this.surfaceView.refreshDrawableState();
		// this.getWindow().setFormat(PixelFormat.TRANSLUCENT);


	}

	@Override
	public void onStart() {
		super.onStart();
		
		Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.lena);
		this.imageView.setImageBitmap(b);
		// The Matrix class holds a 3x3 matrix for transforming coordinates.
		Matrix im = this.imageView.getImageMatrix();
		this.textViewImageMatrix.setText(im.toString());
		Matrix m = this.imageView.getMatrix();
		this.textViewMatrix.setText(m.toString());
		this.textViewScaleX.setText("" + this.imageView.getScaleX());
		this.textViewScaleY.setText("" + this.imageView.getScaleY());
		this.textViewScaleType.setText("" + this.imageView.getScaleType());
		this.textViewPivotX.setText("" + this.imageView.getPivotX());
		this.textViewPivotY.setText("" + this.imageView.getPivotY());
		this.textViewHeight.setText("" + this.imageView.getHeight());
		this.textViewWidth.setText("" + this.imageView.getWidth());

		Drawable d = this.imageView.getDrawable();
		Rect r = d.getBounds();
		this.textViewLeft.setText("" + r.left);
		this.textViewBottom.setText("" + r.bottom);
		this.textViewRight.setText("" + r.right);
		this.textViewTop.setText("" + r.top);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		Log.v("surfaceChanged", "called");
		Paint paint = new Paint();
		holder.setFormat(PixelFormat.TRANSPARENT);
		Canvas canvas = holder.lockCanvas();
		canvas.drawColor(Color.TRANSPARENT);
		paint.setColor(Color.BLUE);
		paint.setTextSize(24);
		paint.setAntiAlias(true);
		canvas.drawText(
				"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",
				100, 100, paint);
		holder.unlockCanvasAndPost(canvas);

	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		Log.v("surfaceCreated", "called");
	}// surfaceCreated

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		Log.v("surfaceDestroyed", "called");
		// TODO Auto-generated method stub

	}// surfaceDestroyed
}
