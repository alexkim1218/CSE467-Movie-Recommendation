package com.movie.bean;

public class Movie {

private int index;
private String movie_title;
private String plot;

public Movie(){
	
}

public int getIndex() {
	return index;
}
public void setIndex(int index) {
	this.index = index;
}
public String getMovie_title() {
	return movie_title;
}
public void setMovie_title(String movieTitle) {
	movie_title = movieTitle;
}
public String getPlot() {
	return plot;
}
public void setPlot(String plot) {
	this.plot = plot;
}


}