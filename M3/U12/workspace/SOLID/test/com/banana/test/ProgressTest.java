package com.banana.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.banana.pojos.file.File;
import com.banana.pojos.file.Music;
import com.banana.pojos.file.Video;
import com.banana.util.Progress;

public class ProgressTest {

	@Test
	public void test50pcFile() {
		File myFile=new File();
		myFile.setLength(200);
		myFile.setSent(100);
		
		Progress progress=new Progress(myFile);
		assertEquals(50, progress.getAsPercent());
	}
	
	@Test
	public void test50pcMusic() {
		Music myMusic=new Music();
		myMusic.setLength(200);
		myMusic.setSent(100);
		
		Progress progress=new Progress(myMusic);
		
		assertEquals(50, progress.getAsPercent());
	}
	
	@Test
	public void test50pcVideo() {
		Video myVideo=new Video();
		
		Progress progress=new Progress(myVideo);
		
		assertEquals(50, progress.getAsPercent());
	}

}










