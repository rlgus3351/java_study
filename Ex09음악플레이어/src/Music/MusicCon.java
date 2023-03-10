package Music;

import java.util.ArrayList;

import javazoom.jl.player.MP3Player;

public class MusicCon {

	private MP3Player mp3 = new MP3Player();
	private ArrayList<MusicDTO> musicList;

	public void stop() {
		if (mp3.isPlaying()) {
			mp3.stop();
		}
	}

	public void play(int index) {

		// 실제로 사용될때 올리기

		MusicDAO dao = new MusicDAO();
		musicList = dao.select();

		String singer = musicList.get(index).getSinger();
		String title = musicList.get(index).getTitle();
		String path = musicList.get(index).getPath();

		if (mp3.isPlaying()) {
			mp3.stop();
		}
		mp3.play(path);
		System.out.printf("%s - %s%n", singer, title);
	}

}
