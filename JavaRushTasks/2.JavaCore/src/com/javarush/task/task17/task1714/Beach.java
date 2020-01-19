package com.javarush.task.task17.task1714;

/* 
Comparable
*/


public class Beach implements Comparable<Beach>{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
	//	Beach beach = new Beach("q", 100, 3);
	   // System.out.println(beach.compareTo(new Beach("name",50, 2)));
    }

	@Override
	public synchronized int compareTo(Beach o) {
    	int betterAt = 0;
    	betterAt = Float.compare(o.getDistance(), this.getDistance()) + Integer.compare(this.getQuality(), o.getQuality());
		return betterAt;
	}
}
