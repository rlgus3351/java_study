package Music;

import java.util.ArrayList;

import javazoom.jl.player.MP3Player;

public class Ex재생 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MP3Player mp3 = new MP3Player();

		// 노래의 경로가 필요
		String path = "C:/mp3/아이브-LoveDive.mp3";	
		mp3.play(path);

	}

}
