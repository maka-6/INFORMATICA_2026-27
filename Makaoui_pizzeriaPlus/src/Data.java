/*
	Autore: Makaoui Youness
	Classe: 5G
	Data: 19/10/2026
	Oggetto:
*/


class Data {
	
	private int hour, min;
	
	private static final int DATA_DIM = 4 + 4;
	
	public Data(){
		hour = 12;
		min = 0;
	}
	
	public Data(int hour, int min){
		this.hour = hour;
		this.min = min;
	}
	
	public int getHour(){
		return hour;
	}
	
	public int getMin(){
		return min;
	}
	
	public static int getByteDIM(){
		return DATA_DIM;
	}
	
	@Override
	public String toString(){
		return hour + ":" + min;
	}
}