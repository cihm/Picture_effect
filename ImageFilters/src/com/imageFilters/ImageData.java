package com.imageFilters;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;

/**
 * 
 * @author ÑÇÉªboy
 * QQ 464102961
 */
public class ImageData {
	private Bitmap srcBitmap;
	private Bitmap dstBitmap;

	private int width;
	private int height;

	protected int[] colorArray;

	public ImageData(Bitmap bmp) {
		srcBitmap = bmp;
		width = bmp.getWidth();
		height = bmp.getHeight();
		dstBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
		//argb8888  =  Transparency r g b each use 8 bit
		initColorArray();
	}

	public ImageData clone() {
		return new ImageData(this.srcBitmap);
	}

	private void initColorArray() {
		colorArray = new int[width * height];
		srcBitmap.getPixels(colorArray, 0, width, 0, 0, width, height);
		//1.he array to receive the bitmap's colors 
		//2.The first index to write into pixels[]
		//4,5. The x coordinate of the first pixel to read from the bitmap
		//6,7  The number of pixels to read from each row 
	}

	public int getPixelColor(int x, int y) {
		return colorArray[y * srcBitmap.getWidth() + x];
	}

	public int getPixelColor(int x, int y, int offset) {
		return colorArray[y * srcBitmap.getWidth() + x + offset];
		
		
	}

	public int getRComponent(int x, int y) {
		return Color.red(colorArray[y * srcBitmap.getWidth() + x]);
		//argb is 0x_ _ _ _ _ _ _ _   
	    //b is 0x _ _
		//this is return  (x,y)'s red contributions   
		//color >> 16 : shift right 16 //argb is 16 so need to be binary will get 32 _ 
		
	}

	public int getRComponent(int x, int y, int offset) {
		return Color.red(colorArray[y * srcBitmap.getWidth() + x + offset]);
	}

	public int getGComponent(int x, int y) {
		return Color.green(colorArray[y * srcBitmap.getWidth() + x]);
	}

	public int getGComponent(int x, int y, int offset) {
		return Color.green(colorArray[y * srcBitmap.getWidth() + x + offset]);
	}

	public int getBComponent(int x, int y) {
		return Color.blue(colorArray[y * srcBitmap.getWidth() + x]);
	}

	public int getBComponent(int x, int y, int offset) {
		return Color.blue(colorArray[y * srcBitmap.getWidth() + x + offset]);
	}

	public void setPixelColor(int x, int y, int r, int g, int b) {
		int rgbcolor = (255 << 24) + (r << 16) + (g << 8) + b;
		//              alpa           
		colorArray[((y * srcBitmap.getWidth() + x))] = rgbcolor;
	}

	public void setPixelColor(int x, int y, int rgbcolor) {
		colorArray[((y * srcBitmap.getWidth() + x))] = rgbcolor;
	}

	public int[] getColorArray() {
		return colorArray;
	}

	public Bitmap getDstBitmap() {
		dstBitmap.setPixels(colorArray, 0, width, 0, 0, width, height);
		return dstBitmap;
	}

	public int safeColor(int a) {
		if (a < 0)
			return 0;
		else if (a > 255)
			return 255;
		else
			return a;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
