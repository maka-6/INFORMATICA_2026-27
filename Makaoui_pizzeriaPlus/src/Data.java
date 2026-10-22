/*
	Autore: Makaoui Youness
	Classe: 5G
	Data: 19/10/2026
	Oggetto:
*/


import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;

class Data {
	
	private int hour, min;
	
	private static final int DATA_DIM = 4 + 4;
	
	public Data(int hour, int min){
		this.hour = hour;
		this.min = min;
	}

	public Data(){
		this.hour = -1;
		this.min = -1;
	}

	public int getHour(){
		return hour;
	}
	
	public int getMin(){
		return min;
	}

	public static void salva(RandomAccessFile archivio, Data data) throws IOException {
		archivio.writeInt(data.hour);
		archivio.writeInt(data.min);
	}

	public static Data leggi(RandomAccessFile archivio) throws IOException {
		int hour = archivio.readInt();
		int min = archivio.readInt();
        return new Data(hour, min);
	}
	
	public static int getByteDIM(){
		return DATA_DIM;
	}
	
	@Override
	public String toString(){
		return String.format("%02d:%02d", hour, min);
	}
}